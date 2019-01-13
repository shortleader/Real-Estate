package com.budong.model.dto;

public class TradeDTO {
	private String type, trade_type, location;
	private int area, dong, ho, floor, max_floor, price;
	private String image, phone;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getDong() {
		return dong;
	}

	public void setDong(int dong) {
		this.dong = dong;
	}

	public int getHo() {
		return ho;
	}

	public void setHo(int ho) {
		this.ho = ho;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getMax_floor() {
		return max_floor;
	}

	public void setMax_floor(int max_floor) {
		this.max_floor = max_floor;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
