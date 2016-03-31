package be.rubengerits.buildstatus.api.global;

import be.rubengerits.buildstatus.api.travisci.BuildStatusAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * Note: this class has a natural ordering that is inconsistent with equals.
 */
public class Repository implements Comparable<Repository> {

    private int id;
    @SerializedName("slug")
    private String name;
    private String description;
    @SerializedName("last_build_id")
    private Integer lastBuildId;
    @SerializedName("last_build_number")
    private String lastBuildNumber;
    @SerializedName("last_build_state")
    @JsonAdapter(BuildStatusAdapter.class)
    private BuildStatus lastBuildStatus;
    @SerializedName("last_build_duration")
    private long lastBuildDuration;
    @SerializedName("last_build_started_at")
    private Date lastBuildStartedAt;
    @SerializedName("last_build_finished_at")
    private Date lastBuildFinishedAt;
    @SerializedName("github_language")
    private String githubLanguage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLastBuildId() {
        return lastBuildId;
    }

    public void setLastBuildId(Integer lastBuildId) {
        this.lastBuildId = lastBuildId;
    }

    public String getLastBuildNumber() {
        return lastBuildNumber;
    }

    public void setLastBuildNumber(String lastBuildNumber) {
        this.lastBuildNumber = lastBuildNumber;
    }

    public BuildStatus getLastBuildStatus() {
        return lastBuildStatus;
    }

    public void setLastBuildStatus(BuildStatus lastBuildStatus) {
        this.lastBuildStatus = lastBuildStatus;
    }

    public long getLastBuildDuration() {
        return lastBuildDuration;
    }

    public void setLastBuildDuration(long lastBuildDuration) {
        this.lastBuildDuration = lastBuildDuration;
    }

    public Date getLastBuildStartedAt() {
        return lastBuildStartedAt;
    }

    public void setLastBuildStartedAt(Date lastBuildStartedAt) {
        this.lastBuildStartedAt = lastBuildStartedAt;
    }

    public Date getLastBuildFinishedAt() {
        return lastBuildFinishedAt;
    }

    public void setLastBuildFinishedAt(Date lastBuildFinishedAt) {
        this.lastBuildFinishedAt = lastBuildFinishedAt;
    }

    public String getGithubLanguage() {
        return githubLanguage;
    }

    public void setGithubLanguage(String githubLanguage) {
        this.githubLanguage = githubLanguage;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Repository rhs = (Repository) obj;

        EqualsBuilder builder = new EqualsBuilder();
        builder.append(id, rhs.id);
        builder.append(name, rhs.name);
        return builder.isEquals();
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(id);
        builder.append(name);
        return builder.hashCode();
    }

    public int compareTo(Repository o) {
        CompareToBuilder builder = new CompareToBuilder();
        builder.append(lastBuildStatus, o.getLastBuildStatus());
        builder.append(lastBuildFinishedAt, o.getLastBuildFinishedAt());
        builder.append(name, o.getName());
        builder.append(id, o.getId());
        return builder.toComparison();
    }
}
