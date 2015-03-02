package org.baeldung.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Phong {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	
		private int maBan;
		
		private int loaiBan;
		
		private Double xuToiThieu;
		
		private int soNguoi;
		
		private int soChoi;
		public int getSoChoi() {
			return soChoi;
		}

		public void setSoChoi(int soChoi) {
			this.soChoi = soChoi;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
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
