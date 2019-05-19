package pl.bartek.thesis.master.loadbalanding.strategy;

import pl.bartek.thesis.master.domain.loadbalancing.algorithm.LoadBalancingAlgorithmType;
import pl.bartek.thesis.master.loadbalanding.LoadBalancer;

public interface LoadBalancerStrategy {
    LoadBalancer getLoadBalancer(final LoadBalancingAlgorithmType algorithmType);
    LoadBalancer getDefaultLoadBalancer();
}
