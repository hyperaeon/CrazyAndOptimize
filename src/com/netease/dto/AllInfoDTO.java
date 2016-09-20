package com.netease.dto;

public class AllInfoDTO {

	private BasicInfoDTO basicInfoDTO;
	
	private LoanRecordDTO LoanRecordDTO;
	
	private PublicRecordDTO publicRecordDTO;
	
	private CheckRecordDTO checkRecordDTO;

	public BasicInfoDTO getBasicInfoDTO() {
		return basicInfoDTO;
	}

	public void setBasicInfoDTO(BasicInfoDTO basicInfoDTO) {
		this.basicInfoDTO = basicInfoDTO;
	}

	public LoanRecordDTO getLoanRecordDTO() {
		return LoanRecordDTO;
	}

	public void setLoanRecordDTO(LoanRecordDTO loanRecordDTO) {
		LoanRecordDTO = loanRecordDTO;
	}

	public PublicRecordDTO getPublicRecordDTO() {
		return publicRecordDTO;
	}

	public void setPublicRecordDTO(PublicRecordDTO publicRecordDTO) {
		this.publicRecordDTO = publicRecordDTO;
	}

	public CheckRecordDTO getCheckRecordDTO() {
		return checkRecordDTO;
	}

	public void setCheckRecordDTO(CheckRecordDTO checkRecordDTO) {
		this.checkRecordDTO = checkRecordDTO;
	}
	
}
