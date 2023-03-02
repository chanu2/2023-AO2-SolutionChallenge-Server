package gdsc.RunEatServer.domain.user.dto.request;

import gdsc.RunEatServer.domain.common.Gender;
import lombok.Getter;

@Getter
public class LoginDto {

    private String nickname;

    private Gender sex;


}
