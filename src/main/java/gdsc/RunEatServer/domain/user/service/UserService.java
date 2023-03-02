package gdsc.RunEatServer.domain.user.service;


import gdsc.RunEatServer.domain.user.dto.request.LoginDto;
import gdsc.RunEatServer.domain.user.entity.RefreshToken;
import gdsc.RunEatServer.domain.user.entity.User;
import gdsc.RunEatServer.domain.user.repository.RefreshTokenRepository;
import gdsc.RunEatServer.domain.user.repository.UserRepository;
import gdsc.RunEatServer.global.security.JwtUtil;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class UserService {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;


    public Boolean signIn (String email, HttpServletResponse response) {

        User user = findMemberEmail(email);
        extracted(email, response);
        log.info(user.getEmail() + " (id : " + user.getId() + ") login");
        return true;
    }

    @Transactional
    public Boolean signUp (String email, LoginDto loginDto, HttpServletResponse response) {

        if(userRepository.findByEmail(email).isEmpty()) {

            User member = User.builder()
                    .email(email)
                    .nickname(loginDto.getNickname())
                    .gender(loginDto.getSex())
                    .roles(Collections.singletonList("ROLE_USER"))
                    .build();

            User user = userRepository.save(member);

            // 어세스, 리프레시 토큰 발급 및 헤더 설정
            log.info("email={}",email);
            extracted(email, response);
            log.info(user.getEmail() + " (id : " + user.getId() + ") login");
        }

        return true;
    }


    public void extracted(String email, HttpServletResponse response) {

        log.info("email={}",email);

        String accessToken = jwtUtil.createAccessToken(email, Collections.singletonList("ROLE_USER"));
        String refreshToken = jwtUtil.createRefreshToken(email, Collections.singletonList("ROLE_USER"));

        jwtUtil.setHeaderAccessToken(response, accessToken);
        jwtUtil.setHeaderRefreshToken(response, refreshToken);

        log.info("email={}",email);
        log.info("---------------------------------------------------------------------");

        refreshTokenRepository.save(new RefreshToken(refreshToken));

        log.info("---------------------------------------------------------------------");
    }

    public User findMemberEmail(String email) {
        return userRepository
                .findByEmail(email)
                .orElseThrow(() -> new RuntimeException("회원이 존재하지 않습니다"));
    }

    public List<User> getTotalRank(){
        PageRequest pageRequest = PageRequest.of(0,10, Sort.by(Sort.Direction.DESC,"accumulatedCalorie"));

        return userRepository.findBy(pageRequest).getContent();
    }


}
