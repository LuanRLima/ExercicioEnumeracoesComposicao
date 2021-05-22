package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import enums.OrderStatus;
import intities.Client;
import intities.Order;
import intities.OrderItem;
import intities.Product;

public class main {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order( new Date(), status, client);
		
		System.out.print("How many items to this order?" );
		int qtdeOrder = sc.nextInt();
		for(int a = 0; a < qtdeOrder; a++) {
			System.out.println("Enter #" + (a+1) + "item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			name = sc.nextLine();
			System.out.print("Product price: ");
			Double price = sc.nextDouble();
			System.out.print("Product quantity: ");
			Integer quantity = sc.nextInt();
			Product product = new Product(name, price);
			OrderItem items = new OrderItem(quantity, price, product);
			order.getList().add(items);
			
		}
		System.out.println("\nORDER SUMMARY");
		System.out.println(order.toString());
		sc.close();
		
	}

}
