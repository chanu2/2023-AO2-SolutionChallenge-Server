package gdsc.RunEatServer.domain.asset.dto;

import gdsc.RunEatServer.domain.asset.entity.CharacterImage;
import lombok.Getter;

@Getter
public class CharacterImageUpdateDto {
    private String characterUrl;

    private Integer maxCalorie;


    public CharacterImageUpdateDto(CharacterImage characterImage) {

        this.characterUrl = characterImage.getCharacterUrl();
        this.maxCalorie = characterImage.getMaxCalorie();
    }
}
