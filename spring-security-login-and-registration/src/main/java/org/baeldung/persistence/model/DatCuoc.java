package org.baeldung.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DatCuoc {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	 
	 private String email;
	 private Double chan;
	 private Double le;
	 private Double _4den;
	 private Double _1trang3den;
	 private Double _1den3trang;
	 private Double _4trang;
	 private int maBan;
	 private Double tongxu;
	 
	
	public Double getTongxu() {
		return tongxu;
	}
	public void setTongxu(Double tongxu) {
		this.tongxu = tongxu;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Double getChan() {
		return chan;
	}
	public void setChan(Double chan) {
		this.chan = chan;
	}
	public Double getLe() {
		return le;
	}
	public void setLe(Double le) {
		this.le = le;
	}
	public Double get_4den() {
		return _4den;
	}
	public void set_4den(Double _4den) {
		this._4den = _4den;
	}
	public Double get_1trang3den() {
		return _1trang3den;
	}
	public void set_1trang3den(Double _1trang3den) {
		this._1trang3den = _1trang3den;
	}
	public Double get_1den3trang() {
		return _1den3trang;
	}
	public void set_1den3trang(Double _1den3trang) {
		this._1den3trang = _1den3trang;
	}
	public Double get_4trang() {
		return _4trang;
	}
	public void set_4trang(Double _4trang) {
		this._4trang = _4trang;
	}
	public int getMaBan() {
		return maBan;
	}
	public void setMaBan(int maBan) {
		this.maBan = maBan;
	}
	 
	
	 
	 
}
