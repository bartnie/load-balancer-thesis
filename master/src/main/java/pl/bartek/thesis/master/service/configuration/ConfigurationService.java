package pl.bartek.thesis.master.service.configuration;

import pl.bartek.thesis.master.domain.worker.configuraton.WorkerConfiguration;

public interface ConfigurationService {
    boolean sendConfiguration(final WorkerConfiguration configuration);
}
