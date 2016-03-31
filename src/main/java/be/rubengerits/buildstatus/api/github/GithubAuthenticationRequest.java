package be.rubengerits.buildstatus.api.github;

import java.util.ArrayList;
import java.util.List;

public class GithubAuthenticationRequest {

    private final List<String> scopes = new ArrayList<String>();

    private String note;

    public List<String> getScopes() {
        return scopes;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
