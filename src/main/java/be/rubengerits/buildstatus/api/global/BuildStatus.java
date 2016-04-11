package be.rubengerits.buildstatus.api.global;

import java.util.Arrays;
import java.util.List;

public enum BuildStatus implements Comparable<BuildStatus> {

    STATUS_LOGIN(Arrays.asList("login"), 100),
    STATUS_BUILDING(Arrays.asList("created", "started", "received", "queued"), 40),
    STATUS_FAILING(Arrays.asList("failed", "errored", "canceled"), 30),
    STATUS_PASSING(Arrays.asList("passed", "ready"), 20),
    STATUS_UNKNOWN(null, 0);

    private List<String> names;

    private final int weight;

    BuildStatus(List<String> names, int weight) {
        this.names = names;
        this.weight = weight;
    }

    public List<String> getNames() {
        return names;
    }

    public String getName() {
        if (names != null && names.size() > 0) {
            return names.get(0);
        }
        return null;
    }

    public int getWeight() {
        return weight;
    }

    public static BuildStatus fromName(String name) {
        if (STATUS_LOGIN.getNames().contains(name)) {
            return STATUS_LOGIN;
        } else if (STATUS_BUILDING.getNames().contains(name)) {
            return STATUS_BUILDING;
        } else if (STATUS_FAILING.getNames().contains(name)) {
            return STATUS_FAILING;
        } else if (STATUS_PASSING.getNames().contains(name)) {
            return STATUS_PASSING;
        }
        return STATUS_UNKNOWN;
    }

}