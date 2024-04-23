package com.pcwk.ehr.member;

import com.pcwk.ehr.cmn.DTO;

public class ItemDTO extends DTO {
	
	//상품 : 상의의 상품명, 상품가격, 상품사이즈
	private String name;
	private int price;
	private int size;
	
	public ItemDTO(String name, int price, int size) {
		super();
		this.name = name;
		this.price = price;
		this.size = size;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", price=" + price + ", size=" + size + "]";
	}
	
}