package blobs.models;

import java.util.LinkedHashMap;
import java.util.Map;

public class BlobRepository {
    private Map<String, Blob> repository;
    private boolean isEventReportTriggered;

    public BlobRepository() {
        this.repository = new LinkedHashMap<>();
        this.isEventReportTriggered = false;
    }

    public Blob find(String name) {
        return this.repository.get(name);
    }

    public void add(Blob blob) {
        this.repository.put(blob.getName(), blob);
    }

    public void update() {
        this.repository.values().forEach(Blob::update);
    }

    public String printStatus() {
        StringBuilder sb = new StringBuilder();
        for (Blob blob : this.repository.values()) {
            sb.append(blob).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    public void triggerReportEvents() {
        this.isEventReportTriggered = true;
    }

    public boolean isEventReportTriggered() {
        return this.isEventReportTriggered;
    }
}
