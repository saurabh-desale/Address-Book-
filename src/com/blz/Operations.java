package com.blz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Operations implements IOperations {
	private static final Scanner SC = new Scanner(System.in);
	public static Map<String, ArrayList<Contact>> map = new HashMap<>();

	@Override
	public void addInput() {
		int choose = 0;

		do {
			Contact add;
			System.out.println("1.addAddressBook \n 2.display\n3.exit\n "
					+ "4.GetContactDetails by state name \n 6.GetContactDetails by city name");

			choose = SC.nextInt();
			switch (choose) {
			case 1:
				ArrayList<Contact> contactList = new ArrayList<>();
				System.out.println("Give unique address book name");
				String addressBookName = SC.next();

				if (map.containsKey(addressBookName)) {
					System.out.println("Please enter unique address book name");
				} else {
					int choice = 0;
					do {
						System.out.println(
								"1.add\n2.display\n3.exit\n 4.update\n5.delete contact\n6.search person by city");
						System.out.println("Enter choice");
						choice = SC.nextInt();
						switch (choice) {
						case 1:
							add = addContact(contactList);
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

						case 4:
							editContact(contactList);
							break;

						case 5:
							deleteContact(contactList);
							break;

						case 6:
							sameCityPerson(contactList);
							break;

						default:
							System.out.println("Please Enter from choice ");
							break;

						}
					} while (choice != 3);
					map.put(addressBookName, contactList);
					break;

				}

			case 2:
				for (Map.Entry contact : map.entrySet()) {
					System.out.println(contact.getKey() + ": " + contact.getValue());
				}
				break;

			case 3:
				System.out.println("Thank you!!!");
				break;

			case 4:
				System.out.println("Enter name of state to search  person details");
				String temp = SC.next();
				map.entrySet().stream().flatMap(i -> i.getValue().stream()).filter(i -> i.getState().equals(temp))
						.forEach(System.out::println);
				break;

			case 6:
				System.out.println("Enter name of city to search a person details");
				String temp1 = SC.next();
				map.entrySet().stream().flatMap(i -> i.getValue().stream()).filter(i -> i.getCity().equals(temp1))
						.forEach(System.out::println);
				break;

			default:
				System.out.println("Choose from options");
				break;
			}

		} while (choose != 3);
	}

	public void sameCityPerson(ArrayList<Contact> contactList) {
		System.out.println("Enter name of city to search a person");
		String temp = SC.next();
		contactList.stream().filter(i -> i.getCity().equals(temp)).forEach(i -> System.out.println(i.getFirstName()));
	}

	public void deleteContact(ArrayList<Contact> contactList) {
		System.out.println("Enter name which you want to delete: ");
		String nameDelete = SC.next();
		for (int i = 0; i < contactList.size(); i++) {
			System.out.println(contactList.get(i));
			Contact editContact = contactList.get(i);
			if (nameDelete.equals(editContact.getFirstName())) {
				contactList.remove(i);
			}
		}
	}

	public void editContact(ArrayList<Contact> contactList) {
		System.out.println("Enter name which you want to replace: ");
		String nameReplace = SC.next();
		for (int i = 0; i < contactList.size(); i++) {
			System.out.println(contactList.get(i));
			Contact editContact = contactList.get(i);
			if (nameReplace.equals(editContact.getFirstName())) {
				System.out.println("Enter a first name: ");
				editContact.setFirstName(SC.next());
				System.out.println("Enter a last name: ");
				editContact.setLastName(SC.next());
				System.out.println("Enter an address: ");
				editContact.setAddress(SC.next());
				System.out.println("Enter a city: ");
				editContact.setCity(SC.next());
				System.out.println("Enter a state: ");
				editContact.setState(SC.next());
				System.out.println("Enter a zip: ");
				editContact.setZip(SC.nextInt());
				System.out.println("Enter a phone number: ");
				editContact.setPhoneNumber(SC.nextLong());
				System.out.println("Enter an email ID: ");
				editContact.setEmailID(SC.next());
				contactList.set(i, editContact);
			}
		}
	}

	public Contact addContact(ArrayList<Contact> contactList) {
		Contact add;
		add = new Contact();
		isFirstNameExist(add, contactList);
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

	public void isFirstNameExist(Contact add, ArrayList<Contact> contactList) {
		boolean flag = true;
		while (flag) {

			System.out.println("Enter a first name: ");
			String newName = SC.next();
			if (contactList.stream().anyMatch((i) -> newName.equals(i.firstName))) {
				System.out.println("Please do not repeat duplicate name");
				flag = true;
			} else {
				add.setFirstName(newName);
				flag = false;
			}

		}
	}
}
