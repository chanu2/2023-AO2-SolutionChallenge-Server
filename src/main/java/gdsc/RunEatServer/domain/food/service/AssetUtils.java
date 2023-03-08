package gdsc.RunEatServer.domain.food.service;

import gdsc.RunEatServer.domain.asset.dto.CharacterImageDto;
import gdsc.RunEatServer.domain.asset.dto.CharacterImageUpdateDto;
import gdsc.RunEatServer.domain.asset.dto.FoodImageDto;
import gdsc.RunEatServer.domain.asset.dto.RandomFoodImageDto;

public interface AssetUtils {

    RandomFoodImageDto getRandomFoodImage(Integer calorie);

    CharacterImageUpdateDto getUpgradeCharacterImage(Integer maxCalorie);

    CharacterImageDto registerCharacterImage();

    FoodImageDto getFoodImageByName(String foodName);


}