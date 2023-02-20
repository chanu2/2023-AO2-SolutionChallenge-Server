package gdsc.RunEatServer.domain.asset.service;

import gdsc.RunEatServer.domain.asset.dto.FoodImageDto;
import gdsc.RunEatServer.domain.asset.dto.ProfileImageDto;
import gdsc.RunEatServer.domain.asset.entity.FoodImage;
import gdsc.RunEatServer.domain.asset.entity.ProfileImage;
import gdsc.RunEatServer.domain.asset.exception.FoodImageNotFoundException;
import gdsc.RunEatServer.domain.asset.exception.ProfileImageNotFoundException;
import gdsc.RunEatServer.domain.asset.repository.CharacterImageRepository;
import gdsc.RunEatServer.domain.asset.repository.FoodImageRepository;
import gdsc.RunEatServer.domain.asset.repository.ProfileImageRepository;
import gdsc.RunEatServer.domain.food.service.AssetUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssetService implements AssetUtils {

    private final CharacterImageRepository characterImageRepository;
    private final FoodImageRepository foodImageRepository;
    private final ProfileImageRepository profileImageRepository;

    @Override
    public FoodImageDto getRandomFoodImage(Integer calorie) {

        Integer result = (calorie / 100) * 100;
        FoodImage foodImage =
                foodImageRepository
                        .findRandomFoodImage(result)
                        .orElseThrow(() -> FoodImageNotFoundException.EXCEPTION);
        return new FoodImageDto(foodImage);

    }

    public ProfileImageDto getRandomProfileImageUrl() {
        ProfileImage profileImage =
                profileImageRepository
                        .findRandomProfileImage()
                        .orElseThrow(() -> ProfileImageNotFoundException.EXCEPTION);
        return new ProfileImageDto(profileImage);
    }


}
