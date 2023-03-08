package gdsc.RunEatServer.domain.asset.repository;


import gdsc.RunEatServer.domain.asset.entity.CharacterImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CharacterImageRepository extends JpaRepository<CharacterImage,Long> {
    @Override
    Optional<CharacterImage> findById(Long aLong);

    Optional<CharacterImage> findFirstByOrderByMaxCalorieAsc();

    Optional<CharacterImage> findByMaxCalorie(Integer maxCalorie);



}
