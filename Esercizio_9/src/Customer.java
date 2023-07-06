
public class Customer {
	
	private String name;
	private Integer tier;
	
	
	public Customer(String name, Integer tier) {
		super();
		this.name = name;
		this.tier = tier;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getTier() {
		return tier;
	}


	public void setTier(Integer tier) {
		this.tier = tier;
	}


	@Override
	public String toString() {
		return "Customer [name=" + name + ", tier=" + tier + "]";
	}
	
	
	
	


	


}
