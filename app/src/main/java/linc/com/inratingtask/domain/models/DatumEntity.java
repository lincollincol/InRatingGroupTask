package linc.com.inratingtask.domain.models;

public class DatumEntity {

    private int id;
    private String nickname;
    private ActiveGiftEntity activeGift;
    private AvatarImageEntity avatarImage;
    private boolean offPage;
    private String name;
    private String lastname;
    private String status;
    private String gender;
    private boolean isSubscribed;
    private boolean isOnline;
    private int lastOnlineTimestamp;
    private boolean inMyBlacklist;
    private boolean hasMeInBlacklist;
    private int multiplier;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public ActiveGiftEntity getActiveGift() {
        return activeGift;
    }

    public void setActiveGift(ActiveGiftEntity activeGift) {
        this.activeGift = activeGift;
    }

    public AvatarImageEntity getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(AvatarImageEntity avatarImage) {
        this.avatarImage = avatarImage;
    }

    public boolean isOffPage() {
        return offPage;
    }

    public void setOffPage(boolean offPage) {
        this.offPage = offPage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    public void setSubscribed(boolean subscribed) {
        isSubscribed = subscribed;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public int getLastOnlineTimestamp() {
        return lastOnlineTimestamp;
    }

    public void setLastOnlineTimestamp(int lastOnlineTimestamp) {
        this.lastOnlineTimestamp = lastOnlineTimestamp;
    }

    public boolean isInMyBlacklist() {
        return inMyBlacklist;
    }

    public void setInMyBlacklist(boolean inMyBlacklist) {
        this.inMyBlacklist = inMyBlacklist;
    }

    public boolean isHasMeInBlacklist() {
        return hasMeInBlacklist;
    }

    public void setHasMeInBlacklist(boolean hasMeInBlacklist) {
        this.hasMeInBlacklist = hasMeInBlacklist;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }
}
