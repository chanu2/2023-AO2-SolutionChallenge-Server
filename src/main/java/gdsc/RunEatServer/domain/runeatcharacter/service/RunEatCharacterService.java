package gdsc.RunEatServer.domain.runeatcharacter.service;


import gdsc.RunEatServer.domain.runeatcharacter.repository.RunEatCharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RunEatCharacterService {

    private final RunEatCharacterRepository runEatCharacterRepository;

    public void addCalorie(Integer calorie){

    }
}
