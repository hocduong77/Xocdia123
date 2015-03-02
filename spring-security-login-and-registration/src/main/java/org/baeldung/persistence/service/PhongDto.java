package org.baeldung.persistence.service;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class PhongDto {
	@NotNull
	@NotEmpty
	private int maBan;
	
	private int loaiBan;
	
	@NotNull
	@NotEmpty
	private int soChoi;
	@NotNull
	@NotEmpty
	private Double xuToiThieu;
	@NotNull
	@NotEmpty
	private int soNguoi;
	
	public int getSoChoi() {
		return soChoi;
	}
	public void setSoChoi(int soChoi) {
		this.soChoi = soChoi;
	}
	public int getMaBan() {
		return maBan;
	}
	public void setMaBan(int maBan) {
		this.maBan = maBan;
	}
	public int getLoaiBan() {
		return loaiBan;
	}
	public void setLoaiBan(int loaiBan) {
		this.loaiBan = loaiBan;
	}
	
	public Double getXuToiThieu() {
		return xuToiThieu;
	}
	public void setXuToiThieu(Double xuToiThieu) {
		this.xuToiThieu = xuToiThieu;
	}
	public int getSoNguoi() {
		return soNguoi;
	}
	public void setSoNguoi(int soNguoi) {
		this.soNguoi = soNguoi;
	}

}
