package gdsc.RunEatServer.domain.asset.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FoodImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foodName;
    private Integer foodCalorie;
    private String foodImageUrl;

    public FoodImage(String foodName, Integer foodCalorie, String foodImageUrl) {
        this.foodName = foodName;
        this.foodCalorie = foodCalorie;
        this.foodImageUrl = foodImageUrl;
    }


}
