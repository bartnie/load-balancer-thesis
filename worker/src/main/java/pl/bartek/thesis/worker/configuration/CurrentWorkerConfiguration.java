package pl.bartek.thesis.worker.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.bartek.thesis.worker.domain.distribution.DistributionType;
import pl.bartek.thesis.worker.dto.configuration.WorkerConfigurationDto;

@Component
public class CurrentWorkerConfiguration {
    private static final Logger LOG = LoggerFactory.getLogger(CurrentWorkerConfiguration.class);


    private int delay;
    private int distribution;
    private DistributionType distributionType;

    public int getDelay() {
        return delay;
    }


    public int getDistribution() {
        return distribution;
    }


    public DistributionType getDistributionType() {
        return distributionType;
    }

    public void changeConfiguration(final WorkerConfigurationDto configurationDto) {
        LOG.info("Changing current configuration");

        this.delay = configurationDto.getDelay();
        this.distribution = configurationDto.getDistribution();
        this.distributionType = configurationDto.getDistributionType();
    }

    public WorkerConfigurationDto gatCurrentConfigurationDto() {
        return new WorkerConfigurationDto(delay, distribution, distributionType);
    }

    @Override
    public String toString() {
        return "WorkerConfiguration{" +
                ", delay=" + delay +
                ", distribution=" + distribution +
                ", distributionType=" + distributionType +
                '}';
    }
}
