package pl.bartek.thesis.worker.distribution.strategy;

import pl.bartek.thesis.worker.distribution.DistributionType;

public interface DistributionStrategy {
    double getRandomByDistribution(final DistributionType distributionType);
}
