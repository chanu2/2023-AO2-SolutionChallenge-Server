package gdsc.RunEatServer.domain.runeatcharacter.repository;

import gdsc.RunEatServer.domain.food.entity.Food;
import gdsc.RunEatServer.domain.runeatcharacter.entity.RunEatCharacter;
import gdsc.RunEatServer.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RunEatCharacterRepository extends JpaRepository<RunEatCharacter,Long> {

    RunEatCharacter save(RunEatCharacter runEatCharacter);

    @Override
    Optional<RunEatCharacter> findById(Long id);


    @Query("select c from RunEatCharacter c"+
            " join fetch c.user u"+
            " where u.id = :userId")
    List<Food> getCharacter(@Param("userId")Long userId);

    Optional<RunEatCharacter> findFirstByUserIdOrderByMaxCharacterCalorieDesc(Long userId);


}
