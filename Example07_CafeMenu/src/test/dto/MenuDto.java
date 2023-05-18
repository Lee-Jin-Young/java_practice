package test.dto;

public class MenuDto {
	private String name;
	private String ice;
	private int price;
	
	public MenuDto() {
		
	}
	
	public MenuDto(String name, String ice, int price) {
		super();
		this.name = name;
		this.ice = ice;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIce() {
		return ice;
	}

	public void setIce(String ice) {
		this.ice = ice;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
