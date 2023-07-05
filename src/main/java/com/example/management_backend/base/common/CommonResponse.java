package com.example.management_backend.base.common;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "通用回复")
public class CommonResponse<T> {
	private Integer code;

	private String message;

	private T resData;

	public static <T> CommonResponse<T> createSuccess(T resData) {
		return CommonResponse.create(resData, "success");
	}

	public static <T> CommonResponse<T> createFail(T resData) {
		return CommonResponse.create(resData, "fail");
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

	public static <T> CommonResponse<T> create(Integer code, T resData, String message) {
		CommonResponse<T> commonResponse = new CommonResponse<>();
		commonResponse.setCode(code);
		commonResponse.setMessage(message);
		commonResponse.setResData(resData);
		return commonResponse;
	}
}
