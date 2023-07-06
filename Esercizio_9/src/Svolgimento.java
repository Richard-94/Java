import java.time.LocalDate;
import java.util.List;


public class Svolgimento {
	private long id;
	private String status;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	private List<Prodotti> products;
	private Customer customer;
	public Svolgimento(long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Prodotti> products,
			Customer customer) {
		super();
		this.id = id;
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.products = products;
		this.customer = customer;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public List<Prodotti> getProducts() {
		return products;
	}
	public void setProducts(List<Prodotti> products) {
		this.products = products;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Svolgimento [id=" + id + ", status=" + status + ", orderDate=" + orderDate + ", deliveryDate="
				+ deliveryDate + ", products=" + products + ", customer=" + customer + "]";
	}
	
	

	

}
