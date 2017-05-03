package com.ip.dto;

import java.io.Serializable;

/**
 * 封装淘宝返回来的数据
 * @author hzliyong
 *
 */
public class TaobaoIpDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2489289246690630783L;

	private int code;
	
	private TaobaoIpDataDTO data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public TaobaoIpDataDTO getData() {
		return data;
	}

	public void setData(TaobaoIpDataDTO data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "TaobaoIpDTO [code=" + code + ", data=" + data + "]";
	}
	
}
