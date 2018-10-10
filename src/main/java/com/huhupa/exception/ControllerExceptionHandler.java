package com.huhupa.exception;

import com.huhupa.common.ResultObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**此注解标识此类为全局异常处理类*/
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResultObject handleException(Exception e){
		e.printStackTrace();
		return new ResultObject(e);
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public ResultObject handleException(RuntimeException e){
		e.printStackTrace();
		return new ResultObject(e);
	}
	
}
