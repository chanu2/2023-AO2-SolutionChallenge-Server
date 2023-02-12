package gdsc.RunEatServer.domain.food.entity;


import gdsc.RunEatServer.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private String foodName;

    private String foodImagePath;

    private String calorie;

    private Integer maxCharacterCalorie;

    @Builder
    public Food(Long id, User user, String foodName, String foodImagePath, String calorie, Integer maxCharacterCalorie) {
        this.id = id;
        this.user = user;
        this.foodName = foodName;
        this.foodImagePath = foodImagePath;
        this.calorie = calorie;
        this.maxCharacterCalorie = maxCharacterCalorie;
    }
}
