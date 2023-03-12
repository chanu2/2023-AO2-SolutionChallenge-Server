package gdsc.RunEatServer.global.exception;

import gdsc.RunEatServer.global.error.exception.ErrorCode;
import gdsc.RunEatServer.global.error.exception.RunEatException;

public class UserNotFoundException extends RunEatException {

    public static final RunEatException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}