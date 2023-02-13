package gdsc.RunEatServer.domain.asset.repository;

import gdsc.RunEatServer.domain.asset.entity.FoodImage;
import gdsc.RunEatServer.domain.asset.entity.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FoodImageRepository extends JpaRepository<Long, FoodImage> {

    @Query(value = "SELECT * FROM food_image f order by RAND() limit 1 where f.foodCalorie = ?1", nativeQuery = true)
    Optional<ProfileImage> findRandomFoodImage(Integer foodCalorie);


}