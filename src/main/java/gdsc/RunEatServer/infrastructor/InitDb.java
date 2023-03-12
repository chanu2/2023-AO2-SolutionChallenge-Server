package gdsc.RunEatServer.infrastructor;

import gdsc.RunEatServer.domain.asset.entity.CharacterImage;
import gdsc.RunEatServer.domain.asset.entity.FoodImage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Component  // 스프링빈 등록
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct  //bean이 여러 번 초기화되는 걸 방지할 수 있다.
    public void init() {
        initService.dbInit1();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor // 생성자 주입
    static class InitService {
        private final EntityManager em;
        public void dbInit1() {


            CharacterImage characterImage1 = new CharacterImage("asdgajdhgajhsdgjahsd",70000);
            CharacterImage characterImage2 = new CharacterImage("asdgajdhgajhsdgjahsd",40000);
            CharacterImage characterImage3 = new CharacterImage("chanu2",10000);
            CharacterImage characterImage4 = new CharacterImage("2번쨰 캐릭터",20000);


            FoodImage food1 = new FoodImage("pizza", 200, "www.asdw.adwsadw1");
            FoodImage food2 = new FoodImage("hamberger", 300, "www.asdw.adwsadw2");
            FoodImage food3 = new FoodImage("pasta", 400, "www.asdw.adwsadw3");
            FoodImage food4 = new FoodImage("bibibob", 500, "www.asdw.adwsadw4");

            em.persist(food1);
            em.persist(food2);
            em.persist(food3);
            em.persist(food4);


            em.persist(characterImage1);
            em.persist(characterImage2);
            em.persist(characterImage3);
            em.persist(characterImage4);

            em.flush();

            em.clear();


        }


    }
}