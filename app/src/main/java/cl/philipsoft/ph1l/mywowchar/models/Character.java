package cl.philipsoft.ph1l.mywowchar.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Character implements Serializable {
    private int totalHonorableKills;
    private String battlegroup;
    private String thumbnail;
    private int race;
    private int gender;
    private int level;
    private int achievementPoints;

    @SerializedName("class")
    private int clas;

    private int faction;
    private String name;
    private String realm;
    private long lastModified;
    private String calcClass;

    public int getTotalHonorableKills() {
        return this.totalHonorableKills;
    }

    public void setTotalHonorableKills(int totalHonorableKills) {
        this.totalHonorableKills = totalHonorableKills;
    }

    public String getBattlegroup() {
        return this.battlegroup;
    }

    public void setBattlegroup(String battlegroup) {
        this.battlegroup = battlegroup;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getRace() {
        return this.race;
    }

    public void setRace(int race) {
        this.race = race;
    }

    public int getGender() {
        return this.gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAchievementPoints() {
        return this.achievementPoints;
    }

    public void setAchievementPoints(int achievementPoints) {
        this.achievementPoints = achievementPoints;
    }

    public int getClas() {
        return this.clas;
    }

    public void setClas(int clas) {
        this.clas = clas;
    }

    public int getFaction() {
        return this.faction;
    }

    public void setFaction(int faction) {
        this.faction = faction;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealm() {
        return this.realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public String getCalcClass() {
        return this.calcClass;
    }

    public void setCalcClass(String calcClass) {
        this.calcClass = calcClass;
    }
}
