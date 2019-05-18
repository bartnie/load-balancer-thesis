package pl.bartek.thesis.master.domain.loadbalancing.algorithm;

public enum LoadBalancingAlgorithmType {
    ROUND_ROBIN("Round robin"), WEIGHTED("Weighted");

    private String displayName;

    LoadBalancingAlgorithmType(final String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
