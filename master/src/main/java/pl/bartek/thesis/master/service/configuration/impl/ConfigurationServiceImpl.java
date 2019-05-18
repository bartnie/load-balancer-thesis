package pl.bartek.thesis.master.service.configuration.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bartek.thesis.master.converter.worker.configuration.WorkerConfigurationConverter;
import pl.bartek.thesis.master.domain.worker.configuraton.WorkerConfiguration;
import pl.bartek.thesis.master.dto.worker.configuration.WorkerConfigurationDto;
import pl.bartek.thesis.master.service.configuration.ConfigurationService;

@Component
public class ConfigurationServiceImpl implements ConfigurationService {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigurationServiceImpl.class);

    private final WorkerConfigurationConverter configurationConverter;

    @Autowired
    public ConfigurationServiceImpl(final WorkerConfigurationConverter configurationConverter) {
        this.configurationConverter = configurationConverter;
    }

//    @Resource
//    private RestTemplate restTemplate;

    @Override
    public boolean sendConfiguration(final WorkerConfiguration configuration) {
//        final String URL = "https://webhook.site/6d0e8fcc-9142-4fe1-95fb-a2c6a3e82651";

        final WorkerConfigurationDto configurationDto = configurationConverter.convert(configuration);
        LOG.info("Making call with configuration");
//        final RestTemplate restTemplate = new RestTemplate();
//        final URI result = restTemplate.postForLocation(URL, configuration);

        return false;
    }
}
