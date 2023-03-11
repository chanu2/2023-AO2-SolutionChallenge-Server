package gdsc.RunEatServer.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class RunEatException extends RuntimeException{
    ErrorCode errorCode;
}
