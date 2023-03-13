package gdsc.RunEatServer.domain.user.service;


import gdsc.RunEatServer.domain.asset.dto.CharacterImageDto;
import gdsc.RunEatServer.domain.food.service.AssetUtils;
import gdsc.RunEatServer.domain.runeatcharacter.entity.RunEatCharacter;
import gdsc.RunEatServer.domain.runeatcharacter.repository.RunEatCharacterRepository;
import gdsc.RunEatServer.domain.user.dto.request.LoginDto;
import gdsc.RunEatServer.domain.user.entity.RefreshToken;
import gdsc.RunEatServer.domain.user.entity.User;
import gdsc.RunEatServer.domain.user.repository.RefreshTokenRepository;
import gdsc.RunEatServer.domain.user.repository.UserRepository;
import gdsc.RunEatServer.global.exception.UserExistedException;
import gdsc.RunEatServer.global.exception.UserNotFoundException;
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

    private final AssetUtils assetUtils;

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    private final RunEatCharacterRepository runEatCharacterRepository;


    public Boolean signIn (String email, HttpServletResponse response) {

        User user = findMemberEmail(email);
        createToken(email, response);
        return true;
    }

    @Transactional
    public Boolean signUp (String email, LoginDto loginDto, HttpServletResponse response) {

        if(!userRepository.findByEmail(email).isEmpty()) {
           throw UserExistedException.EXCEPTION;
        }

        User user = userRepository.save(
                User.builder()
                        .email(email)
                        .nickname(loginDto.getNickname())
                        .gender(loginDto.getSex())
                        .roles(Collections.singletonList("ROLE_USER"))
                        .build());

        CharacterImageDto characterImageDto = assetUtils.registerCharacterImage();

        runEatCharacterRepository.save(
                RunEatCharacter.builder()
                        .user(user)
                        .characterImagePath(characterImageDto.getCharacterUrl())
                        .build()

        );

        // 어세스, 리프레시 토큰 발급 및 헤더 설정
        log.info("email={}",email);
        createToken(email, response);

        return true;
    }


    public void createToken(String email, HttpServletResponse response) {

        String accessToken = jwtUtil.createAccessToken(email, Collections.singletonList("ROLE_USER"));
        String refreshToken = jwtUtil.createRefreshToken(email, Collections.singletonList("ROLE_USER"));

        jwtUtil.setHeaderAccessToken(response, accessToken);
        jwtUtil.setHeaderRefreshToken(response, refreshToken);

        refreshTokenRepository.save(new RefreshToken(refreshToken));
    }

    public User findMemberEmail(String email) {
        return userRepository
                .findByEmail(email)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }




}
