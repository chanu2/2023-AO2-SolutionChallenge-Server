package gdsc.RunEatServer.domain.character.entity;

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
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private String characterImagePath;

    private Integer nowCharacterCalorie;

    private Integer maxCharacterCalorie;

    @Builder
    public Character(Long id, User user, String characterImagePath, Integer nowCharacterCalorie, Integer maxCharacterCalorie) {
        this.id = id;
        this.user = user;
        this.characterImagePath = characterImagePath;
        this.nowCharacterCalorie = nowCharacterCalorie;
        this.maxCharacterCalorie = maxCharacterCalorie;
    }
}
