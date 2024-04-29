import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Ledger {
    // Create a scanner object for user input
    static Scanner scanner = new Scanner(System.in);
    // Create buffered writer object to write to the csv file
    static BufferedWriter bufferedWriter;
    static BufferedReader bufferedReader;

    static {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("ledger.csv", true));
            bufferedReader = new BufferedReader(new FileReader("ledger.csv"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // Create an arraylist for the

    public static void main(String[] args) throws IOException {
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
            writeToCSV(addDeposit());
            homeScreen();
        } else if (choice == 2) {
            writeToCSV(addPayment());
            homeScreen();
        } else if (choice==3) {
            ledgerScreen();
        } else if (choice==4) {
            try {
                bufferedWriter.close();
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            scanner.close();
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
            allEntries();
            ledgerScreen();
        } else if (choice == 2) {
            viewDeposits();
            ledgerScreen();
        } else if (choice == 3) {
            viewPayments();
            ledgerScreen();
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
            monthToDate();
            viewReports();
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

    public static String addPayment() {
        // Prompt for payment information
        System.out.println("Please enter the payment information");
        System.out.print("Describe the purchased item : ");
        String item = scanner.nextLine();
        System.out.print("Name of vendor : ");
        String vendor = scanner.nextLine();
        System.out.print("Enter the cost of the item as a negative number : ");
        double cost = scanner.nextDouble();
        scanner.nextLine(); // Consume to newline
        // Return string
        return (item+"|"+vendor+"|"+cost);
    }

    public static String addDeposit() {
        // Prompt for deposit information
        System.out.println("Please enter the deposit information");
        System.out.print("Describe the deposit : ");
        String description = scanner.nextLine();
        System.out.print("Who is the vendor : ");
        String vendor = scanner.nextLine();
        System.out.print("Deposit amount : ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        // Return the string
        return (description+"|"+vendor+"|"+amount);
    }

    public static void writeToCSV(String action) {
            // Get the local date and time
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();

            String entry = (date+"|"+time.format(DateTimeFormatter.ofPattern("HH:mm:ss"))+"|"+action+"\n");

        try {
            // Write the date, time and action to the ledger.csv file
            bufferedWriter.write(entry);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void allEntries() {
        // Prints all entries to the terminal
        String input;
        try {
            while ((input = bufferedReader.readLine()) != null) {
                System.out.println(input);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void viewDeposits() {
        // Shows all deposits recorded in the ledger
        String input;
        try {
            while ((input = bufferedReader.readLine()) != null) {
                String[] tokens = input.split("\\|");
                if (Double.parseDouble(tokens[4]) > 0){
                    System.out.println(input);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void viewPayments() {
        // Shows all payments recorded in the ledger
        String input;
        try {
            while ((input = bufferedReader.readLine()) != null) {
                String[] tokens = input.split("\\|");
                if (Double.parseDouble(tokens[4]) < 0){
                    System.out.println(input);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void monthToDate() {
        String input;
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();

        try {
            while ((input = bufferedReader.readLine()) != null) {
                String[] tokens = input.split("\\|");
                String[] date = tokens[0].split("-");
                if (Double.parseDouble(date[1]) == currentMonth && Double.parseDouble(date[0]) == currentYear) {
                    System.out.println(input);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
