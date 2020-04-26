package me.fun.system.utils;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @ClassName: Response
 * @Description: 响应信息
 * @author sunyy
 * @date 2020/4/26
 * @version V1.0
 */
@JsonInclude(Include.NON_NULL)
public class Response<T> implements Serializable {
	/**
	 * 	序列化标识
	 */
	private static final long serialVersionUID = 4893280118017319089L;
	/**
	 * 	成功码.
	 */
	public static final String SUCCESS_CODE = "000000";
	/**
	 * 成功信息.
	 */
	public static final String SUCCESS_MESSAGE = "成功";
	/**
	 * 错误码.
	 */
	public static final String ERROR_CODE = "999999";
	/**
	 * 错误信息.
	 */
	public static final String ERROR_MESSAGE = "失败";
	/**
	 * 编号.
	 */
	private String code;
	/**
	 * 信息.
	 */
	private String message;
	/**
	 * 子编号
	 */
	private String subCode;
	/**
	 * 子信息
	 */
	private String subMessage;

	/**
	 * 结果数据
	 */
	private T data;
	
	public Response() {
		this(SUCCESS_CODE, SUCCESS_MESSAGE);
	}

	public Response(String code, String message) {
		this(code, message, null);
	}

	public Response(String code, String message, T data) {
		super();
		this.code(code).message(message).data(data);
	}

	public Response(String code, String message, String subCode, String subMessage) {
		super();
		this.code(code).message(message).subCode(subCode).subMessage(subMessage);
	}

	public Response(String code, String message, String subCode, String subMessage, T data) {
		super();
		this.code(code).message(message).subCode(subCode).subMessage(subMessage).data(data);
	}

	private Response<T> code(String code) {
		this.setCode(code);
		return this;
	}

	private Response<T> message(String message) {
		this.setMessage(message);
		return this;
	}
	private Response<T> subCode(String subCode) {
		this.setSubCode(subCode);
		return this;
	}

	private Response<T> subMessage(String subMessage) {
		this.setSubMessage(subMessage);
		return this;
	}

	public Response<T> data(T data) {
		this.setData(data);
		return this;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}

	public void setSubMessage(String subMessage) {
		this.subMessage = subMessage;
	}

	public String getSubCode() {
		return subCode;
	}

	public String getSubMessage() {
		return subMessage;
	}

	@JsonIgnore
	public boolean success() {
		return Response.SUCCESS_CODE.equals(this.code);
	}


	@JsonIgnore
	public boolean error() {
		return !success();
	}

}
