package com.example.management_backend.pojo.BO.request;

import cn.hutool.http.Method;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
@EqualsAndHashCode
public class RequestBO {
	@ApiModelProperty(value = "请求url")
	private String url;

	@ApiModelProperty(value = "请求方法")
	private Method method;

	@ApiModelProperty(value = "请求体")
	private String body;

	@ApiModelProperty(value = "请求头")
	private Map<String, String> headers;
}