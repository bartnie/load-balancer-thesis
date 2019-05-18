package pl.bartek.thesis.master.domain.worker.configuraton;

import pl.bartek.thesis.master.domain.distribution.DistributionType;

public class WorkerConfiguration {

    private final String ip;
    private int delay;
    private int distribution;
    private DistributionType distributionType;

    public WorkerConfiguration(final String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
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
        return "WorkerConfiguration{" +
                "ip=" + ip +
                ", delay=" + delay +
                ", distribution=" + distribution +
                ", distributionType=" + distributionType +
                '}';
    }
}
