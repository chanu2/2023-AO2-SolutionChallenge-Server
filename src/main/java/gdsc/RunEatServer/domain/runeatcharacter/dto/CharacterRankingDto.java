package gdsc.RunEatServer.domain.runeatcharacter.dto;

import gdsc.RunEatServer.domain.runeatcharacter.entity.RunEatCharacter;

public class CharacterRankingDto {

    private String characterImagePath;
    private Integer nowCharacterCalorie;
    private String nickname;

    public CharacterRankingDto(RunEatCharacter runEatCharacter) {
        this.characterImagePath = runEatCharacter.getCharacterImagePath();
        this.nowCharacterCalorie = runEatCharacter.getNowCharacterCalorie();
        this.nickname = runEatCharacter.getUser().getNickname();
    }
}
