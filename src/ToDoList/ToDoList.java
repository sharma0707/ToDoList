package ToDoList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class ToDoList {

	public static HashMap<Integer, String> userList = new HashMap<Integer, String>();
	public static HashMap<Integer, String> userList_deleted = new HashMap<Integer, String>();

	static void start() {
		System.out.println("####################################################################");
		System.out.println("To Do List Menu: ");
		System.out.println("1. Create To Do List");
		System.out.println("2. View To Do List");
		System.out.println("3. Mark item completed in To Do List");
		System.out.println("4. Exit");
		System.out.println("####################################################################");
		System.out.println();
		System.out.println("Please select the operation you want to perform");

		Scanner sc = new Scanner(System.in);
		int options = sc.nextInt();
		switch (options) {
		case 1: {
			createToDoList();
			break;
		}
		case 2: {
			viewToDoList(userList);
			break;
		}
		case 3: {
			deleteToDoList(userList, userList_deleted);
			break;
		}
		case 4: {
			System.out.println("Thanks for choosing our To Do List Task:");
			break;
		}
		default:
			System.out.println("Invalid User Input:");
			start();
		}
	}

	static void deleteToDoList(HashMap<Integer, String>userList, HashMap<Integer, String> userList_deleted) {
		Scanner sc_user_deleted = new Scanner(System.in);
		  System.out.println("Which item you want to marked as deleted ?");
		  display();
		  System.out.println("Please make sure before marking any item completed, this operation cannot be undone.");
	      System.out.println("Press(Y/N) Y for continue and N for main menu");
	      
	      if(!sc_user_deleted.nextLine().equalsIgnoreCase("y")) {
	    	  start();
	      }
	      System.out.println("please enter the number:");
		while (sc_user_deleted.hasNext()) {
			int entered_value = sc_user_deleted.nextInt();
			if(userList.containsKey(entered_value)) {
				userList.put(entered_value, userList.get(entered_value));
				userList.remove(entered_value);
			}
			else {
				 System.out.println("Wrong user input. There is no such item in the list.");
	                break;
			}
			System.out.println("Press Y now.");
			
		
		sc_user_deleted.hasNext();
		if(!sc_user_deleted.nextLine().equalsIgnoreCase("y")) {
			break;
		}
	}
		if(userList.size() !=0) {
			System.out.println("Pending items in To Do List:");
			display();
			System.out.println("Mark deleted items in To Do List: ");
			for(int key_deleted: userList_deleted.keySet()) {
				System.out.println(key_deleted+ ". "+ userList_deleted.containsKey(key_deleted));
				
			}
			System.out.println();
		}
		else {
			 System.out.println("Hurrah! You have completed all the items in To_Do_List.");
	            System.out.println();
		}
		System.out.println();
        start();
	}
	
	static void viewToDoList(HashMap<Integer, String> userlist) {
		System.out.println("your created To_Do_List is here:");
		display();
		System.out.println();
		start();
	}

	 static void display() {
		for (int key : userList.keySet()) {
			System.out.println(key + ". " + userList.get(key));

		}
	}

	static void createToDoList() {
		int i = 1;
		System.out.println("Please enter your items: ");
		Scanner sc_user = new Scanner(System.in);
		while (sc_user.hasNext()) {
			String str = sc_user.nextLine();
			userList.put(i, str);
			System.out.println("Do you want to add more items? (Y/N)");
			sc_user.hasNext();
			if (!sc_user.nextLine().equalsIgnoreCase("y")) {
				break;
			}
			i++;
		}
		System.out.println("Your To do list is created.");
		System.out.println();
		start();
	}

	public static void main(String[] args) {
		start();
	}
}