package pl.bartek.thesis.master.service.test.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.bartek.thesis.master.domain.loadbalancing.algorithm.LoadBalancingAlgorithmType;
import pl.bartek.thesis.master.domain.test.result.TestResult;
import pl.bartek.thesis.master.domain.test.specification.TestSpecification;
import pl.bartek.thesis.master.loadbalanding.LoadBalancer;
import pl.bartek.thesis.master.loadbalanding.strategy.LoadBalancerStrategy;
import pl.bartek.thesis.master.service.test.TestService;

import java.net.URI;
import java.util.stream.IntStream;

@Component
public class TestServiceImpl implements TestService {
    private static final Logger LOG = LoggerFactory.getLogger(TestServiceImpl.class);
    private static final String WORKER_WORK_ENDPOINT = "/work";

    private final LoadBalancerStrategy loadBalancerStrategy;
    private LoadBalancer currentLoadBalancer;
    private final RestTemplate restTemplate;

    @Autowired
    public TestServiceImpl(final LoadBalancerStrategy loadBalancerStrategy) {
        this.loadBalancerStrategy = loadBalancerStrategy;
        this.currentLoadBalancer = loadBalancerStrategy.getDefaultLoadBalancer();
        this.restTemplate = new RestTemplate();
    }

    @Override
    public TestResult testLoadBalancer(final TestSpecification testSpecification) {
        changeLoadBalancerAlgorithm(testSpecification.getAlgorithmType());
        runTest(testSpecification.getCallsNumber());
        return null;
    }

    private void changeLoadBalancerAlgorithm(final LoadBalancingAlgorithmType algorithmType) {
        LOG.info("CHANGING load balancing algorithm implementation to: {}", algorithmType.getDisplayName());
        currentLoadBalancer = loadBalancerStrategy.getLoadBalancer(algorithmType);
    }

    private void runTest(final int callsNumber) {
        LOG.info("STARTING test with {} {}", callsNumber, (callsNumber > 1 ? "calls" : "call"));
        IntStream.rangeClosed(1, callsNumber).forEach(i -> {
            LOG.info("CALL {}", i);
            makeRequest();
        });
    }

    private void makeRequest(){
        final URI targetURI = currentLoadBalancer.getInstanceURI().resolve(WORKER_WORK_ENDPOINT);
        restTemplate.getForEntity(targetURI, String.class);
    }
}
