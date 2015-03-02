package org.baeldung.persistence.service;

import javax.persistence.Column;

public class AdminDto {
	 private Double chan;
	 private Double cuale;
	 private Double bonden;
	 private Double tragbaden;
	 private Double denbatrang;
	 private Double bontrang;
	 private int phut;
	 private int giay;
	 private Double hoahong;
	 private String titile;
	 private String editor;
	 private String napxutitile;
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
	public Double getChan() {
		return chan;
	}
	public void setChan(Double chan) {
		this.chan = chan;
	}
	
	public Double getCuale() {
		return cuale;
	}
	public void setCuale(Double cuale) {
		this.cuale = cuale;
	}
	public Double getBonden() {
		return bonden;
	}
	public void setBonden(Double bonden) {
		this.bonden = bonden;
	}
	public Double getTragbaden() {
		return tragbaden;
	}
	public void setTragbaden(Double tragbaden) {
		this.tragbaden = tragbaden;
	}
	public Double getDenbatrang() {
		return denbatrang;
	}
	public void setDenbatrang(Double denbatrang) {
		this.denbatrang = denbatrang;
	}
	public Double getBontrang() {
		return bontrang;
	}
	public void setBontrang(Double bontrang) {
		this.bontrang = bontrang;
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
