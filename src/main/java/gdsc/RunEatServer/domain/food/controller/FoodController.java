package gdsc.RunEatServer.domain.food.controller;


import gdsc.RunEatServer.domain.food.dto.FoodResponseDto;
import gdsc.RunEatServer.domain.food.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/food")
public class FoodController {
    private final FoodService foodService;
    @GetMapping("/get/list")
    public List<FoodResponseDto> getFoodList(){
        return foodService.getFoodList();
    }

}
