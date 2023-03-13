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
@RequestMapping("/asset")
@RestController
public class AssetController {

    private final AssetService assetService;

    @GetMapping("/profiles/random")
    public ProfileImageDto getRandomProfileImageUrl() {
        return assetService.getRandomProfileImageUrl();
    }


    //칼로리에 따른 이미지 램덤으로 조회
    @GetMapping("/food/image")
    public RandomFoodImageDto getRandomFoodImage(@RequestParam Integer calorie){
        return assetService.getRandomFoodImage(calorie);
    }

}