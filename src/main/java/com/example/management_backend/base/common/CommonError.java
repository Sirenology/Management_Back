package com.example.management_backend.base.common;

/**
 * @author Sirenology
 */


public interface CommonError {
	int getErrCode();

	String getErrMsg();

	void setErrMsg(String msg);
}