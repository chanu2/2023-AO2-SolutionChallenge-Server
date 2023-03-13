//package gdsc.RunEatServer.domain.runeatcharacter.repository;
//
//import gdsc.RunEatServer.domain.common.Gender;
//import gdsc.RunEatServer.domain.food.entity.Food;
//import gdsc.RunEatServer.domain.runeatcharacter.entity.RunEatCharacter;
//import gdsc.RunEatServer.domain.user.entity.User;
//import gdsc.RunEatServer.domain.user.repository.UserRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@SpringBootTest
//@Transactional
//@Rollback(false)
//class RunEatCharacterRepositoryTest {
//
//    @Autowired
//    EntityManager em;
//
//    @Autowired
//    RunEatCharacterRepository runEatCharacterRepository;
//
//    @Test
//    public void Max_캐릭터_가져오기() {
//
//        User user1 = User.builder()
//                .profilePath("saeeds")
//                .gender(Gender.MAN)
//                .nickname("asd")
//                .accumulatedCalorie(1233)
//                .nowCalorie(123).build();
//
//        em.persist(user1);
//
//        RunEatCharacter c = RunEatCharacter.builder()
//                .user(user1)
//                .characterImagePath("123123123")
//                .nowCharacterCalorie(1234)
//                .maxCharacterCalorie(200000)
//                .build();
//
//
//        RunEatCharacter c1 = RunEatCharacter.builder()
//                .user(user1)
//                .characterImagePath("123123123")
//                .nowCharacterCalorie(12343)
//                .maxCharacterCalorie(100000)
//                .build();
//
//
//        RunEatCharacter c2 = RunEatCharacter.builder()
//                .user(user1)
//                .characterImagePath("123123123")
//                .nowCharacterCalorie(12344)
//                .maxCharacterCalorie(300000)
//                .build();
//
//
//        RunEatCharacter c3 = RunEatCharacter.builder()
//                .user(user1)
//                .characterImagePath("123123123")
//                .nowCharacterCalorie(12344)
//                .maxCharacterCalorie(500000)
//                .build();
//
//        em.persist(c);
//        em.persist(c1);
//        em.persist(c2);
//        em.persist(c3);
//
//        em.clear();
//
//
//        RunEatCharacter cha = runEatCharacterRepository.findFirstByUserIdOrderByMaxCharacterCalorieDesc(1L).get();
//
//        System.out.println("cha.getMaxCharacterCalorie() = " + cha.getMaxCharacterCalorie());
//        System.out.println("cha.getUser().getNickname() = " + cha.getUser().getNickname());
//        System.out.println("cha.getUser().getNickname() = " + cha.getNowCharacterCalorie());
//        System.out.println("cha.getUser().getNickname() = " + cha.getUser().getGender());
//
//
//
//
//    }
//
//}