package com.blz;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {
	private static final Scanner SC = new Scanner(System.in);

	public static void main(String[] args) {
		addressBook();
	}

	public static void addressBook() {
		ArrayList<Contact> contactList = new ArrayList<>();
		int choice = 0;
		do {
			System.out.println("1.add\n2.display\n3.exit");
			System.out.println("Enter choice");
			choice = SC.nextInt();
			switch (choice) {
			case 1:
				Contact add = addInputs();
				contactList.add(add);
				break;

			case 2:
				for (Contact items : contactList) {
					System.out.println(items.toString());
				}
				break;

			case 3:
				System.out.println("Thank You..");
				break;
			default:
				System.out.println("Please Enter from choice ");

				break;
			}
		} while (choice != 3);
	}

	public static Contact addInputs() {
		Contact add;
		add = new Contact();
		System.out.println("Enter a first name: ");
		add.setFirstName(SC.next());
		System.out.println("Enter a last name: ");
		add.setLastName(SC.next());
		System.out.println("Enter an address: ");
		add.setAddress(SC.next());
		System.out.println("Enter a city: ");
		add.setCity(SC.next());
		System.out.println("Enter a state: ");
		add.setState(SC.next());
		System.out.println("Enter a zip: ");
		add.setZip(SC.nextInt());
		System.out.println("Enter a phone number: ");
		add.setPhoneNumber(SC.nextLong());
		System.out.println("Enter an email ID: ");
		add.setEmailID(SC.next());
		return add;
	}
}
