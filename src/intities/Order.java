package intities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.OrderStatus;

public class Order {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date moment;
	private OrderStatus status;

	private Client client;
	List<OrderItem> list = new ArrayList<>();

	public void addItem(OrderItem item) {
		list.add(item);

	}

	public void removeItem(OrderItem item) {
		list.remove(item);
	}

	public double total() {
		double total = 0.0;
		for(OrderItem items : list ) {
			total += items.subTotal();
		}
		return total;
	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment(Date moment) {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getList() {
		return list;
	}

	@Override
	public String toString() {
		StringBuilder subToString = new StringBuilder();
		subToString.append("Order moment: ");
		subToString.append(sdf.format(moment));
		subToString.append("\nOrder status: " + status + "\n");
		subToString.append(client);
		subToString.append("\nOrder items:");
		for (OrderItem orderItem : list) {
			subToString.append("\n"+orderItem);
		}
		subToString.append("\nTotal price: $" + total());
		return subToString.toString();
	}

}