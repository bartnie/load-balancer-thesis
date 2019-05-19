package pl.bartek.thesis.worker.distribution.strategy.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.bartek.thesis.worker.distribution.DistributionType;
import pl.bartek.thesis.worker.distribution.strategy.DistributionStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.DoubleSupplier;

@Component
public class DistributionStrategyImpl implements DistributionStrategy {
    private static final Logger LOG = LoggerFactory.getLogger(DistributionStrategyImpl.class);

    private static final Random randomNumberGenderator = new Random();
    private final Map<DistributionType, DoubleSupplier> distributions = new HashMap<>();

    public DistributionStrategyImpl() {
        distributions.put(DistributionType.NORMAL, normalDoubleSupplier());
        distributions.put(DistributionType.UNIFORM, uniformDoubleSupplier());
    }

    @Override
    public double getRandomByDistribution(final DistributionType distributionType) {
        LOG.info("PICKED distribution: {}", distributionType);
        return distributions.get(distributionType).getAsDouble();
    }

    private DoubleSupplier normalDoubleSupplier() {
        return randomNumberGenderator::nextDouble;
    }

    private DoubleSupplier uniformDoubleSupplier() {
        return randomNumberGenderator::nextGaussian;
    }

}
