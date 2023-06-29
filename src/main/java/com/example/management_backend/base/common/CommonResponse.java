package com.example.management_backend.base.common;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "通用回复")
public class CommonResponse<T> {
	private Integer code;

	private String message;

	private T data;

	public static <T> CommonResponse<T> createSuccess(T data) {
		return CommonResponse.create(data, "success");
	}

	public static <T> CommonResponse<T> createFail(T data) {
		return CommonResponse.create(data, "fail");
	}

	public static <T> CommonResponse<T> success() {
		return CommonResponse.create(null, "success");
	}

	public static <T> CommonResponse<T> fail() {
		return CommonResponse.create(null, "fail");
	}

	public static <T> CommonResponse<T> create(T data, String message) {
		return CommonResponse.create(200, data, message);
	}

	public static <T> CommonResponse<T> create(Integer code, T data, String message) {
		CommonResponse<T> commonResponse = new CommonResponse<>();
		commonResponse.setCode(code);
		commonResponse.setMessage(message);
		commonResponse.setData(data);
		return commonResponse;
	}
}
