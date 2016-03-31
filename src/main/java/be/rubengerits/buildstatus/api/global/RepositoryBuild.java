package be.rubengerits.buildstatus.api.global;

import be.rubengerits.buildstatus.api.travisci.Build;

import java.util.List;

public class RepositoryBuild implements WebserviceError {
    private List<Build> builds;

    private Integer status;

    private String message;

    public RepositoryBuild() {
    }

    public RepositoryBuild(List<Build> builds) {
        this.builds = builds;
    }

    public List<Build> getBuilds() {
        return builds;
    }

    public void setBuilds(List<Build> builds) {
        this.builds = builds;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
