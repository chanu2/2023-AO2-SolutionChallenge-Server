package gdsc.RunEatServer.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /* 400 BAD_REQUEST : 잘못된 요청 */
    /* 401 UNAUTHORIZED : 인증되지 않은 사용자 */


    INVALID_AUTH_TOKEN(401, "권한 정보가 없는 토큰입니다."),

    /* 404 NOT_FOUND : Resource를 찾을 수 없음 */
    USER_NOT_FOUND(404, "해당하는 정보의 사용자를 찾을 수 없습니다."),
    USER_EXISTED(404, "이미 존재하는 회원입니다"),
    DUPLICATE_LOGIN(404, "해당 아이디는 이미 존재합니다."),

    GROUP_NOT_HOST(400,  "방의 호스트가 아닙니다"),

    /* 409 : CONFLICT : Resource의 현재 상태와 충돌. 보통 중복된 데이터 존재 */
    INVALID_REFRESH_TOKEN(400, "리프레시 토큰이 유효하지 않습니다"),
    INVALID_ACCESS_TOKEN(400, "Access 토큰이 유효하지 않습니다"),
    MISMATCH_REFRESH_TOKEN(400, "리프레시 토큰의 유저 정보가 일치하지 않습니다"),
    REFRESH_TOKEN_NOT_EXIST(400, "리프레시 토큰 정보가 올바르지 않습니다"),


    BAD_FILE_EXTENSION(404,  "FILE extension error"),
    FILE_EMPTY(404,  "FILE empty"),
    FILE_UPLOAD_FAIL(404,  "FILE upload fail"),


    REFRESH_TOKEN_NOT_FOUND(404, "로그아웃 된 사용자입니다"),
    NO_ERROR_TYPE(404, "오류 발생"),
    PROFILE_IMAGE_NOT_FOUND(404,  "PROFILE Not Found"),

    FOOD_IMAGE_NOT_FOUND(404,  "PROFILE Not Found"),

    CHARACTER_NOT_FOUND(404,  "Character Not Found"),

    INTERNAL_SERVER_ERROR(500,"서버 에러")


    ;

    private int status;
    private String reason;
}