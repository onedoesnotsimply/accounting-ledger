import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ledger {
    // Create a scanner object for user input
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Ledger");
        homeScreen();
        //bufferedWriter.close();
        //scanner.close();
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
            writeToCSV(addDeposit());
            homeScreen();
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

    public static String addDeposit() {
        System.out.println("Please enter the deposit information");
        System.out.print("Describe the deposit : ");
        String description = scanner.nextLine();
        System.out.print("Who is the vendor : ");
        String vendor = scanner.nextLine();
        System.out.print("Deposit amount : ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        return (description+"|"+vendor+"|"+amount);
    }

    public static void writeToCSV(String action) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("ledger.csv", true));

            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();

            bufferedWriter.write(date+"|"+time.format(DateTimeFormatter.ofPattern("HH:mm:ss"))+"|"+action+"\n");
            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
