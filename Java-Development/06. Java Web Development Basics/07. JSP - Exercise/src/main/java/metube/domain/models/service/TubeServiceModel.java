package metube.domain.models.service;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class TubeServiceModel {

    private String id;
    private String name;
    private String description;
    private String youtubeLink;
    private String uploader;

    public TubeServiceModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Pattern(regexp = "https:\\/\\/www\\.youtube\\.com\\/watch\\?v=[A-Za-z0-9]{11}")
    public String getYoutubeLink() {
        return this.youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    @NotNull
    @Size(min = 2)
    public String getUploader() {
        return this.uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}
