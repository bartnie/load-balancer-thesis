package pl.bartek.thesis.master.service.test.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.bartek.thesis.master.domain.loadbalancing.algorithm.LoadBalancingAlgorithmType;
import pl.bartek.thesis.master.domain.test.result.TestResult;
import pl.bartek.thesis.master.domain.test.specification.TestSpecification;
import pl.bartek.thesis.master.service.test.TestService;

@Component
public class TestServiceImpl implements TestService {
    private static final Logger LOG = LoggerFactory.getLogger(TestServiceImpl.class);

    @Override
    public TestResult testLoadBalancer(final TestSpecification testSpecification) {
        changeLoadBalancerAlgorithm(testSpecification.getAlgorithmType());
        runTest(testSpecification.getCallsNumber());
        return null;
    }

    private void changeLoadBalancerAlgorithm(final LoadBalancingAlgorithmType algorithmType) {
        LOG.info("Changing load balancing algorithm implementation to: {}", algorithmType.getDisplayName());
    }

    private void runTest(final int callsNumber) {
        LOG.info("Starting test with {} {}", callsNumber, (callsNumber > 1 ? "calls" : "call"));
    }
}
