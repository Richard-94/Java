import java.time.LocalDate;
import java.util.List;

public class Prodotti extends Svolgimento {
	private String name;
	private String category;
	private double price;

	

	public Prodotti(long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Prodotti> products,
			Customer customer, String name, String category, double price) {
		super(id, status, orderDate, deliveryDate, products, customer);
		this.name = name;
		this.category = category;
		this.price = price;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "Prodotti [name=" + name + ", category=" + category + ", price=" + price + "]";
	}




}
