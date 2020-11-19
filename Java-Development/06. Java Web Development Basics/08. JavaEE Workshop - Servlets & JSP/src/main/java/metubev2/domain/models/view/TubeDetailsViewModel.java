package metubev2.domain.models.view;

public class TubeDetailsViewModel {

    private String title;
    private String author;
    private String description;
    private String youtubeId;
    private long views;

    public TubeDetailsViewModel() {
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYoutubeId() {
        return this.youtubeId;
    }

    public void setYoutubeId(String youtubeId) {
        this.youtubeId = youtubeId;
    }

    public long getViews() {
        return this.views;
    }

    public void setViews(long views) {
        this.views = views;
    }
}
