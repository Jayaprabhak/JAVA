package VirtualKey;

import java.util.*;
import java.io.File;

public class VirtualKeyRepo {
	public static File folder = new File("D:\\Folder\\");

	public static void main(String[] args) {

		// welcome Page
		System.out.println("\n**************************************\n");
		System.out.println("\tVirtual Key Repository \n");
		System.out.println("**************************************");
		menu();
	}

	public static void menu() {

		System.out.println("Available Operations Are \n");
		String[] arr = { "1. To Retrieving The File Names In An Ascending Order",
				"2. To Perform Business-Level Operations", "3. Close The Application" };
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			// display all the menu mentioned in the String array
		}
		System.out.println("\nSelect One Of The Options Listed above\n");
		Scanner sc = new Scanner(System.in);
		
		int option = sc.nextInt();
		switch (option) {
		case 1:
			File a[] = folder.listFiles();
			Arrays.sort(a);

			for (int i = 0; i < a.length; i++)
				System.out.println(a[i]);
			menu();
			break;
		case 2:
			boolean t = true;
			while (t) {
				System.out.println("Business Level Operations\n");
				System.out.println(" 1 : To Add a File In The Existing Directory");
				System.out.println(" 2 : To Delete a File From The Existing Directory. ");
				System.out.println(" 3 : To Search a User Specified File From The Directory");
				System.out.println(" 4 : Back To The Main Menu");

				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter The File Name To Create");
					String s = sc.next();
					File file = new File(folder, s);
					try {
						boolean value = file.createNewFile();
						if (value) {
							System.out.println("The New File Is Created.");
						} else {
							System.out.println("The File Already Exists.");
					    }
					} catch (Exception e) {
						e.getStackTrace();
		            }	
					break;
				case 2:
					System.out.println("Enter The File Name To Delete");
					String name = sc.next();
					File file1 = new File(folder, name);

					try {
						boolean value = file1.delete();
						if (value) {
							System.out.println("The File Is Deleted.");
						} else {
							System.out.println("File Not Found");
						}
					} catch (Exception e) {
						e.getStackTrace();
					}
					break;
				case 3:
					System.out.println("Enter a Keyword To Search");
					String search = sc.next();
					boolean flag1 = false;
					File arr1[] = folder.listFiles();
					System.out.println("File :\n");
					for (int i = 0; i < arr1.length; i++) {
						if (arr1[i].getName().startsWith(search)) {
							flag1 = true;
							System.out.println(arr1[i]);
						}
					}
					if (flag1 == false) {
						System.out.println("No File Found");
					}

					break;
				case 4:
					t = false;
					menu();
					break;
				default:
					System.out.println("You Have Made An Invalid Choice!");
					System.out.println("Please Enter Correct Choice\n");

				}
			}
			break;
		case 3:
			System.out.println("Closing Your Application...\n");
			System.out.println("-----Thank You------");
			break;
		default:
			System.out.println("You Have Made An Invalid Choice!");
			System.out.println("Please Enter Correct Choice\n");
			menu();
			break;

		}

	}

}