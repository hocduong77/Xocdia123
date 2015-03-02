package org.baeldung.persistence.service;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class NguoiChoiDto {
	@NotNull
	@NotEmpty
	private int maBan;
	@NotNull
	@NotEmpty
 	private String NguoiChoi;
	public int getMaBan() {
		return maBan;
	}
	public void setMaBan(int maBan) {
		this.maBan = maBan;
	}
	public String getNguoiChoi() {
		return NguoiChoi;
	}
	public void setNguoiChoi(String nguoiChoi) {
		NguoiChoi = nguoiChoi;
	}

}
