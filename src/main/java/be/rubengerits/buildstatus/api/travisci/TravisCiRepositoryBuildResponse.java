package be.rubengerits.buildstatus.api.travisci;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TravisCiRepositoryBuildResponse {
    private List<Build> builds = new ArrayList<Build>();

    public List<Build> getBuilds() {
        return builds;
    }

    public void setBuilds(List<Build> builds) {
        this.builds = builds;
    }
}
