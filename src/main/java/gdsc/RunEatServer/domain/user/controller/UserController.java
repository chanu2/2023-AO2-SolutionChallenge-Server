package gdsc.RunEatServer.domain.user.controller;


import gdsc.RunEatServer.domain.user.dto.request.LoginDto;
import gdsc.RunEatServer.domain.user.service.UserService;
import gdsc.RunEatServer.global.googleVerifier.TokenVerifier;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    // 회원가입 요청

    @PostMapping("/signIn")
    public ResponseEntity signIn(@RequestParam String idTokenString,HttpServletResponse response) throws GeneralSecurityException, IOException {

        String email = tokenVerifier.tokenVerify(idTokenString);

        Boolean aBoolean = userService.signIn(email, response);

        return ResponseEntity.ok().body("200");

    }


    // 로그인
    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestParam String idTokenString, @RequestBody LoginDto loginDto, HttpServletResponse response) throws GeneralSecurityException, IOException {

        String email = tokenVerifier.tokenVerify(idTokenString);
        log.info("email={}",email);


        Boolean aBoolean = userService.signUp(email, loginDto, response);
        log.info("Aaa={}",aBoolean);

        return ResponseEntity.ok(200);
    }


}
