package be.rubengerits.buildstatus.api.travisci;

import be.rubengerits.buildstatus.api.global.BuildStatus;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Build {
    private Integer id;
    @SerializedName("commit_id")
    private Integer commitId;
    private Long duration;
    @SerializedName("started_at")
    private Date startedAt;
    @SerializedName("finished_at")
    private Date finishedAt;
    @SerializedName("pull_request")
    private boolean pullRequest;
    @SerializedName("pull_request_title")
    private String pullRequestTitle;
    @JsonAdapter(BuildStatusAdapter.class)
    @SerializedName("state")
    private BuildStatus status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommitId() {
        return commitId;
    }

    public void setCommitId(Integer commitId) {
        this.commitId = commitId;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Date getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(Date finishedAt) {
        this.finishedAt = finishedAt;
    }

    public boolean isPullRequest() {
        return pullRequest;
    }

    public void setPullRequest(boolean pullRequest) {
        this.pullRequest = pullRequest;
    }

    public String getPullRequestTitle() {
        return pullRequestTitle;
    }

    public void setPullRequestTitle(String pullRequestTitle) {
        this.pullRequestTitle = pullRequestTitle;
    }

    public BuildStatus getStatus() {
        return status;
    }

    public void setStatus(BuildStatus status) {
        this.status = status;
    }
}