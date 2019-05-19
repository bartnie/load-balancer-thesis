package pl.bartek.thesis.worker.service.work.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bartek.thesis.worker.configuration.CurrentWorkerConfiguration;
import pl.bartek.thesis.worker.distribution.strategy.DistributionStrategy;
import pl.bartek.thesis.worker.service.work.WorkService;

@Component
public class WorkServiceImpl implements WorkService {
    private static final Logger LOG = LoggerFactory.getLogger(WorkServiceImpl.class);

    private final CurrentWorkerConfiguration currentConfiguration;
    private final DistributionStrategy distributionStrategy;

    @Autowired
    public WorkServiceImpl(final CurrentWorkerConfiguration currentConfiguration, final DistributionStrategy distributionStrategy) {
        this.currentConfiguration = currentConfiguration;
        this.distributionStrategy = distributionStrategy;
    }

    @Override
    public void doWork() {
        final long totalDelay = getTotalDelay();
        LOG.info("EXECUTING work request with total delay time {}", totalDelay);
        try {
            Thread.sleep(totalDelay);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
        LOG.info("WORK completed");
    }

    private long getTotalDelay() {
        final int constDelayTime = currentConfiguration.getDelay();
        final double distributionDelayTime = currentConfiguration.getDistribution() *
                distributionStrategy.getRandomByDistribution(currentConfiguration.getDistributionType());
        final double totalDelay = constDelayTime + distributionDelayTime;
        return (long) totalDelay;
    }
}
