package ToDoList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class ToDoList {

	public static HashMap<Integer, String> userList = new HashMap<Integer, String>();

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
			viewToDoList();
			break;
		}
		case 3: {
			deleteToDoList();
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

	private static void deleteToDoList() {

	}

	static void viewToDoList() {
		System.out.println("your created ToDoList is here:");
		display();
		System.out.println();
		start();
	}

	private static void display() {
		for(int key: userList.keySet()) {
			System.out.println(key+ ". "+ userList.get(key));
			
		}
	}

	static void createToDoList(){
        int i = 1;
        System.out.println("Please enter your items: ");
        Scanner sc_user = new Scanner(System.in);
        while(sc_user.hasNext()){
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