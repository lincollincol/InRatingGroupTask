package linc.com.inratingtask.data.mappers;

import linc.com.inratingtask.data.models.AvatarImage;
import linc.com.inratingtask.domain.models.AvatarImageEntity;

public class AvatarImageMapper {

    public AvatarImageEntity avatarImageToEntity(AvatarImage avatarImage) {
        AvatarImageEntity avatarImageEntity = new AvatarImageEntity();

        if(avatarImage == null) {
            return avatarImageEntity;
        }

        avatarImageEntity.setUrlMedium(avatarImage.getUrlMedium());
        avatarImageEntity.setId(avatarImage.getId());
        avatarImageEntity.setUrl(avatarImage.getUrl());
        avatarImageEntity.setUrlLarge(avatarImage.getUrlLarge());
        avatarImageEntity.setUrlSmall(avatarImage.getUrlSmall());
        avatarImageEntity.setUrlOrigin(avatarImage.getUrlOrigin());
        avatarImageEntity.setUrlMediumOrigin(avatarImage.getUrlMediumOrigin());
        avatarImageEntity.setUrlLargeOrigin(avatarImage.getUrlLargeOrigin());
        avatarImageEntity.setUrlSmallOrigin(avatarImage.getUrlSmallOrigin());
        avatarImageEntity.setMentionedUsersCount(avatarImage.getMentionedUsersCount());
        return avatarImageEntity;
    }
}
