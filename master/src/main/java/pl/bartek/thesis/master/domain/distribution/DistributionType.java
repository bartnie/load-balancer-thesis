package pl.bartek.thesis.master.domain.distribution;

public enum DistributionType {
    NORMAL("Normal"), UNIFORM("Uniform");

    private String displayName;

    DistributionType(final String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
