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

    private Integer calorie;



    //== 연관 관계 메서드==//

    public void addUser(User user){
        user.getFoodList().add(this);
    }


    @Builder
    public Food( User user, String foodName, String foodImagePath, Integer calorie) {
        this.user = user;
        this.foodName = foodName;
        this.foodImagePath = foodImagePath;
        this.calorie = calorie;
    }


}
