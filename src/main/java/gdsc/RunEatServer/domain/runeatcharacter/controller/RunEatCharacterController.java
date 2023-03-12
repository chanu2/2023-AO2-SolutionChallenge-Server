package gdsc.RunEatServer.domain.runeatcharacter.controller;

import gdsc.RunEatServer.domain.runeatcharacter.dto.CharacterInfoDto;
import gdsc.RunEatServer.domain.runeatcharacter.dto.CharacterRankingDto;
import gdsc.RunEatServer.domain.runeatcharacter.service.RunEatCharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/run")
public class RunEatCharacterController {
    private final RunEatCharacterService runEatCharacterService;
    @PostMapping ("/add/{calorie}/{foodName}")
    public void addCalorie(@PathVariable Integer calorie,@PathVariable String foodName){
        runEatCharacterService.addCalorie(calorie,foodName);
    }


    //메인화면
    @GetMapping("/home")
    public CharacterInfoDto getCharacterInfo(){
        return runEatCharacterService.getMainCharacter();
    }

    @GetMapping("/rank")
    public List<CharacterRankingDto> getCharacterRank(){
        return runEatCharacterService.getCharacterRanking();
    }


}
