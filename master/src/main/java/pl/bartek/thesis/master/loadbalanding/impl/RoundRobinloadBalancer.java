package pl.bartek.thesis.master.loadbalanding.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bartek.thesis.master.cache.configuration.WorkerConfigurationCache;
import pl.bartek.thesis.master.domain.worker.configuraton.WorkerConfiguration;
import pl.bartek.thesis.master.loadbalanding.LoadBalancer;

import java.net.URI;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class RoundRobinloadBalancer implements LoadBalancer {
    private final WorkerConfigurationCache instancesCache;
    private static final AtomicLong CALL_INDEX = new AtomicLong(0);

    @Autowired
    public RoundRobinloadBalancer(final WorkerConfigurationCache instancesCache) {
        this.instancesCache = instancesCache;
    }

    @Override
    public URI getInstanceURI() {
        final List<WorkerConfiguration> instancesList = instancesCache.getConfigurationsList();
        final WorkerConfiguration pickedInstance = instancesList.get((int) (CALL_INDEX.getAndIncrement() % instancesList.size()));
        return pickedInstance.getInstanceURI();
    }
}
