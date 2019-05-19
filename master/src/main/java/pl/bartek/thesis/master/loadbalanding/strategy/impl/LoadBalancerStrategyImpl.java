package pl.bartek.thesis.master.loadbalanding.strategy.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.bartek.thesis.master.domain.loadbalancing.algorithm.LoadBalancingAlgorithmType;
import pl.bartek.thesis.master.loadbalanding.LoadBalancer;
import pl.bartek.thesis.master.loadbalanding.impl.RoundRobinloadBalancer;
import pl.bartek.thesis.master.loadbalanding.strategy.LoadBalancerStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class LoadBalancerStrategyImpl implements LoadBalancerStrategy {
    private final Map<LoadBalancingAlgorithmType, LoadBalancer> loadBalancers = new ConcurrentHashMap<>();

    @Autowired
    public LoadBalancerStrategyImpl(final RoundRobinloadBalancer roundRobinloadBalancer) {
        loadBalancers.put(LoadBalancingAlgorithmType.ROUND_ROBIN, roundRobinloadBalancer);
    }

    @Override
    public LoadBalancer getLoadBalancer(final LoadBalancingAlgorithmType algorithmType) {
        return loadBalancers.get(algorithmType);
    }

    @Override
    public LoadBalancer getDefaultLoadBalancer() {
        return loadBalancers.get(LoadBalancingAlgorithmType.ROUND_ROBIN);
    }
}
