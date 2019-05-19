package pl.bartek.thesis.master.service.configuration.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.bartek.thesis.master.converter.worker.configuration.WorkerConfigurationConverter;
import pl.bartek.thesis.master.domain.worker.configuraton.WorkerConfiguration;
import pl.bartek.thesis.master.dto.worker.configuration.WorkerConfigurationDto;
import pl.bartek.thesis.master.service.configuration.ConfigurationService;

@Component
public class ConfigurationServiceImpl implements ConfigurationService {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigurationServiceImpl.class);
    private static final String WORKER_CONFIGURATION_ENDPOINT = "/configuration";

    private final WorkerConfigurationConverter configurationConverter;
    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    public ConfigurationServiceImpl(final WorkerConfigurationConverter configurationConverter) {
        this.configurationConverter = configurationConverter;
    }

    @Override
    public boolean sendConfiguration(final WorkerConfiguration configuration) {
        final WorkerConfigurationDto configurationDto = configurationConverter.convert(configuration);
        LOG.info("MAKING call with configuration");
        restTemplate.postForLocation(configuration.getInstanceURI().resolve(WORKER_CONFIGURATION_ENDPOINT), configuration);
        return true;
    }
}
