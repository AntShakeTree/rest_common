package com.maxc.rest.common.exception;


import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;

import java.io.EOFException;

/**
 * ExceptionHandle 异常处理类
 * 
 * @author ant_shake_tree
 */
public class ExceptionHandle {
	static Logger logger = Logger.getLogger(RestException.class);

	public static RestException throwException(Exception e) {
		return changeCustomerExceptionCode(e);
	}

	public static RestException changeCustomerExceptionCode(Exception e) {
		if (e instanceof RestException) {
			return (RestException) e;
		}
		
		ExceptionCode ec;
		if (e instanceof NullPointerException
				|| e instanceof java.lang.ClassCastException
				|| e instanceof java.lang.ClassNotFoundException
				|| e instanceof java.lang.NoSuchFieldException
				|| e instanceof java.lang.IndexOutOfBoundsException) {
			logger.error(e.getMessage(), e);
			ec = ExceptionCode.AbnormalException;
		} else if (e instanceof EOFException
				|| e instanceof JsonProcessingException) {
			ec = ExceptionCode.BadRequestException;
		} else if (e instanceof ResourceNoFoundException) {
			ec = ExceptionCode.ResourceNoFoundException;
		} else if (e instanceof DatabaseException) {
			ec = ExceptionCode.DatabaseException;
		} else if (e instanceof IllegalArgumentException) {
			ec = ExceptionCode.BadRequestException;
		} else if (e instanceof JsonMappingException) {
			ec = ExceptionCode.BadRequestException;
		}else if(e instanceof ParametersException){
			RestException restException = new RestException(e);
			ParametersException parametersException =(ParametersException)e;
			restException.setErrorCode(parametersException.error());
			restException.setMessage(parametersException.getMessage());
			return restException;
		}
		else {
			ec = ExceptionCode.UnknowException;
		}
		RestException restException = new RestException(e);
		restException.setErrorCode(ec.getErrorCode());
		return restException;
	}

}
