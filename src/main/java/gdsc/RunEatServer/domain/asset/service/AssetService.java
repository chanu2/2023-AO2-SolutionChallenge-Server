package gdsc.RunEatServer.domain.asset.service;

import gdsc.RunEatServer.domain.asset.dto.*;
import gdsc.RunEatServer.domain.asset.entity.CharacterImage;
import gdsc.RunEatServer.domain.asset.entity.FoodImage;
import gdsc.RunEatServer.domain.asset.entity.ProfileImage;
import gdsc.RunEatServer.domain.asset.exception.CharacterImageNotFoundException;
import gdsc.RunEatServer.domain.asset.exception.FoodImageNotFoundException;
import gdsc.RunEatServer.domain.asset.exception.ProfileImageNotFoundException;
import gdsc.RunEatServer.domain.asset.repository.CharacterImageRepository;
import gdsc.RunEatServer.domain.asset.repository.FoodImageRepository;
import gdsc.RunEatServer.domain.asset.repository.ProfileImageRepository;
import gdsc.RunEatServer.domain.food.service.AssetUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssetService implements AssetUtils {

    private final CharacterImageRepository characterImageRepository;
    private final FoodImageRepository foodImageRepository;
    private final ProfileImageRepository profileImageRepository;




    // 칼로리로 foodImage 가져오기
    @Override
    public RandomFoodImageDto getRandomFoodImage(Integer calorie) {

        Integer result = (calorie / 100) * 100;
        FoodImage foodImage =
                foodImageRepository
                        .findRandomFoodImage(result)
                        .orElseThrow(() -> FoodImageNotFoundException.EXCEPTION);
        return new RandomFoodImageDto(foodImage);

    }

    // 음식 이름으로 foodImage 가져오기
    @Override
    public FoodImageDto getFoodImageByName(String foodName) {
        FoodImage foodImage = foodImageRepository
                .findByFoodName(foodName)
                .orElseThrow(() -> FoodImageNotFoundException.EXCEPTION);
        return new FoodImageDto(foodImage);
    }


    // 캐릭터 업데이드
    @Override
    public CharacterImageUpdateDto getUpgradeCharacterImage(Integer maxCalorie) {
        CharacterImage characterImage = characterImageRepository
                .findByMaxCalorie(maxCalorie)
                .orElseThrow(() -> CharacterImageNotFoundException.EXCEPTION);
        return new CharacterImageUpdateDto(characterImage);

    }


    //처음 회원가입시 캐릭터 배정
    @Override
    public CharacterImageDto registerCharacterImage() {
            CharacterImage characterImage =
                    characterImageRepository
                            .findFirstByOrderByMaxCalorieAsc()
                            .orElseThrow(() -> CharacterImageNotFoundException.EXCEPTION);
        return new CharacterImageDto(characterImage);
    }



    public ProfileImageDto getRandomProfileImageUrl() {
        ProfileImage profileImage =
                profileImageRepository
                        .findRandomProfileImage()
                        .orElseThrow(() -> ProfileImageNotFoundException.EXCEPTION);
        return new ProfileImageDto(profileImage);
    }






}
