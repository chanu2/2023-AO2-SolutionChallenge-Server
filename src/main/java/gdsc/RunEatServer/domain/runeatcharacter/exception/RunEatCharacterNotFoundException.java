package gdsc.RunEatServer.domain.runeatcharacter.exception;

import gdsc.RunEatServer.global.error.exception.ErrorCode;
import gdsc.RunEatServer.global.error.exception.RunEatException;

public class RunEatCharacterNotFoundException extends RunEatException {

    public static final RunEatException EXCEPTION = new RunEatCharacterNotFoundException();

    private RunEatCharacterNotFoundException() {
        super(ErrorCode.CHARACTER_NOT_FOUND);
    }
}
