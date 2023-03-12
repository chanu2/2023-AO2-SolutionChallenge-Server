package gdsc.RunEatServer.global.utill.user;

import gdsc.RunEatServer.domain.user.entity.User;
import gdsc.RunEatServer.domain.user.repository.UserRepository;
import gdsc.RunEatServer.global.exception.UserNotFoundException;
import gdsc.RunEatServer.global.utill.security.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserUtilsImpl implements UserUtils {

    private final UserRepository userRepository;

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
    public User getUserFromSecurityContext() {
        String currentUserEmail = SecurityUtils.getCurrentUserEmail();
        User user = getUserByEmail(currentUserEmail);
        return user;
    }

}