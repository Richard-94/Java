import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;



public class Main_project {
	
	private static org.slf4j.Logger log = LoggerFactory.getLogger(Main_project.class);

	public static void main(String[] args) {
		List<Prodotti> products = new ArrayList<>();
		//Stream<Prodotti> streamBuilder = Stream.<Prodotti>builder().build();
		Customer cust1 = new Customer("Marco",2);
		Customer cust2 = new Customer("Best",1);
		Customer cust3 = new Customer("Yaw",2);
		Customer cust4 = new Customer("Ama",1);
		Customer cust5 = new Customer("Ernest",2);
		Customer cust6 = new Customer("Gabriel",2);
		
		


		LocalDate orderDate1 = LocalDate.of(2023, 2, 6);
		LocalDate deliveryDate1 = LocalDate.of(2023, 9, 6);
		LocalDate orderDate2 = LocalDate.of(2023, 7, 01);
		LocalDate deliveryDate2 = LocalDate.of(2023, 7, 05);
		LocalDate orderDate3 = LocalDate.of(2023, 01, 03);
		LocalDate deliveryDate3 = LocalDate.of(2023, 02, 06);
		LocalDate orderDate4 = LocalDate.of(2023, 11, 13);
		LocalDate deliveryDate4 = LocalDate.of(2023, 11, 25);
		LocalDate orderDate5 = LocalDate.of(2023, 07, 30);
		LocalDate deliveryDate5 = LocalDate.of(2023, 05, 14);
		LocalDate orderDate6 = LocalDate.of(2023, 10, 10);
		LocalDate deliveryDate6 = LocalDate.of(2023, 01, 14);
		
		
		
		
		
		
		
	
		Prodotti pro1 = new Prodotti(25555, "Available", orderDate1, deliveryDate1, products, cust1, "Fantasy", "Books", 200);
		Prodotti pro2 = new Prodotti(12356, "Available", orderDate2, deliveryDate2, products, cust2, "Fantasy", "Books", 1000);
		Prodotti pro3 = new Prodotti(25869, "Available", orderDate3, deliveryDate3, products, cust3, "Pampers", "Baby", 90);
		Prodotti pro4 = new Prodotti(14552, "Non-Available", orderDate4, deliveryDate4, products, cust4, "Pampers", "Baby", 150);
		Prodotti pro5 = new Prodotti(54141, "Non-Available", orderDate5, deliveryDate5, products, cust5, "Maglietta", "Boys", 50);
		Prodotti pro6 = new Prodotti(239, "Available", orderDate6, deliveryDate6, products, cust6, "Jeans", "Boys", 60);
		
		
		
		
		products.add(pro1);
		products.add(pro2);
		products.add(pro3);
		products.add(pro4);
		products.add(pro5);
		products.add(pro6);
		
		
		List<Prodotti> prod = products.stream()
			    .filter(el -> el.getCategory().equals("Books"))
			    .filter(el -> el.getPrice() > 100) 
			    .collect(Collectors.toList()); 
		//prod.forEach(show -> log.info("Prodotti: {}", show));
		
		List<Prodotti> prod1=products.stream()
				.filter(fil->fil.getCategory().equals("Baby"))
				
				.collect(Collectors.toList());
		//prod1.forEach(see->log.info("Prodotti: {}", see));
		
		
		List<Prodotti> prod2=products.stream()
				.filter(s->s.getCategory().equals("Boys"))
				.map(d->{
					double sconto=(d.getPrice()*10)/100;
					d.setPrice(d.getPrice()-sconto);
					return d;
				})
				.collect(Collectors.toList());
		
		//prod2.forEach(se->log.info("Prodotti: {}", se));
		
		
		List<Prodotti> prod3=products.stream()
				.filter(e->e.getCustomer().getTier().equals(2))
				.collect(Collectors.toList());
		prod3.forEach(se->log.info("Prodotti: {}", se.toString()));

	}
	

}

