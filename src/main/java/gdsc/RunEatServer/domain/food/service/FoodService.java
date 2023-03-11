package gdsc.RunEatServer.domain.food.service;


import gdsc.RunEatServer.domain.asset.dto.FoodImageDto;
import gdsc.RunEatServer.domain.asset.dto.RandomFoodImageDto;
import gdsc.RunEatServer.domain.food.dto.FoodResponseDto;
import gdsc.RunEatServer.domain.food.entity.Food;
import gdsc.RunEatServer.domain.food.repository.FoodRepository;
import gdsc.RunEatServer.domain.user.entity.User;
import gdsc.RunEatServer.global.utill.security.SecurityUtils;
import gdsc.RunEatServer.global.utill.user.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodService {

    private final FoodRepository foodRepository;
    private final UserUtils userUtils;
    private final AssetUtils assetUtils;

    // 음식 리스트 보내주기

    public List<FoodResponseDto> getFoodList(){

        User user = userUtils.getUserFromSecurityContext();
        List<Food> foodList = foodRepository.findFoodList(user.getId());
        return foodList.stream().map(f -> new FoodResponseDto(f)).collect(Collectors.toList());
    }

    public boolean existsFood(String foodName){
        return foodRepository.existsByFoodName(foodName);
    }

    public void saveFood(Food food){
        foodRepository.save(food);
    }





    //캐릭터 음식 먹익기





}
