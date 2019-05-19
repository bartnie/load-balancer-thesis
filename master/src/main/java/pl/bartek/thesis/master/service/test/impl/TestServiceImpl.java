package pl.bartek.thesis.master.service.test.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bartek.thesis.master.client.WorkerClient;
import pl.bartek.thesis.master.domain.loadbalancing.algorithm.LoadBalancingAlgorithmType;
import pl.bartek.thesis.master.domain.test.result.TestResult;
import pl.bartek.thesis.master.domain.test.specification.TestSpecification;
import pl.bartek.thesis.master.service.test.TestService;

import java.util.stream.IntStream;

@Component
public class TestServiceImpl implements TestService {
    private static final Logger LOG = LoggerFactory.getLogger(TestServiceImpl.class);

    private final WorkerClient workerClient;

    @Autowired
    public TestServiceImpl(final WorkerClient workerClient) {
        this.workerClient = workerClient;
    }

    @Override
    public TestResult testLoadBalancer(final TestSpecification testSpecification) {
        changeLoadBalancerAlgorithm(testSpecification.getAlgorithmType());
        runTest(testSpecification.getCallsNumber());
        return null;
    }

    private void changeLoadBalancerAlgorithm(final LoadBalancingAlgorithmType algorithmType) {
        LOG.info("CHANGING load balancing algorithm implementation to: {}", algorithmType.getDisplayName());
    }

    private void runTest(final int callsNumber) {
        LOG.info("STARTING test with {} {}", callsNumber, (callsNumber > 1 ? "calls" : "call"));
        IntStream.rangeClosed(1, callsNumber).forEach(i -> {
            LOG.info("CALL {}", i);
            workerClient.doWork();
        });
    }
}
