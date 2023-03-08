package gdsc.RunEatServer.domain.asset.repository;

import gdsc.RunEatServer.domain.asset.entity.FoodImage;
import gdsc.RunEatServer.domain.asset.entity.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface FoodImageRepository extends JpaRepository<FoodImage,Long > {

//    @Query(value = "SELECT * FROM food_image f order by RAND() limit 1 where f.foodCalorie = ?1", nativeQuery = true)
//    Optional<FoodImage> findRandomFoodImage(Integer foodCalorie);

//    @Query(value = "SELECT * FROM food_image order by RAND() limit 1 where food_calorie = :foodCalorie", nativeQuery = true)
//    Optional<FoodImage> findRandomFoodImage(Integer foodCalorie);

    @Query(value = "SELECT * FROM food_image WHERE food_calorie = :foodCalorie order by RAND() limit 1", nativeQuery = true)
    Optional<FoodImage> findRandomFoodImage(@Param("foodCalorie") Integer foodCalorie);

    Optional<FoodImage> findByFoodName(String foodName);


}
