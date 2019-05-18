package pl.bartek.thesis.master.converter.worker.configuration.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.bartek.thesis.master.controller.ConfigurationController;
import pl.bartek.thesis.master.converter.worker.configuration.WorkerConfigurationConverter;
import pl.bartek.thesis.master.domain.worker.configuraton.WorkerConfiguration;
import pl.bartek.thesis.master.dto.worker.configuration.WorkerConfigurationDto;

@Component
public class WorkerConfigurationConverterImpl implements WorkerConfigurationConverter {
    private static final Logger LOG = LoggerFactory.getLogger(WorkerConfigurationConverterImpl.class);

    @Override
    public WorkerConfigurationDto convert(final WorkerConfiguration configuration) {
        LOG.info("Converting configuration to DTO");
        return new WorkerConfigurationDto(configuration.getDelay(), configuration.getDistribution(), configuration.getDistributionType());
    }
}
