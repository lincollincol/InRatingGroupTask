package linc.com.inratingtask.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("nickname")
    @Expose
    private String nickname;
    @SerializedName("active_gift")
    @Expose
    private ActiveGift activeGift;
    @SerializedName("avatar_image")
    @Expose
    private AvatarImage avatarImage;
    @SerializedName("off_page")
    @Expose
    private boolean offPage;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("is_subscribed")
    @Expose
    private boolean isSubscribed;
    @SerializedName("is_online")
    @Expose
    private boolean isOnline;
    @SerializedName("last_online_timestamp")
    @Expose
    private int lastOnlineTimestamp;
    @SerializedName("in_my_blacklist")
    @Expose
    private boolean inMyBlacklist;
    @SerializedName("has_me_in_blacklist")
    @Expose
    private boolean hasMeInBlacklist;
    @SerializedName("multiplier")
    @Expose
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

    public ActiveGift getActiveGift() {
        return activeGift;
    }

    public void setActiveGift(ActiveGift activeGift) {
        this.activeGift = activeGift;
    }

    public AvatarImage getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(AvatarImage avatarImage) {
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

    public boolean isIsSubscribed() {
        return isSubscribed;
    }

    public void setIsSubscribed(boolean isSubscribed) {
        this.isSubscribed = isSubscribed;
    }

    public boolean isIsOnline() {
        return isOnline;
    }

    public void setIsOnline(boolean isOnline) {
        this.isOnline = isOnline;
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
