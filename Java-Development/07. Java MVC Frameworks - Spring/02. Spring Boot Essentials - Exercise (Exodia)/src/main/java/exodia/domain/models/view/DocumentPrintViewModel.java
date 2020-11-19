package exodia.domain.models.view;

public class DocumentPrintViewModel {

    private String id;
    private String title;
    private String content;

    public DocumentPrintViewModel() {
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        if (title.length() >= 12){
            this.title = title.substring(0, 12) + "...";
        } else {
            this.title = title;
        }
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
