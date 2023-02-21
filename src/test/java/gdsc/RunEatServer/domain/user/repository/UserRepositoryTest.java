package gdsc.RunEatServer.domain.user.repository;

import gdsc.RunEatServer.domain.asset.entity.FoodImage;
import gdsc.RunEatServer.domain.asset.repository.FoodImageRepository;
import gdsc.RunEatServer.domain.asset.service.AssetService;
import gdsc.RunEatServer.domain.common.Gender;
import gdsc.RunEatServer.domain.user.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback(false)
class UserRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    UserRepository userRepository;

    @Test
    public void 칼로리에_따른_음식_가져오기() {

        User user1 = User.builder()
                .profilePath("saeeds")
                .gender(Gender.MAN)
                .nickname("asd")
                .accumulatedCalorie(1233)
                .nowCalorie(123).build();

        User user2 = User.builder()
                .profilePath("saeeds")
                .gender(Gender.MAN)
                .nickname("asd")
                .accumulatedCalorie(1200)
                .nowCalorie(123).build();

        User user3 = User.builder()
                .profilePath("saeeds")
                .gender(Gender.MAN)
                .nickname("asd")
                .accumulatedCalorie(4000)
                .nowCalorie(123).build();

        User user4 = User.builder()
                .profilePath("saeeds")
                .gender(Gender.MAN)
                .nickname("asd")
                .accumulatedCalorie(1)
                .nowCalorie(123).build();

        User user5 = User.builder()
                .profilePath("saeeds")
                .gender(Gender.MAN)
                .nickname("asd")
                .accumulatedCalorie(154)
                .nowCalorie(123).build();

        em.persist(user1);
        em.persist(user2);
        em.persist(user3);
        em.persist(user4);
        em.persist(user5);


        em.flush();


        PageRequest pageRequest = PageRequest.of(0,3, Sort.by(Sort.Direction.DESC,"accumulatedCalorie"));

        List<User> content = userRepository.findBy(pageRequest).getContent();
        for (User user : content) {
            System.out.println("user.getId() = " + user.getId());
            System.out.println("user.getAccumulatedCalorie() = " + user.getAccumulatedCalorie());
        }


    }

}