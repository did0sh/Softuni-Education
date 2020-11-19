package cardealer.domain.dto;

import com.google.gson.annotations.Expose;

public class LocalSupplierDto {

    @Expose
    private Integer id;

    @Expose
    private String name;

    @Expose
    private Integer partsCount;

    public LocalSupplierDto() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPartsCount() {
        return this.partsCount;
    }

    public void setPartsCount(Integer partsCount) {
        this.partsCount = partsCount;
    }
}
