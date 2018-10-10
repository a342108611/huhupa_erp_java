package com.huhupa.common;

/**用于封装统一返回结果集*/
public class ResultObject {
	private static final int SUCCESS=1;
	private static final int ERROR=0;
	/**返回结果的状态*/
	private int state;
	/**封装返回结果的提示消息*/
	private String message;
	/**封装返回的数据*/
	private Object data;
	
	public ResultObject() {
		this.state=SUCCESS;
		this.message="OK";
	}
	
	public ResultObject(Object data){
		this();
		this.data=data;
	}
	
	public ResultObject(Throwable e){
		this.state=ERROR;
		this.message=e.getMessage();
	}
	
	public int getState() {
		return state;
	}
	public String getMessage() {
		return message;
	}
	public Object getData() {
		return data;
	}
}
