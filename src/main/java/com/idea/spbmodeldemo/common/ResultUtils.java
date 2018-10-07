package com.idea.spbmodeldemo.common;



public class ResultUtils<T> {

	public final static ResultUtils me = new ResultUtils();

	/**
	 * 成功
	 * @return
	 */
	public static ResponseModel<Boolean> ok() {
		BaseResult result = new BaseResult(StatusCode.S_SUCCESS);
		ResponseModel<Boolean> model = new ResponseModel<Boolean>();
		model.setResult(result);
		model.setEntity(true);
		return model;
	}
	/**
	 * 失败
	 * @return
	 */
	public static ResponseModel<Boolean> fail() {
		BaseResult result = new BaseResult(StatusCode.S_EXCEPTION);
		ResponseModel<Boolean> model = new ResponseModel<Boolean>();
		model.setResult(result);
		model.setEntity(false);
		return model;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResponseModel<T> success(T data) {
		BaseResult res = new BaseResult(StatusCode.S_SUCCESS);
		ResponseModel R = new ResponseModel<>();
		R.setResult(res);
		R.setEntity(data);
		return R;
	}
	
	/**
	 * 参数错误
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static ResponseModel errorParam() {
		BaseResult res = new BaseResult(StatusCode.S_PARAM_ERROR);
		ResponseModel R = new ResponseModel<>();
		R.setResult(res);
		R.setEntity(null);
		return R;
	}

	public static ResponseModel errorParam(ResponseModel R) {
		BaseResult res = new BaseResult(StatusCode.S_PARAM_ERROR);
		R.setResult(res);
		R.setEntity(null);
		return R;
	}
	
	/**
	 * 自定义code
	 * @param statuCode
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static ResponseModel error(StatusCode statuCode,ResponseModel r) {
		BaseResult res = new BaseResult(statuCode);
		r.setResult(res);
		r.setEntity(statuCode.getDesc());
		return r;
	}

	@SuppressWarnings("rawtypes")
	public static ResponseModel error(StatusCode statuCode,String msg) {
		BaseResult res = new BaseResult(statuCode,msg);
		ResponseModel R = new ResponseModel<>();
		R.setResult(res);
		R.setEntity(null);
		return R;
	}

	@SuppressWarnings("rawtypes")
	public ResponseModel<T> error(StatusCode statuCode,String msg,T t) {
		BaseResult res = new BaseResult(statuCode,msg);
		ResponseModel R = new ResponseModel<>();
		R.setEntity(t);
		R.setResult(res);
		return R;
	}
	
	@SuppressWarnings("rawtypes")
	public static ResponseModel error(StatusCode statusCode) {
		BaseResult res = new BaseResult(statusCode);
		ResponseModel R = new ResponseModel<>();
		R.setResult(res);
		R.setEntity(statusCode.getDesc());
		return R;
	}
	
	/**
	 * 服务器异常
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static ResponseModel systemError() {
		BaseResult res = new BaseResult(StatusCode.S_EXCEPTION);
		ResponseModel R = new ResponseModel<>();
		R.setResult(res);
		R.setEntity(null);
		return R;
	}
	
}
