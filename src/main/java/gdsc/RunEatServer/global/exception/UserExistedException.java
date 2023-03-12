package gdsc.RunEatServer.global.exception;

import gdsc.RunEatServer.global.error.exception.ErrorCode;
import gdsc.RunEatServer.global.error.exception.RunEatException;

public class UserExistedException extends RunEatException {

    public static final RunEatException EXCEPTION = new UserExistedException();

    private UserExistedException() {
        super(ErrorCode.USER_EXISTED);
    }
}