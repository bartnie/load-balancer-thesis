package pl.bartek.thesis.master.dto.worker.configuration;

import pl.bartek.thesis.master.domain.distribution.DistributionType;

public class WorkerConfigurationDto {

    private int delay;
    private int distribution;
    private DistributionType distributionType;

    public WorkerConfigurationDto() {
    }

    public WorkerConfigurationDto(final int delay, final int distribution, final DistributionType distributionType) {
        this.delay = delay;
        this.distribution = distribution;
        this.distributionType = distributionType;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(final int delay) {
        this.delay = delay;
    }

    public int getDistribution() {
        return distribution;
    }

    public void setDistribution(final int distribution) {
        this.distribution = distribution;
    }

    public DistributionType getDistributionType() {
        return distributionType;
    }

    public void setDistributionType(final DistributionType distributionType) {
        this.distributionType = distributionType;
    }
}
