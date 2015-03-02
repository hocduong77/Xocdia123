package org.baeldung.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	 private Double chan;
	 private Double le;
	 private Double _4den;
	 private Double _1trang3den;
	 private Double _1den3trang;
	 private Double _4trang;
	 private int phut;
	 private int giay;
	 private Double hoahong;
	 @Column(name = "titile", columnDefinition = "varchar(1000) COLLATE utf8_bin")
	 private String titile;
	 @Column(name = "editor", columnDefinition = "varchar(7000) COLLATE utf8_bin")
	 private String editor; 
	 @Column(name = "napxutitile", columnDefinition = "varchar(1000) COLLATE utf8_bin")
	 private String napxutitile;
	 @Column(name = "napxueditor", columnDefinition = "varchar(7000) COLLATE utf8_bin")
	 private String napxueditor;
	 
	 
	 
	public String getNapxutitile() {
		return napxutitile;
	}
	public void setNapxutitile(String napxutitile) {
		this.napxutitile = napxutitile;
	}
	public String getNapxueditor() {
		return napxueditor;
	}
	public void setNapxueditor(String napxueditor) {
		this.napxueditor = napxueditor;
	}
	public String getTitile() {
		return titile;
	}
	public void setTitile(String titile) {
		this.titile = titile;
	}
	public String getEditor() {
		return editor;
	}
	public void setEditor(String editor) {
		this.editor = editor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getPhut() {
		return phut;
	}
	public void setPhut(int phut) {
		this.phut = phut;
	}
	public int getGiay() {
		return giay;
	}
	public void setGiay(int giay) {
		this.giay = giay;
	}
	public Double getHoahong() {
		return hoahong;
	}
	public void setHoahong(Double hoahong) {
		this.hoahong = hoahong;
	}
	
	 
	 

}
