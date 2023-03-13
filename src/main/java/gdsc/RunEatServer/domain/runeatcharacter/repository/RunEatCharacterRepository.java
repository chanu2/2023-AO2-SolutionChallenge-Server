package gdsc.RunEatServer.domain.runeatcharacter.repository;

import gdsc.RunEatServer.domain.food.entity.Food;
import gdsc.RunEatServer.domain.runeatcharacter.entity.RunEatCharacter;
import gdsc.RunEatServer.domain.user.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RunEatCharacterRepository extends JpaRepository<RunEatCharacter,Long> {

    RunEatCharacter save(RunEatCharacter runEatCharacter);
    @Override
    Optional<RunEatCharacter> findById(Long id);

    Optional<RunEatCharacter> findByUser(User user);

    List<RunEatCharacter> findAll();

    Slice<RunEatCharacter> findBy(Pageable pageable);

}
