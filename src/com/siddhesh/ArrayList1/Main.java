package com.siddhesh.ArrayList1;

import java.util.Scanner;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	private static GroceryList groceryList = new GroceryList();
	
	public static void main(String[] args) {
		
		printInstructions();
		int choice = 0;
		boolean quit = false;
		
		while(!quit)
		{
			//printInstructions();
			System.out.println("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch(choice)
			{
				case 0: printInstructions();
				break;
				
				case 1: groceryList.printGroceryList();
				break;
				
				case 2: addItem();
				break;
				
				case 3: modifyItem();
				break;
				
				case 4: removeItem();
				break;
				
				case 5: searchForItem();
				break;
				
				case 6: quit = true;
				break;
			}
		}
		
	}

	private static void searchForItem() {
		System.out.println("Enter the item to search for: ");
		String searchItem = scanner.nextLine();
		if(groceryList.findItem(searchItem) != null)
		{
			System.out.println("Item " + searchItem + " found!");
		}
		else
		{
			System.out.println(searchItem + " item not found");
		}
	}

	private static void removeItem() {
		System.out.println("Enter the position of the item to be removed: ");
		int itemNo = scanner.nextInt();
		scanner.nextLine();
		groceryList.removeGroceryItem(itemNo - 1);
		
	}

	private static void modifyItem() {
		System.out.println("Enter item number: ");
		int itemNo = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Enter replacement item: ");
		String newItem = scanner.nextLine();
		groceryList.modifyGroceryItem(itemNo - 1, newItem);
	}

	private static void addItem() {
		System.out.print("Please enter the grocery item: ");
		groceryList.addGroceryItem(scanner.nextLine());
	}

	private static void printInstructions() {
		System.out.println("\nPress ");
		System.out.println("\t 0 - To print choice options.");
		System.out.println("\t 1- To print the list of grocery Items");
		System.out.println("\t 2 - To add an item to the list");
		System.out.println("\t 3- To modify an item in the list");
		System.out.println("\t 4 - To remove an item from the list");
		System.out.println("\t 5 - To search an item in the list");
		System.out.println("\t 6 - To quit the application");
	}
}
