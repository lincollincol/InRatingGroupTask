package linc.com.inratingtask.data.mappers;

import linc.com.inratingtask.data.models.ActiveGift;
import linc.com.inratingtask.domain.models.ActiveGiftEntity;

public class ActiveGiftMapper {

    public ActiveGiftEntity activeGiftToEntity(ActiveGift activeGift) {
        ActiveGiftEntity activeGiftEntity = new ActiveGiftEntity();

        if(activeGift == null) {
            return activeGiftEntity;
        }

        activeGiftEntity.setId(activeGift.getId());
        activeGiftEntity.setName(activeGift.getName());
        activeGiftEntity.setImage(activeGift.getImage());
        return activeGiftEntity;
    }

}
