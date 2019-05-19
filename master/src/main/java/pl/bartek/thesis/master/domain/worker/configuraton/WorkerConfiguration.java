package pl.bartek.thesis.master.domain.worker.configuraton;

import pl.bartek.thesis.master.domain.distribution.DistributionType;

import java.net.URI;

public class WorkerConfiguration {

    private URI instanceURI;
    private int delay;
    private int distribution;
    private DistributionType distributionType;

    public WorkerConfiguration() {
        this.delay = 0;
        this.distribution = 0;
        this.distributionType = DistributionType.NORMAL;
    }

    public WorkerConfiguration(final URI instanceURI) {
        this();
        this.instanceURI = instanceURI;
    }

    public void setInstanceURI(final URI instanceURI) {
        this.instanceURI = instanceURI;
    }

    public URI getInstanceURI() {
        return instanceURI;
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
                "instanceURI=" + instanceURI +
                ", delay=" + delay +
                ", distribution=" + distribution +
                ", distributionType=" + distributionType +
                '}';
    }
}
