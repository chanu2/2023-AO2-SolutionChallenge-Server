package gdsc.RunEatServer.domain.asset.exception;

import gdsc.RunEatServer.global.error.exception.ErrorCode;
import gdsc.RunEatServer.global.error.exception.RunEatException;

public class CharacterImageNotFoundException extends RunEatException {

    public static final RunEatException EXCEPTION = new CharacterImageNotFoundException();

    private CharacterImageNotFoundException() {
        super(ErrorCode.PROFILE_IMAGE_NOT_FOUND);
    }
}