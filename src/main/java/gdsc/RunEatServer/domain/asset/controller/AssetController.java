package gdsc.RunEatServer.domain.asset.controller;

import gdsc.RunEatServer.domain.asset.dto.RandomFoodImageDto;
import gdsc.RunEatServer.domain.asset.dto.ProfileImageDto;
import gdsc.RunEatServer.domain.asset.service.AssetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RequestMapping("/api/v1/asset")
@RestController
public class AssetController {

    private final AssetService assetService;

    @GetMapping("/profiles/random")
    public ProfileImageDto getRandomProfileImageUrl() {
        return assetService.getRandomProfileImageUrl();
    }

    @GetMapping("/food/image")
    public RandomFoodImageDto getRandomFoodImage(@RequestParam Integer calorie){
        return assetService.getRandomFoodImage(calorie);
    }

}