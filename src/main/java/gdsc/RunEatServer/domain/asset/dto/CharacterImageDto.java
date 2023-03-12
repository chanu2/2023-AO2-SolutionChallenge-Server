package gdsc.RunEatServer.domain.asset.dto;

import gdsc.RunEatServer.domain.asset.entity.CharacterImage;
import gdsc.RunEatServer.domain.asset.entity.FoodImage;
import gdsc.RunEatServer.domain.runeatcharacter.entity.RunEatCharacter;
import lombok.Getter;

@Getter
public class CharacterImageDto {
    private String characterUrl;

    private Integer maxCalorie;


    public CharacterImageDto(CharacterImage characterImage) {

        this.characterUrl = characterImage.getCharacterUrl();
        this.maxCalorie = characterImage.getMaxCalorie();
    }
}
