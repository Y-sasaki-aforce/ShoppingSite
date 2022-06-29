package jp.co.aforce.bean;

public class ProductBean implements java.io.Serializable{

	private int product_id;
	private String product_name;
	private int product_price;
	private String order_date;


	public ProductBean(
			int product_id,
			String product_name,
			int product_price
			) {
				this.product_id = product_id;
				this.product_name = product_name;
				this.product_price = product_price;
		}

		public ProductBean() {
		}

	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getProduct_price() {
		return product_price;
	}
	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}



}
