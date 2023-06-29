package com.example.management_backend.base.exceptions.handler;


import com.example.management_backend.base.common.CommonResponse;
import com.example.management_backend.base.exceptions.BusinessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Sirenology
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(BusinessException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Object handleException(BusinessException exception) {
		exception.printStackTrace();
		return CommonResponse.create(exception.getErrCode(), null, exception.getErrMsg());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Object handleException(MethodArgumentNotValidException exception) {
		FieldError fieldError = exception.getBindingResult().getFieldError();
		assert fieldError != null;
		return CommonResponse.create(500, null, fieldError.getDefaultMessage());
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Object handleException(DataIntegrityViolationException exception) {
		if (exception instanceof DuplicateKeyException) {
			return CommonResponse.create(500, null, "数据已存在");
		}
		return CommonResponse.create(500, null, "数据异常");
	}

	//处理其他异常
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Object handleException(Exception exception) {
		exception.printStackTrace();
		return CommonResponse.create(500, null, exception.getMessage());
	}

//	/**
//	 * 异常处理函数
//	 * 处理所有Controller类抛出的异常
//	 */
//	@ExceptionHandler(Exception.class)
//	@ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	public Object handlerException(Exception ex) {
//		return CommonResponse.create(500, new Object(), "请求出现异常");
//	}
}