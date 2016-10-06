package com.siddhesh.ArrayList3;

import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static MobilePhone mobilePhone = new  MobilePhone("9911223344");
	
	public static void main(String[] args) {
		
		boolean quit = false;
		
		startPhone();
		printActions();
		
		while(!quit){
			System.out.println("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice)
			{
				case 0:	System.out.println("Shutting down...");
						quit = true;
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
			}
		}
		
	}

	private static void addNewContact()
	{
		System.out.println("Enter new contact name: ");
		String name = scanner.nextLine();
		
		System.out.println("Enter phone number: ");
		String phone = scanner.nextLine();
		
		Contact newContact = Contact.createContact(name, phone);
		
		if(mobilePhone.addNewContact(newContact))
		{
			System.out.println("New contact created:\nName - " + name + "\nPhone - " + phone + "\n");
		}
		else
		{
			System.out.println(name+", Already exists on file.");
		}
	}
	
	private static void updateContact()
	{
		System.out.println("Enter the existing contact name: ");
		String name = scanner.nextLine();
		
		Contact existingContactRecord = mobilePhone.queryContact(name);
		
		if(existingContactRecord == null)
		{
			System.out.println("Contact not found");
			return;
		}
		
		System.out.println("Enter new contact name: ");
		String newName = scanner.nextLine();
		
		System.out.println("Enter new contact number: ");
		String newNumber = scanner.nextLine();
		
		Contact newContact = Contact.createContact(newName, newNumber);
	
		if(mobilePhone.updateContact(existingContactRecord, newContact))
		{
			System.out.println("Successfully updated the record");
		}
		else
		{
			System.out.println("Error updating record");
		}
	}
	
	private static void removeContact()
	{
		System.out.println("Enter the existing contact name: ");
		String name = scanner.nextLine();
		
		Contact exisitngContactRecord = mobilePhone.queryContact(name);
		
		if(exisitngContactRecord == null)
		{
			System.out.println("Contact not found");
			return;
		}
		
		if(mobilePhone.removeContact(exisitngContactRecord))
		{
			System.out.println("Successfully deleted");
		}
		else
		{
			System.out.println("Error deleting contact");
		}
	}
	
	private static void queryContact()
	{
		System.out.println("Enter the existing contact name: ");
		String name = scanner.nextLine();
		
		Contact existingContactRecord = mobilePhone.queryContact(name);
		
		if(existingContactRecord == null)
		{
			System.out.println("Contact not found..");
			return;
		}
		
		System.out.println("Name: "+ existingContactRecord.getName() +  "Phone number: " + existingContactRecord.getPhoneNumber());
	}
	
	private static void startPhone() {
		System.out.println("The phone is starting...");
	}
	
	private static void printActions()
	{
		System.out.println("Available action:");
		System.out.println("0. Shutdown\n"+
						   "1. Print Contacts\n"+
						   "2. Add new contact\n"+
						   "3. Update an existing contact\n"+
						   "4. Delete a contact\n"+
						   "5. Search a contact\n"+
						   "6. Print action list\n");
	}
}
