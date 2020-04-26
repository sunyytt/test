package me.fun.system.exception;


/**
 * @ClassName: AuthBusinessException
 * @Description: 业务异常
 * @author sunyy
 * @date 2019/7/15
 * @version V1.0
 */
public class AuthBusinessException extends RuntimeException {
    /** 异常码 */
    protected String code;

    private static final long serialVersionUID = 3160241586346324994L;

    public AuthBusinessException() {
    }

    public AuthBusinessException(Throwable cause) {
        super(cause);
    }

    public AuthBusinessException(AuthErrorCodeEnum authErrorCodeEnum) {
        super(authErrorCodeEnum.message());
        this.code = authErrorCodeEnum.code();
    }

    public AuthBusinessException(String message) {
        super(message);
    }

    public AuthBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthBusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

    public AuthBusinessException(String code, String msgFormat, Object... args) {
        super(String.format(msgFormat, args));
        this.code = code;
    }
}
