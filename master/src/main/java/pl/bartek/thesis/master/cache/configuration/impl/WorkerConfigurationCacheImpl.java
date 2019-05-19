package pl.bartek.thesis.master.cache.configuration.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import pl.bartek.thesis.master.cache.configuration.WorkerConfigurationCache;
import pl.bartek.thesis.master.domain.worker.configuraton.WorkerConfiguration;

import java.net.URI;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class WorkerConfigurationCacheImpl implements WorkerConfigurationCache {
    private static final Logger LOG = LoggerFactory.getLogger(WorkerConfigurationCacheImpl.class);

    private final DiscoveryClient discoveryClient;
    private final Map<String, WorkerConfiguration> configurations = new ConcurrentHashMap<>();

    @Value("${worker.serviceId}")
    private String workerServiceId;

    @Autowired
    public WorkerConfigurationCacheImpl(final DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @Override
    public void updateConfiguration(final WorkerConfiguration configuration) {
        LOG.info("UPDATING configurations in cache");
        LOG.info("OLD configuration: {}", configurations);
        configurations.computeIfPresent(configuration.getInstanceURI().toString(), (k, v) -> configuration);
        LOG.info("NEW configuration: {}", configurations);
    }

    @Override
    public List<WorkerConfiguration> getConfigurationsList() {
        updateWorkersFromDiscoveryServer();
        return configurations.values().stream()
                .filter(conf -> Objects.nonNull(conf.getInstanceURI()))
                .sorted(Comparator.comparing(WorkerConfiguration::getInstanceURI))
                .collect(Collectors.toList());
    }

    private void updateWorkersFromDiscoveryServer() {
        LOG.info("UPDATING workers (with serviceId: {}) in cache from Discovery Server", workerServiceId);
        final List<ServiceInstance> instances = discoveryClient.getInstances(workerServiceId);
        final List<URI> instancesURI = instances.stream()
                .map(ServiceInstance::getUri)
                .collect(Collectors.toList());

        removeStoppedWorkers(instancesURI);
        addNewWorkers(instancesURI);
    }

    private void removeStoppedWorkers(final List<URI> runningWorkersURI) {
        configurations.entrySet().stream()
                .filter(entry -> !runningWorkersURI.contains(entry.getValue().getInstanceURI()))
                .forEach(entry -> {
                    LOG.info("REMOVING configuration with URI: {}", entry.getValue().getInstanceURI());
                    configurations.remove(entry.getKey());
                });
    }

    private void addNewWorkers(final List<URI> runningWorkersURI) {
        runningWorkersURI.forEach(workerURI ->
                configurations.computeIfAbsent(workerURI.toString(), k -> {
                    LOG.info("ADDING configuration with URI: {}", workerURI);
                    return new WorkerConfiguration(workerURI);
                }));
    }
}
