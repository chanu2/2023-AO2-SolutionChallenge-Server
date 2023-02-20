package gdsc.RunEatServer.domain.asset.exception;

import gdsc.RunEatServer.global.error.exception.ErrorCode;
import gdsc.RunEatServer.global.error.exception.RunEatException;

public class FoodImageNotFoundException extends RunEatException {

    public static final RunEatException EXCEPTION = new FoodImageNotFoundException();

    private FoodImageNotFoundException() {
        super(ErrorCode.PROFILE_IMAGE_NOT_FOUND);
    }
}