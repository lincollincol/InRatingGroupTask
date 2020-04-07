package linc.com.inratingtask.domain.models;

import java.util.List;

import linc.com.inratingtask.data.models.Datum;

public class StatisticEntity {

    private StatisticEntity.Type type;
    private List<DatumEntity> profiles;
    private long amountOfData;

    public StatisticEntity(Type type, List<DatumEntity> profiles, long amountOfData) {
        this.type = type;
        this.profiles = profiles;
        this.amountOfData = amountOfData;
    }

    public Type getType() {
        return type;
    }

    public List<DatumEntity> getProfiles() {
        return profiles;
    }

    public long getAmountOfData() {
        return amountOfData;
    }

    public enum Type {
        LIKES, COMMENTS, REPOSTS, MENTIONS
    }
}
