package gdsc.RunEatServer.domain.notification.service;


import gdsc.RunEatServer.domain.runeatcharacter.service.RunEatCharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationCharacterScheduler {

    private final RunEatCharacterService runEatCharacterService;


    //매일 칼로리 초기화
    @Scheduled(cron = "0 0 0 * * *")
    public void resetTodayCalorie(){
        runEatCharacterService.resetTodayCalorie();
    }
}
