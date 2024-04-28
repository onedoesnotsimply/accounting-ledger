import java.util.Scanner;

public class Ledger {
    // Create a scanner object for user input
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Ledger");
        homeScreen();
    }

    public static void homeScreen() {
        // Display the home screen
        System.out.println("1) Add Deposit");
        System.out.println("2) Make Payment");
        System.out.println("3) Ledger");
        System.out.println("4) Exit");

        int choice = scanner.nextInt(); // Get user input
        scanner.nextLine(); // Consume the newline

        if (choice == 1) {
            //addDeposit();
        } else if (choice == 2) {
            //makePayment();
        } else if (choice==3) {
            ledgerScreen();
        } else if (choice==4) {
            return;
        } else {
            System.out.println("Invalid choice");
            homeScreen();
        }
    }

    public static void ledgerScreen() {
        System.out.println("1) All Entries");
        System.out.println("2) Deposits");
        System.out.println("3) Payments");
        System.out.println("4) Reports");
        System.out.println("5) Home");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            //allEntries();
        } else if (choice == 2) {
            //viewDeposits();
        } else if (choice == 3) {
            //viewPayments();
        } else if (choice == 4) {
            viewReports();
        } else if (choice == 5) {
            homeScreen();
        } else {
            System.out.println("Invalid input");
            ledgerScreen();
        }
    }

    public static void viewReports() {
        System.out.println("1) Month To Date");
        System.out.println("2) Previous Month");
        System.out.println("3) Year To Date");
        System.out.println("4) Previous Year");
        System.out.println("5) Search by Vendor");
        System.out.println("6) Back");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice==1) {
            //monthToDate();
        } else if (choice==2) {
            //previousMonth();
        } else if (choice==3) {
            //yearToDate();
        } else if (choice==4) {
            //previousYear();
        } else if (choice==5) {
            //searchByVendor();
        } else if (choice==6) {
            ledgerScreen();
        } else {
            System.out.println("Invalid input");
            viewReports();
        }
    }

    public static void addDeposit() {

    }

}
