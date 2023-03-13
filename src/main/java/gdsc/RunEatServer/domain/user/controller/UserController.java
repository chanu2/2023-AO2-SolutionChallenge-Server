package gdsc.RunEatServer.domain.user.controller;


import gdsc.RunEatServer.domain.user.dto.request.LoginDto;
import gdsc.RunEatServer.domain.user.entity.User;
import gdsc.RunEatServer.domain.user.service.UserService;
import gdsc.RunEatServer.global.googleVerifier.TokenVerifier;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserService userService;
    private final TokenVerifier tokenVerifier;


    // 로그인
    @PostMapping("/signIn")
    public Boolean signIn(@RequestParam String idTokenString,HttpServletResponse response) throws GeneralSecurityException, IOException {

        String email = tokenVerifier.tokenVerify(idTokenString);

        return userService.signIn(email, response);
    }


    //회원가입
    @PostMapping("/signUp")
    public Boolean signUp(@RequestParam String idTokenString, @RequestBody LoginDto loginDto, HttpServletResponse response) throws GeneralSecurityException, IOException {

        String email = tokenVerifier.tokenVerify(idTokenString);
        return userService.signUp(email, loginDto, response);
    }


}
