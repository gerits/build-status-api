package be.rubengerits.buildstatus.api.global;

import java.util.List;

public class Repositories implements WebserviceError {
    private List<Repository> repositories;

    private Integer status;

    private String message;

    public Repositories() {
    }

    public Repositories(List<Repository> repositories) {
        this.repositories = repositories;
    }

    public List<Repository> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repository> repositories) {
        this.repositories = repositories;
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
