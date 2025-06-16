import java.util.Scanner;

public class SimpleLibrary {
    static String[] books = new String[100];
    static boolean[] isBorrowed = new boolean[100];
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Simple Library ---");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    books[count] = sc.nextLine();
                    isBorrowed[count] = false;
                    count++;
                    System.out.println("Book added.");
                    break;

                case 2:
                    System.out.print("Enter book number to borrow: ");
                    int b = sc.nextInt();
                    if (b >= 0 && b < count && !isBorrowed[b]) {
                        isBorrowed[b] = true;
                        System.out.println("You borrowed: " + books[b]);
                    } else {
                        System.out.println("Book not available.");
                    }
                    break;

                case 3:
                    System.out.print("Enter book number to return: ");
                    int r = sc.nextInt();
                    if (r >= 0 && r < count && isBorrowed[r]) {
                        isBorrowed[r] = false;
                        System.out.println("Book returned: " + books[r]);
                    } else {
                        System.out.println("Invalid return.");
                    }
                    break;

                case 4:
                    System.out.println("\nBooks in Library:");
                    for (int i = 0; i < count; i++) {
                        System.out.println(i + ". " + books[i] + " - " + (isBorrowed[i] ? "Borrowed" : "Available"));
                    }
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}