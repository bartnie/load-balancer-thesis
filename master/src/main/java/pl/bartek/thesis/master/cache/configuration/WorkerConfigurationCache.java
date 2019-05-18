package pl.bartek.thesis.master.cache.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.bartek.thesis.master.domain.worker.configuraton.WorkerConfiguration;

import java.util.HashMap;
import java.util.Map;

public class WorkerConfigurationCache {
    private static final Logger LOG = LoggerFactory.getLogger(WorkerConfigurationCache.class);
    public static final Map<String, WorkerConfiguration> CACHE = new HashMap<>();

    static {
        LOG.info("Creating cache");
        CACHE.put("127.0.0.1", new WorkerConfiguration("127.0.0.1"));
        CACHE.put("255.127.0.1", new WorkerConfiguration("255.127.0.1"));
    }
}
