package gdsc.RunEatServer.domain.runeatcharacter.repository;

import gdsc.RunEatServer.domain.runeatcharacter.entity.RunEatCharacter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RunEatCharacterRepository extends JpaRepository<RunEatCharacter,Long> {

    RunEatCharacter save(RunEatCharacter runEatCharacter);

    @Override
    Optional<RunEatCharacter> findById(Long id);
}
