class Product {
	private int productid;
	private Categories Categories;
	private String mark;
	private String model;
	private double price;
	
	public Product() {}
	
	public Product(int productid, Categories categories, String mark, String model, double price) {
		super();
		this.productid = productid;
		Categories = categories;
		this.mark = mark;
		this.model = model;
		this.price = price;
	}

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public Categories getCategories() {
		return Categories;
	}
	


	public void setCategories(Categories categories) {
		Categories = categories;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", Categories=" + Categories + ", mark=" + mark + ", model=" + model
				+ ", price=" + price + "]";
	}
	
	
	
	

}
