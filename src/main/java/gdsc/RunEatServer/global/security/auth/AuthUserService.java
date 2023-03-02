package gdsc.RunEatServer.global.security.auth;

import gdsc.RunEatServer.domain.user.entity.User;
import gdsc.RunEatServer.domain.user.repository.UserRepository;
import gdsc.RunEatServer.global.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public AuthUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        return new AuthUser(
                user.getId(),
                user.getEmail(),
                user.getRoles()
        );
    }
}