package be.rubengerits.buildstatus.api.travisci;

import be.rubengerits.buildstatus.api.global.BuildStatus;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class BuildStatusAdapter extends TypeAdapter<BuildStatus> {
    @Override
    public void write(JsonWriter out, BuildStatus value) throws IOException {
        out.value(value.getName());
    }

    @Override
    public BuildStatus read(JsonReader in) throws IOException {
        return BuildStatus.fromName(in.nextString());
    }
}
