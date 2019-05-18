package pl.bartek.thesis.master.converter.worker.configuration;

import pl.bartek.thesis.master.domain.worker.configuraton.WorkerConfiguration;
import pl.bartek.thesis.master.dto.worker.configuration.WorkerConfigurationDto;

public interface WorkerConfigurationConverter {
    WorkerConfigurationDto convert(final WorkerConfiguration configuration);
}
