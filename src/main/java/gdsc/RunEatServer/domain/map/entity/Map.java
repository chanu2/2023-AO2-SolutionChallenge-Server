package gdsc.RunEatServer.domain.map.entity;

import gdsc.RunEatServer.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private Double startLatitude;
    private Double startLongitude;

    private Double finishLatitude;
    private Double finishLongitude;



    @Builder
    public Map(Long id, User user, Double startLatitude, Double startLongitude, Double finishLatitude, Double finishLongitude) {
        this.id = id;
        this.user = user;
        this.startLatitude = startLatitude;
        this.startLongitude = startLongitude;
        this.finishLatitude = finishLatitude;
        this.finishLongitude = finishLongitude;
    }
}
