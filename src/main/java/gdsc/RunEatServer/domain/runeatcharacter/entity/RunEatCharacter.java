package gdsc.RunEatServer.domain.runeatcharacter.entity;

import gdsc.RunEatServer.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RunEatCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne(fetch = LAZY)
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private String characterImagePath;
    private Integer nowCharacterCalorie;
    private Integer maxCharacterCalorie;
    private Integer todayCharacterCalorie;

    @Builder
    public RunEatCharacter(User user, String characterImagePath, Integer maxCharacterCalorie) {
        this.user = user;
        this.characterImagePath = characterImagePath;
        this.maxCharacterCalorie = maxCharacterCalorie;
        this.todayCharacterCalorie = 0;
        this.nowCharacterCalorie = 0;
    }


    //캐릭터 칼로리 먹이기
    public void addCharacterCalorie(Integer calorie){

        this.nowCharacterCalorie+=calorie;
    }

    //오늘 칼로리 채우기
    public void addTodayCharacterCalorie(Integer calorie){

        this.todayCharacterCalorie+=calorie;
    }

    public void resetTodayCharacterCalorie(){
        this.todayCharacterCalorie=0;
    }

    //캐릭터 최대 칼로리업그레이드
    public Integer upgradeMaxCalorie(){
        return maxCharacterCalorie *= 2;
    }

    //캐릭터 이미지 업데이트
    public void upgradeCharacter(String ImagePath){
        characterImagePath=ImagePath;
    }

}
