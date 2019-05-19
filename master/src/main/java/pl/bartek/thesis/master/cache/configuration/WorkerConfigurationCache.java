package pl.bartek.thesis.master.cache.configuration;

import pl.bartek.thesis.master.domain.worker.configuraton.WorkerConfiguration;

import java.util.List;

public interface WorkerConfigurationCache {
    void updateConfiguration(final WorkerConfiguration configuration);

    List<WorkerConfiguration> getConfigurationsList();
}
