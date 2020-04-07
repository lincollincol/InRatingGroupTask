package linc.com.inratingtask.domain.models;

public class AvatarImageEntity {

    private String urlMedium;
    private int id;
    private String url;
    private String urlLarge;
    private String urlSmall;
    private String urlOrigin;
    private String urlMediumOrigin;
    private String urlLargeOrigin;
    private String urlSmallOrigin;
    private int mentionedUsersCount;

    public String getUrlMedium() {
        return urlMedium;
    }

    public void setUrlMedium(String urlMedium) {
        this.urlMedium = urlMedium;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlLarge() {
        return urlLarge;
    }

    public void setUrlLarge(String urlLarge) {
        this.urlLarge = urlLarge;
    }

    public String getUrlSmall() {
        return urlSmall;
    }

    public void setUrlSmall(String urlSmall) {
        this.urlSmall = urlSmall;
    }

    public String getUrlOrigin() {
        return urlOrigin;
    }

    public void setUrlOrigin(String urlOrigin) {
        this.urlOrigin = urlOrigin;
    }

    public String getUrlMediumOrigin() {
        return urlMediumOrigin;
    }

    public void setUrlMediumOrigin(String urlMediumOrigin) {
        this.urlMediumOrigin = urlMediumOrigin;
    }

    public String getUrlLargeOrigin() {
        return urlLargeOrigin;
    }

    public void setUrlLargeOrigin(String urlLargeOrigin) {
        this.urlLargeOrigin = urlLargeOrigin;
    }

    public String getUrlSmallOrigin() {
        return urlSmallOrigin;
    }

    public void setUrlSmallOrigin(String urlSmallOrigin) {
        this.urlSmallOrigin = urlSmallOrigin;
    }

    public int getMentionedUsersCount() {
        return mentionedUsersCount;
    }

    public void setMentionedUsersCount(int mentionedUsersCount) {
        this.mentionedUsersCount = mentionedUsersCount;
    }
}
