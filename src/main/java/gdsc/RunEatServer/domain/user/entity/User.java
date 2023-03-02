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

    @Column(nullable = false, length =50, unique = true)
    private String email;
    private String profilePath;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String nickname;
    private Integer accumulatedCalorie;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();


    @Builder
    public User(String email,String profilePath, Gender gender, String nickname,List<String> roles) {
        this.email = email;
        this.profilePath = profilePath;
        this.gender = gender;
        this.nickname = nickname;
        this.accumulatedCalorie = 0;
        this.roles =roles;
    }


}
