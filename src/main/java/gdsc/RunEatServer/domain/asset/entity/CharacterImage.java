package gdsc.RunEatServer.domain.asset.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CharacterImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String characterUrl;
    private Integer maxCalorie;


    // TODO: 2023-03-04 test를 위한 코드
    public CharacterImage(String characterUrl, Integer maxCalorie) {
        this.characterUrl = characterUrl;
        this.maxCalorie = maxCalorie;
    }



}
