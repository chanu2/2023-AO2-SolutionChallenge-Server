package gdsc.RunEatServer.domain.runeatcharacter.service;


import gdsc.RunEatServer.domain.asset.dto.CharacterImageUpdateDto;
import gdsc.RunEatServer.domain.asset.dto.FoodImageDto;
import gdsc.RunEatServer.domain.food.dto.FoodResponseDto;
import gdsc.RunEatServer.domain.food.entity.Food;
import gdsc.RunEatServer.domain.food.service.AssetUtils;
import gdsc.RunEatServer.domain.food.service.FoodService;
import gdsc.RunEatServer.domain.runeatcharacter.dto.CharacterInfoDto;
import gdsc.RunEatServer.domain.runeatcharacter.dto.CharacterRankingDto;
import gdsc.RunEatServer.domain.runeatcharacter.entity.RunEatCharacter;
import gdsc.RunEatServer.domain.runeatcharacter.exception.RunEatCharacterNotFoundException;
import gdsc.RunEatServer.domain.runeatcharacter.repository.RunEatCharacterRepository;
import gdsc.RunEatServer.domain.user.entity.User;
import gdsc.RunEatServer.global.utill.user.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RunEatCharacterService {

    private final RunEatCharacterRepository runEatCharacterRepository;
    private final UserUtils userUtils;
    private final AssetUtils assetUtils;
    private final FoodService foodService;


    // 캐릭터 먹이기
    @Transactional
    public void addCalorie(Integer calorie,String foodName){

        User user = userUtils.getUserFromSecurityContext();
        RunEatCharacter runEatCharacter = queryCharacterByUser(user);


        // 캐릭터 최대 게이지 넘으면 업데이트
        if(runEatCharacter.getNowCharacterCalorie() >= runEatCharacter.getMaxCharacterCalorie()){

            Integer maxCalorie = runEatCharacter.upgradeMaxCalorie();
            CharacterImageUpdateDto characterImageUpdateDto = assetUtils.getUpgradeCharacterImage(maxCalorie);
            runEatCharacter.upgradeCharacter(characterImageUpdateDto.getCharacterUrl());
        }

        if(!foodService.existsFood(foodName)){

            FoodImageDto foodImageDto = assetUtils.getFoodImageByName(foodName);

            foodService.saveFood(
                    Food.builder()
                    .user(user)
                    .foodName(foodImageDto.getFoodName())
                    .foodImagePath(foodImageDto.getFoodImageUrl())
                    .calorie(foodImageDto.getFoodCalorie())
                    .build()
            );

        }
        runEatCharacter.addCharacterCalorie(calorie);
        runEatCharacter.addTodayCharacterCalorie(calorie);
    }


    // 랭킹 조회
    public List<CharacterRankingDto> getTotalRank(){

        PageRequest pageRequest = PageRequest.of(0,10, Sort.by(Sort.Direction.DESC,"nowCharacterCalorie"));

        List<RunEatCharacter> characterList = runEatCharacterRepository.findBy(pageRequest).getContent();

        return characterList.stream().map(c -> new CharacterRankingDto(c)).collect(Collectors.toList());
    }


    // 캐릭터 메인화면 제공
    public CharacterInfoDto getMainCharacter(){

        User user = userUtils.getUserFromSecurityContext();
        RunEatCharacter runEatCharacter = queryCharacterByUser(user);

        return new CharacterInfoDto(runEatCharacter);

    }


    // 오늘 쌓인 칼로리 초기화
    @Transactional
    public void resetTodayCalorie(){
        List<RunEatCharacter> characterList = runEatCharacterRepository.findAll();

        for (RunEatCharacter runEatCharacter : characterList) {
            runEatCharacter.resetTodayCharacterCalorie();
        }
    }


    //모든 캐릭터 가져오기
    private List<RunEatCharacter> findAllCharacter(){
        return runEatCharacterRepository.findAll();
    }


    //유저로 캐릭터 가져오기
    private RunEatCharacter queryCharacterByUser(User user){
        return runEatCharacterRepository.findByUser(user)
                .orElseThrow(() -> RunEatCharacterNotFoundException.EXCEPTION);
    }

}
