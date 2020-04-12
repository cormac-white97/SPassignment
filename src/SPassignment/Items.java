package SPassignment;

public class Items {
	int sku;
	String name;
	String manufacturer;
	double price;
	String category;
	String imagePath;
	String createdBy;
	public Items(int sku, String name, String manufacturer, double price, String category, String imagePath,
			String createdBy) {
		super();
		this.sku = sku;
		this.name = name;
		this.manufacturer = manufacturer;
		this.price = price;
		this.category = category;
		this.imagePath = imagePath;
		this.createdBy = createdBy;
	}
	public int getSku() {
		return sku;
	}
	public void setSku(int sku) {
		this.sku = sku;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	
	
	
}
