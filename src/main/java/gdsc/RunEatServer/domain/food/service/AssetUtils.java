package gdsc.RunEatServer.domain.food.service;

import gdsc.RunEatServer.domain.asset.dto.FoodImageDto;

public interface AssetUtils {

    FoodImageDto getRandomFoodImage(Integer calorie);
}