package item;

import cmn.DTO;

public class ItemDTO extends DTO {
	
	private String name;
	private int price;
	private String size;
	
	public ItemDTO(String name, int price, String size) {
		 
		this.name = name;
		this.price = price;
		this.size = size;
	}

	public ItemDTO() {
		// TODO Auto-generated constructor stub
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

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "\n"
				+ "◆◆◆ 상품명: " + name + ", 가격: " + price + ", 사이즈: " + size;
		
	}
	
	
	
	
	
	
	
	

}
