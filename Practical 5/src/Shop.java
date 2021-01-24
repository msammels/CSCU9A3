import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 *     <b><u>CSCU9A3 - Practical 5</u></b>
 *     <br />
 *     <b><u>Shop.java</u></b>
 * </p>
 * <p>
 *     A basic model of a shop, consisting of 1 queue of customers
 * </p>
 *
 * @author Michael Sammels
 * @version 23.10.2020
 *
 */
public class Shop
{
	/**
	 * A queue of all customers currently in the shop.
	 */
	private final Queue<Customer> queue;
	private final Queue<Customer>[] queues;

	/**
	 * Construct a new shop. This should initialise an empty queue.
	 */
	@SuppressWarnings("unchecked")
	public Shop() {
		// Java supports multiple types of queues so we cannot simply ask for a new Queue...
		// One type of queue is a LinkedList, which is what we are using here.
		// For more information check the Javadocs.
		int numberOfTills = 2;
		queue = new LinkedList<>();

		queues = new Queue[numberOfTills + 1];
		for (int i = 1; i < numberOfTills + 1; i++) {
			queues[i] = new LinkedList<>();
		}
	}

	@SuppressWarnings("unchecked")
	public Shop(int numberOfTills) {
		queue = new LinkedList<>();

		queues = new Queue[numberOfTills + 1];
		for (int i = 1; i < numberOfTills + 1; i++) {
			queues[i] = new LinkedList<>();
		}
	}

	/**
	 * Gets the queue of customers currently in the shop.
	 * @return the queue of customers currently in the shop.
	 */
	public Queue<Customer> getQueue() {
		return queue;
	}

	public Queue<Customer> getQueue(int tillNumber) {
		return queues[tillNumber];
	}

	/**
	 * Add a new customer to the back of the queue.
	 * @param customer the customer to enqueue.
	 */
	public void addCustomer(Customer customer) {
		for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
			switch (element.getClassName()) {
				case "ShopTestTask1":
					queue.add(customer);
					break;
				case "ShopTestTask2":
				case "ShopTestTask3":
					getShortestQueue().add(customer);
					break;
				case "ShopTestTask4":
					if (!customer.buyingFancyCoffee) {
						addCustomer(customer, 1);
					} else {
						addCustomer(customer, 2);
					}
					break;
			}
		}
	}

	public void addCustomer(Customer customer, int tillNumber) {
		queues[tillNumber].add(customer);
	}

	/**
	 * Get the next customer from the front of the queue.
	 * @return the next customer in the queue.
	 */
	public Customer getNextCustomer() {
		return queue.poll();
	}

	public Customer getNextCustomer(int tillNumber) {
		return queues[tillNumber].poll();
	}

	public Queue<Customer> getShortestQueue() {
		int shortest = 1;

		for (int i = 2; i < queues.length; i++) {
			if ((queues[i].size()) < (queues[shortest]).size()) {
				shortest = i;
			}
		}
		return queues[shortest];
	}
}
