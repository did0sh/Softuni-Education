package exodia.domain.models.binding;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class DocumentBindingModel {

    private String id;
    private String title;
    private String content;

    public DocumentBindingModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotEmpty
    @NotNull
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotEmpty
    @NotNull
    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
