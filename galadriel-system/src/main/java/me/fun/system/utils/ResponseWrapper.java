
package me.fun.system.utils;

import org.apache.commons.lang3.StringUtils;


/**
 * @ClassName: ResponseWrapper
 * @Description: 响应包装类
 * @author sunyy
 * @date 2020/4/26
 * @version V1.0
 */
public class ResponseWrapper {

	private ResponseWrapper() {
	}

	/**
	 * 响应包装
	 * @param code 响应码
	 * @param message 响应信息
	 * @param o 任意信息
	 * @return Response<E>
	 * @author GaoShuai
	 * @time: 2019/6/20 16:47
	 */
	public static <E> Response<E> resp(String code, String message, E o) {
		return new Response<>(code, message, o);
	}
	/**
	 * 响应包装
	 * @param code 响应码
	 * @param message 响应信息
	 * @param subCode 子响应码
	 * @param subMessage 子响应信息
	 * @param o 任意信息
	 * @return Response<E>
	 * @author GaoShuai
	 * @time: 2019/6/20 16:48
	 */
	public static <E> Response<E> resp(String code, String message, String subCode, String subMessage,E o) {
		return new Response<>(code, message, subCode, subMessage, o);
	}

	/**
	 * 响应包装
	 * @param code 响应码
	 * @param message 响应信息
	 * @return Response<E>
	 * @author GaoShuai
	 * @time: 2019/6/20 16:48
	 */
	public static <E> Response<E> resp(String code, String message) {
		return resp(code, message, null);
	}

	/**
	 * 响应包装
	 * @param code 响应码
	 * @return Response<E>
	 * @author GaoShuai
	 * @time: 2019/6/20 16:48
	 */
	public static <E> Response<E> resp(String code) {
		return resp(code, null);
	}

	/**
	 * 响应包装
	 * @param e 异常信息
	 * @return Response<E>
	 * @author GaoShuai
	 * @time: 2019/6/20 16:49
	 */
	public static <E> Response<E> resp(Exception e) {
		return new Response<>(Response.ERROR_CODE, e.getMessage());
	}

	/**
	 * 响应包装
	 * @param response 响应信息
	 * @return E
	 * @author GaoShuai
	 * @time: 2019/6/20 16:49
	 */
	public static <E> E unResp(Response<E> response) {
		return response.getData();
	}


	/**
	 * 响应包装
	 * @return Response<E>
	 * @author GaoShuai
	 * @time: 2019/6/20 16:49
	 */
	public static <E> Response<E> error() {
		return resp(Response.ERROR_CODE, Response.ERROR_MESSAGE);
	}

	/**
	 * 响应包装
	 * @param message 响应信息
	 * @return Response<E>
	 * @author GaoShuai
	 * @time: 2019/6/20 16:50
	 */
    public static <E> Response<E> error(String message) {
        return resp(Response.ERROR_CODE, StringUtils.isBlank(message) ? Response.ERROR_MESSAGE : message);
    }

	/**
	 * 响应包装
	 * @return Response<E>
	 * @author GaoShuai
	 * @time: 2019/6/20 16:50
	 */
	public static <E> Response<E> ok() {
		return new Response<>();
	}

	/**
	 * 响应包装
	 * @param o 任意信息
	 * @return Response<E>
	 * @author sunyy
	 * @time: 2019/6/20 16:50
	 */
	public static <E> Response<E> ok(E o) {
		return new Response<>(Response.SUCCESS_CODE, Response.SUCCESS_MESSAGE, o);
	}

}
