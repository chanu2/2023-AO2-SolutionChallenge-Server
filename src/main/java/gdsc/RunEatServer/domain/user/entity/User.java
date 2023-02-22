package gdsc.RunEatServer.domain.user.entity;


import gdsc.RunEatServer.domain.common.Gender;
import gdsc.RunEatServer.domain.food.entity.Food;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Food> foodList = new ArrayList<>();

    private String profilePath;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String nickname;

    private Integer accumulatedCalorie;

    private Integer nowCalorie;


    @Builder
    public User(String profilePath, Gender gender, String nickname, Integer accumulatedCalorie, Integer nowCalorie) {
        this.profilePath = profilePath;
        this.gender = gender;
        this.nickname = nickname;
        this.accumulatedCalorie = accumulatedCalorie;
        this.nowCalorie = nowCalorie;
    }
}
