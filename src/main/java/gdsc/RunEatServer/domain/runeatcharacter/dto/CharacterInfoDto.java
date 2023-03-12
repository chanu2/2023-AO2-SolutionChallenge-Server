package gdsc.RunEatServer.domain.runeatcharacter.dto;

import gdsc.RunEatServer.domain.runeatcharacter.entity.RunEatCharacter;
import lombok.Getter;

@Getter
public class CharacterInfoDto {

    private String characterImagePath;
    private Integer nowCharacterCalorie;
    private Integer todayCharacterCalorie;
    private String nickname;
    public CharacterInfoDto(RunEatCharacter runEatCharacter) {

        characterImagePath=runEatCharacter.getCharacterImagePath();
        nowCharacterCalorie = runEatCharacter.getNowCharacterCalorie();
        todayCharacterCalorie = runEatCharacter.getTodayCharacterCalorie();
        nickname = runEatCharacter.getUser().getNickname();
    }
}
