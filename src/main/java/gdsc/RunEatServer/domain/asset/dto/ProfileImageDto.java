package gdsc.RunEatServer.domain.asset.dto;

import gdsc.RunEatServer.domain.asset.entity.ProfileImage;
import lombok.Getter;

@Getter
public class ProfileImageDto {

    private String url;

    public ProfileImageDto(ProfileImage profileImage) {
        this.url = profileImage.getImageUrl();

    }


}