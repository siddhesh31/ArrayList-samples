package com.siddhesh.ArrayList2;

import java.util.Scanner;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	
	private static MobilePhone mobilePhone = new MobilePhone("9911223344");
	
	public static void main(String[] args) {
		boolean quit = false;
		startPhone();
		printActions();
		while(!quit)
		{
			System.out.println("Enter action: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			case 0: System.out.println("System shutting down");
					break;
				
			case 1: mobilePhone.printContacts();
					break;
					
			case 2: addNewContact();
					break;
					
			case 3: updateContact();
					break;
					
			case 4: removeContact();
					break;
					
			case 5: queryContact();
					break;
					
			case 6: printActions();
					break;

			default:
				break;
			}
		}
	}

	
	private static void queryContact() {
		System.out.println("Enter the exisiting contact: ");
		String name = scanner.nextLine();
		
		Contact existingContact = mobilePhone.queryContact(name);
		
		if(existingContact == null)
		{
			System.out.println("Contact not found");
			return;
		}
		
		mobilePhone.removeContact(existingContact);
		
		System.out.println("Name: "+ existingContact.getName() + " phone number is " + existingContact.getPhoneNumber());
		
	}


	private static void removeContact() {
		System.out.println("Enter the contact to be deleted: ");
		String name = scanner.nextLine();
		
		Contact existingContact = mobilePhone.queryContact(name);
		
		if(existingContact == null)
		{
			System.out.println("Contact not found");
			return;
		}
		
		mobilePhone.removeContact(existingContact);
		
		if(mobilePhone.removeContact(existingContact))
		{
			System.out.println("Successfully updated");
		}
		else
		{
			System.out.println("Error deleting contact");
		}
		
	}


	private static void updateContact() {
		System.out.println("Enter the contact to be modified: ");
		String name = scanner.nextLine();
		
		Contact existingContact = mobilePhone.queryContact(name);
		
		if(existingContact == null)
		{
			System.out.println("Contact not found");
			return;
		}
		
		System.out.println("Enter new contact name: ");
		String newName = scanner.nextLine();
		System.out.println("Enter new number: ");
		String newNumber = scanner.nextLine();
		
		Contact newContact = Contact.createContact(newName, newNumber);
		
		if(mobilePhone.updateContact(existingContact, newContact))
		{
			System.out.println("Successfully updated record");
		}
		else
		{
			System.out.println("Error updating contact");
		}
	}


	private static void addNewContact() {
		System.out.println("Enter new contact name: ");
		String name = scanner.nextLine();
		
		System.out.println("Enter phone number: ");
		String phone = scanner.nextLine();
		
		Contact newContact = Contact.createContact(name, phone);
		
		if(mobilePhone.addNewContact(newContact))
		{
			System.out.println("New contact added: Name = "+name+" Phone = "+phone);
		}
		else
		{
			System.out.println("Cannot add "+name+" already on file");
		}
		
	}


	private static void startPhone() {
		System.out.println("Starting phone...");
		
	}

	private static void printActions() {
		System.out.println("Available actions: \nPress ");
		System.out.println("0 - Shutdown\n"+
							"1 - To print contacts\n"+
							"2 - To add a new contact\n"+
							"3 - To update an contact\n"+
							"4 - To delete a contact\n"+
							"5 - To search a contact\n"+
							"6 - To print list of actions\n");
		System.out.println("Choose your action: ");			
		
	}
	
	
}
