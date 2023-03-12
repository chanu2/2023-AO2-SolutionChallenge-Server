package gdsc.RunEatServer.global.utill.user;

import gdsc.RunEatServer.domain.user.entity.User;

public interface UserUtils {

    User getUserByEmail(String email);

    User getUserFromSecurityContext();
}