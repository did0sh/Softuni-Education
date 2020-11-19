package exam.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "documents")
public class Document extends BaseEntity {

    private String title;
    private String content;

    public Document() {
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
