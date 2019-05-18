package pl.bartek.thesis.worker.dto.configuration;

import pl.bartek.thesis.worker.domain.distribution.DistributionType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class WorkerConfigurationDto {

    @Min(0)
    private Integer delay;

    @Min(0)
    private Integer distribution;

    @NotNull
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

    @Override
    public String toString() {
        return "WorkerConfigurationDto{" +
                "delay=" + delay +
                ", distribution=" + distribution +
                ", distributionType=" + distributionType +
                '}';
    }
}