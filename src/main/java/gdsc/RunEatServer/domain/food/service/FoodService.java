package gdsc.RunEatServer.domain.food.service;


import gdsc.RunEatServer.domain.food.entity.Food;
import gdsc.RunEatServer.domain.food.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public List<Food> getFoodList(Long id){
        List<Food> foodList = foodRepository.findFoodList(id);

        // TODO: 2023-02-22 dto 만들기

        return foodList;
    }
}
