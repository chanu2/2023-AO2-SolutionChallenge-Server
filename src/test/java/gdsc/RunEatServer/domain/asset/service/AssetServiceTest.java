package gdsc.RunEatServer.domain.asset.service;

import gdsc.RunEatServer.domain.asset.dto.RandomFoodImageDto;
import gdsc.RunEatServer.domain.asset.entity.FoodImage;
import gdsc.RunEatServer.domain.asset.repository.FoodImageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.Optional;

@SpringBootTest
@Transactional
@Rollback(false)
class AssetServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    FoodImageRepository foodImageRepository;

    @Autowired
    AssetService assetService;


    @Test
    public void 칼로리에_따른_음식_가져오기() {

        FoodImage food1 = new FoodImage("햄버거", 200, "https//qsdasdasd");
        FoodImage food2 = new FoodImage("피자", 200, "https//qsdasdasd");
        FoodImage food3 = new FoodImage("치킨", 200, "https//qsdasdasd");
        FoodImage food4 = new FoodImage("초콜렛", 300, "https//qsdasdasd");
        FoodImage food5 = new FoodImage("로제", 300, "https//qsdasdasd");
        FoodImage food6 = new FoodImage("떡뽁이", 300, "https//qsdasdasd");
        FoodImage food7 = new FoodImage("제육볶음", 900, "https//qsdasdasd");
        FoodImage food8 = new FoodImage("누텔라", 1000, "https//qsdasdasd");
        FoodImage food9 = new FoodImage("솜사탕", 1000, "https//qsdasdasd");
        FoodImage food10 = new FoodImage("핫도그", 1000, "https//qsdasdasd");
        FoodImage food11 = new FoodImage("피넛버터", 1100, "https//qsdasdasd");
        FoodImage food12= new FoodImage("소금빵", 1100, "https//qsdasdasd");
        FoodImage food13 = new FoodImage("만두", 1100, "https//qsdasdasd");

        em.persist(food1);
        em.persist(food2);
        em.persist(food3);
        em.persist(food4);
        em.persist(food5);
        em.persist(food6);
        em.persist(food7);
        em.persist(food8);
        em.persist(food9);
        em.persist(food10);
        em.persist(food11);
        em.persist(food12);
        em.persist(food13);

        em.flush();
        em.clear();

        Optional<FoodImage> randomFoodImage = foodImageRepository.findRandomFoodImage(200);
        System.out.println("randomFoodImage = " + randomFoodImage.get().getFoodCalorie());
        System.out.println("randomFoodImage = " + randomFoodImage.get().getFoodName());
        System.out.println("randomFoodImage = " + randomFoodImage.get().getFoodImageUrl());

        Optional<FoodImage> randomFoodImage1 = foodImageRepository.findRandomFoodImage(200);
        System.out.println("randomFoodImage = " + randomFoodImage1.get().getFoodCalorie());
        System.out.println("randomFoodImage = " + randomFoodImage1.get().getFoodName());
        System.out.println("randomFoodImage = " + randomFoodImage1.get().getFoodImageUrl());

        Optional<FoodImage> randomFoodImage2 = foodImageRepository.findRandomFoodImage(200);
        System.out.println("randomFoodImage = " + randomFoodImage2.get().getFoodCalorie());
        System.out.println("randomFoodImage = " + randomFoodImage2.get().getFoodName());
        System.out.println("randomFoodImage = " + randomFoodImage2.get().getFoodImageUrl());

        Optional<FoodImage> randomFoodImage3 = foodImageRepository.findRandomFoodImage(200);
        System.out.println("randomFoodImage = " + randomFoodImage3.get().getFoodCalorie());
        System.out.println("randomFoodImage = " + randomFoodImage3.get().getFoodName());
        System.out.println("randomFoodImage = " + randomFoodImage3.get().getFoodImageUrl());


    }

    @Test
    public void 칼로리에_따른_음식_서비스() {

        FoodImage food1 = new FoodImage("햄버거", 200, "https//qsdasdasd");
        FoodImage food2 = new FoodImage("피자", 200, "https//qsdasdasd");
        FoodImage food3 = new FoodImage("치킨", 200, "https//qsdasdasd");
        FoodImage food4 = new FoodImage("초콜렛", 300, "https//qsdasdasd");
        FoodImage food5 = new FoodImage("로제", 300, "https//qsdasdasd");
        FoodImage food6 = new FoodImage("떡뽁이", 300, "https//qsdasdasd");
        FoodImage food7 = new FoodImage("제육볶음", 900, "https//qsdasdasd");
        FoodImage food8 = new FoodImage("누텔라", 1000, "https//qsdasdasd");
        FoodImage food9 = new FoodImage("솜사탕", 1000, "https//qsdasdasd");
        FoodImage food10 = new FoodImage("핫도그", 1000, "https//qsdasdasd");
        FoodImage food11 = new FoodImage("피넛버터", 1100, "https//qsdasdasd");
        FoodImage food12= new FoodImage("소금빵", 1100, "https//qsdasdasd");
        FoodImage food13 = new FoodImage("만두", 1100, "https//qsdasdasd");

        em.persist(food1);
        em.persist(food2);
        em.persist(food3);
        em.persist(food4);
        em.persist(food5);
        em.persist(food6);
        em.persist(food7);
        em.persist(food8);
        em.persist(food9);
        em.persist(food10);
        em.persist(food11);
        em.persist(food12);
        em.persist(food13);

        em.flush();
        em.clear();

        RandomFoodImageDto randomFoodImage = assetService.getRandomFoodImage(230);
        System.out.println("randomFoodImage.getFoodName() = " + randomFoodImage.getFoodName());
        System.out.println("randomFoodImage.getUrl() = " + randomFoodImage.getUrl());

        RandomFoodImageDto randomFoodImage1 = assetService.getRandomFoodImage(1100);
        System.out.println("randomFoodImage.getFoodName() = " + randomFoodImage1.getFoodName());
        System.out.println("randomFoodImage.getUrl() = " + randomFoodImage1.getUrl());

        RandomFoodImageDto randomFoodImage2 = assetService.getRandomFoodImage(1132);
        System.out.println("randomFoodImage.getFoodName() = " + randomFoodImage2.getFoodName());
        System.out.println("randomFoodImage.getUrl() = " + randomFoodImage2.getUrl());

        RandomFoodImageDto randomFoodImage3 = assetService.getRandomFoodImage(1143);
        System.out.println("randomFoodImage.getFoodName() = " + randomFoodImage3.getFoodName());
        System.out.println("randomFoodImage.getUrl() = " + randomFoodImage3.getUrl());


    }

}