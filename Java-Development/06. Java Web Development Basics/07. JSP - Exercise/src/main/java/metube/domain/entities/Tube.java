package metube.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "tubes")
public class Tube extends BaseEntity {

    private String name;
    private String description;
    private String youtubeLink;
    private String uploader;

    public Tube() {
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "youtube_link")
    public String getYoutubeLink() {
        return this.youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    @Column(name = "uploader")
    public String getUploader() {
        return this.uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}
