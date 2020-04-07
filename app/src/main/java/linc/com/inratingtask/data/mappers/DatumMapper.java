package linc.com.inratingtask.data.mappers;

import java.util.ArrayList;
import java.util.List;

import linc.com.inratingtask.data.models.ActiveGift;
import linc.com.inratingtask.data.models.Datum;
import linc.com.inratingtask.domain.models.DatumEntity;

public class DatumMapper {

    // todo dagger
    private ActiveGiftMapper activeGiftMapper;
    private AvatarImageMapper avatarImageMapper;

    public DatumMapper(ActiveGiftMapper activeGiftMapper, AvatarImageMapper avatarImageMapper) {
        this.activeGiftMapper = activeGiftMapper;
        this.avatarImageMapper = avatarImageMapper;
    }

    public DatumEntity datumToEntity(Datum datum) {
        DatumEntity datumEntity = new DatumEntity();

        if(datum == null) {
            return datumEntity;
        }

        datumEntity.setId(datum.getId());
        datumEntity.setNickname(datum.getNickname());
        datumEntity.setActiveGift(
                activeGiftMapper.activeGiftToEntity(datum.getActiveGift())
        );
        datumEntity.setAvatarImage(
                avatarImageMapper.avatarImageToEntity(datum.getAvatarImage())
        );
        datumEntity.setOffPage(datum.isOffPage());
        datumEntity.setName(datum.getName());
        datumEntity.setLastname(datum.getLastname());
        datumEntity.setStatus(datum.getStatus());
        datumEntity.setGender(datum.getGender());
        datumEntity.setSubscribed(datum.isIsSubscribed());
        datumEntity.setOnline(datum.isIsOnline());
        datumEntity.setLastOnlineTimestamp(datum.getLastOnlineTimestamp());
        datumEntity.setInMyBlacklist(datum.isInMyBlacklist());
        datumEntity.setHasMeInBlacklist(datum.isHasMeInBlacklist());
        datumEntity.setMultiplier(datum.getMultiplier());
        return datumEntity;
    }

    public List<DatumEntity> datumToEntityList(List<Datum> datumList) {
        final List<DatumEntity> entities = new ArrayList<>();
        for (Datum datum: datumList) {
            entities.add(datumToEntity(datum));
        }
        return entities;
    }
}
