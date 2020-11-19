package cardealer.domain.dto;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;

public class SupplierSeedDto {

    @Expose
    private String name;

    @Expose
    private boolean isImporter;

    public SupplierSeedDto() {
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public boolean isImporter() {
        return this.isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
