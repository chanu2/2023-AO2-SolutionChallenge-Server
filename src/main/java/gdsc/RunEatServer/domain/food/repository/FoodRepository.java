package gdsc.RunEatServer.domain.food.repository;

import gdsc.RunEatServer.domain.food.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food,Long> {

    Food save(Food food);

    @Override
    Optional<Food> findById(Long id);

    @Query("select f from Food f"+
            " where f.user.id = :userId")
    List<Food> findFoodList(@Param("userId")Long userId);


    boolean existsByFoodName(String foodName);
}
