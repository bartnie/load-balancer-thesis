package pl.bartek.thesis.master.domain.test.specification;

import pl.bartek.thesis.master.domain.loadbalancing.algorithm.LoadBalancingAlgorithmType;

public class TestSpecification {

    private int callsNumber;
    private LoadBalancingAlgorithmType algorithmType;

    public TestSpecification() {
    }

    public int getCallsNumber() {
        return callsNumber;
    }

    public void setCallsNumber(int callsNumber) {
        this.callsNumber = callsNumber;
    }

    public LoadBalancingAlgorithmType getAlgorithmType() {
        return algorithmType;
    }

    public void setAlgorithmType(LoadBalancingAlgorithmType algorithmType) {
        this.algorithmType = algorithmType;
    }

    @Override
    public String toString() {
        return "TestSpecification{" +
                "callsNumber=" + callsNumber +
                ", algorithmType=" + algorithmType +
                '}';
    }
}
