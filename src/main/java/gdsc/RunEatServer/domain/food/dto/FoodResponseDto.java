package gdsc.RunEatServer.domain.food.dto;


import gdsc.RunEatServer.domain.food.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class FoodResponseDto {

    private String foodName;

    private String foodImagePath;

    private Integer calorie;

    public FoodResponseDto(Food food) {
        this.foodName = food.getFoodName();
        this.foodImagePath = food.getFoodImagePath();
        this.calorie = food.getCalorie();
    }
}
