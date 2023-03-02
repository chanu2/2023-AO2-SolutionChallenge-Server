package gdsc.RunEatServer.global;


import gdsc.RunEatServer.global.utill.security.SecurityUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@ResponseBody
public class TestController1 {

    @GetMapping("/test")
    public ResponseEntity getHello(@RequestParam String hello){

        String email = SecurityUtils.getCurrentUserEmail();

        return ResponseEntity.ok().body(email);
    }
}
