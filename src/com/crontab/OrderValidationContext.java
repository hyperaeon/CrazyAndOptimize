package com.crontab;



public class OrderValidationContext {
	
	
	private String errorMsg;
	
	private String user;
	
	private String inputJson;
	private String outputJson;
	private JsonOrderSizeTier inputTierObject;
	private Object outputObject;
	private JsonOrderNormalSize inputNormalSizeObject;
	private JsonImFund inputImFundObject;
	private JsonCurrencyPairCutoff inputCutoffObject;
	
	
	public String getInputJson() {
		return inputJson;
	}
	public void setInputJson(String inputJson) {
		this.inputJson = inputJson;
	}
	public String getOutputJson() {
		return outputJson;
	}
	public void setOutputJson(String outputJson) {
		this.outputJson = outputJson;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	
	
	public JsonOrderSizeTier getInputTierObject() {
		return inputTierObject;
	}
	public void setInputTierObject(JsonOrderSizeTier inputTierObject) {
		this.inputTierObject = inputTierObject;
	}
	public Object getOutputObject() {
		return outputObject;
	}
	public void setOutputObject(Object outputObject) {
		this.outputObject = outputObject;
	}
	public JsonOrderNormalSize getInputNormalSizeObject() {
		return inputNormalSizeObject;
	}
	public void setInputNormalSizeObject(JsonOrderNormalSize inputNormalSizeObject) {
		this.inputNormalSizeObject = inputNormalSizeObject;
	}
	public JsonImFund getInputImFundObject() {
		return inputImFundObject;
	}
	public void setInputImFundObject(JsonImFund inputImFundObject) {
		this.inputImFundObject = inputImFundObject;
	}
	public JsonCurrencyPairCutoff getInputCutoffObject() {
		return inputCutoffObject;
	}
	public void setInputCutoffObject(JsonCurrencyPairCutoff inputCutoffObject) {
		this.inputCutoffObject = inputCutoffObject;
	}
	
}
