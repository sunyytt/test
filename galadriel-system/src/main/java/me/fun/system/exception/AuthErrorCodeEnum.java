package me.fun.system.exception;


/**
 * @ClassName: AuthErrorCodeEnum
 * @Description: AuthErrorCodeEnum
 * @author sunyy
 * @date 2019/7/15
 * @version V1.0
 */
public enum AuthErrorCodeEnum {

    /**验证码不存在或已过期 */
    AE500000("500000", "验证码不存在或已过期!"),
    /**验证码不存在或已过期 */
    AE500001("500001", "验证码错误"),

    /**
     * aouth sms短信发送失败
     */
    AE510001("510001","短信发送失败"),

    /**
     * aouth 登录账号格式有误
     */
    AE510002("510002","无此类短信验证模版"),

    /**
     * aouth sms短信重复发送
     */
    AE510003("510003","短信已发送,请勿重复发送"),

    /**
     * 令牌校验失败
     */
    AE510004("510004","令牌校验失败"),
    /**
     * 令牌延期失败
     */
    AE510005("510005","令牌延期失败"),
    /**
     * 令牌生成失败
     */
    AE510006("510006","令牌生成失败"),
    /**
     * 授权生成失败
     */
    AE510007("510007","授权生成失败"),
    /**
     * 令牌销毁失败
     */
    AE510008("510008","令牌销毁失败"),
    /**
     * 匿名用户访问无权限资源
     */
    AE510009("510009","匿名用户访问无权限资源"),
    /**
     * 用户访问无权限资源
     */
    AE510010("510010","用户访问无权限资源"),

    /**
     * 短信模板不正确
     */
    AE510011("510011","短信模板不正确"),
    /**
     * 用户唯一标识不能为空
     */
    AE510012("510012","用户唯一标识不能为空"),
    /**
     * 用户唯一标识不能为空
     */
    AE510013("510013","用户唯一标识长度不能超过64字节"),
    /**
     * 用户唯一标识不能为空
     */
    AE510014("510014","用户唯一标识长度不能超过4096字节"),
    ;

    private final String code;
    private final String message;

    AuthErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMessage(String code) {
        AuthErrorCodeEnum[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            AuthErrorCodeEnum c = var1[var3];
            if (c.code() == code) {
                return c.message;
            }
        }

        return null;
    }

    public String code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
