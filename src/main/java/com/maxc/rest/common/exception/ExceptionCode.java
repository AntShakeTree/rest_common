package com.maxc.rest.common.exception;


/**
 * EngineExceptionCode
 * 
 * @author ant_shake_tree
 * @version V0.0.0.0 0号项目
 * 
 */
public enum ExceptionCode {
	/**
	 * Engine 成功没有异常
	 */
	Success(ERROR_CODE.SUCCESS),
	/**
	 * Engine 未知错误
	 */
	UnknowException(ERROR_CODE.UNKNOWN),
	/**
	 * 
	 */
	
	/**
	 *  请求参赛错误
	 */
	BadRequestException(ERROR_CODE.BAD_REQUEST),
	/**
	 *  资源没找到异常
	 */
	ResourceNoFoundException(ERROR_CODE.NOT_FOUND),
	/**
	 *  数据库异常
	 */
	DatabaseException(ERROR_CODE.DATABASE_UNTOUCHABLE),
	
	/**
	 *  认证失败
	 */
	AuthenticateException(ERROR_CODE.CHECKLOGIN_FAIL),
	AbnormalException(ERROR_CODE.ABNORMAL);
	
	int errorCode;

	private ExceptionCode(int errorCode)
	{
		this.errorCode = errorCode;
	}

	public int getErrorCode()
	{
		return errorCode;
	}

	
	private final static class ERROR_CODE
	{
		/*********************公共错误码***********************/
		// 成功
		public final static int SUCCESS = 0;
		// 未知错误
		public final static int UNKNOWN = 0x50000500;

		// 找不到指定资源
		public final static int NOT_FOUND = 0x50000404;
		//调用引擎无效错误码
		public static final int ABNORMAL =  0x50000006;

		
		/*********************错误码***********************/
		// 底层平台异常
		public final static int BAD_REQUEST = 0x50000001;
		// 数据库连接异常
		public final static int DATABASE_UNTOUCHABLE = 0x50000002;
		//  认证失败
		public final static int CHECKLOGIN_FAIL = 0x50000401;
		

	}
	
}
