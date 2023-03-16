import java.util.Scanner;

public class Assignment5A {
    public static String menu = """

            [Community General Hospital Directory]
            1) List all employees
            2) Search employee records by ID
            3) Search employee records by Last Name
            4) Quit
            Choice:\s""";

    public static int[] empID = new int[]{0, 1, 2, 3, 4};
    public static String[] empFirstName = new String[]{"Mark", "Amanda", "Norman", "Steve", "Jesse"};
    public static String[] empLastName = new String[]{"Sloan", "Bentley", "Briggs", "Sloan", "Travis"};
    public static int[] empAge = new int[]{67, 33, 47, 35, 24};
    public static String[] empJobTitle = new String[]{"Chief of Internal Medicine", "Pathologist", "Administrator", "Hospital Security", "Surgeon Intern"};
    public static boolean[] empHasMD = new boolean[]{true, true, false, false, true};
    public static int choice, choiceID;
    public static String nameChoice;
    public static boolean IDisInvalid = true;
    public static boolean receivedNoResults = true;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            System.out.print(menu);
            choice = sc.nextInt();
            sc.nextLine(); //I don't really having to use this solution, but without it, we'll have the scanner in case 3 reading the leftover escape sequence from the nextInt() call.
            switch (choice) {
                case 1 -> {
                    PrintAllUserInfo();
                }
                case 2 -> {
                    do {
                        System.out.print("ID: ");
                        choiceID = sc.nextInt();
                        PrintUserInfoOfID(choiceID);
                    } while (IDisInvalid);
                }
                case 3 -> {
                    System.out.print("Last Name: ");
                    nameChoice = sc.nextLine();
                    PrintRecordsOfLastName(nameChoice);
                }
                case 4 -> System.out.println("[Closing Directory]");
                default -> System.out.println("No option " + choice);
            }
        } while (choice != 4);
        sc.close();
    }

    private static void PrintRecordsOfLastName(String nameChoice) {
        for (int i = 0; i < empLastName.length; i++) {
            if (empLastName[i].equalsIgnoreCase(nameChoice)) {
                System.out.println(UserDetails(i));
                receivedNoResults = false;
            }
        }
        if (receivedNoResults) {
            System.out.println("No Records Found!");
        }
    }

    private static void PrintUserInfoOfID(int choiceID) {
        for (int i = 0; i < empID.length; i++) {
            if (empID[i] == choiceID) {
                System.out.println(UserDetails(i));
                IDisInvalid = false;
                break;
            }
            }
        if (IDisInvalid) {
            System.out.println("Invalid ID");
        }
    }

    private static void PrintAllUserInfo() {
        for (int i = 0; i < 5; i++) {
            System.out.println(UserDetails(i));
        }
    }

    private static String UserDetails(int i) {
        return "#" + empID[i] + ": " + empFirstName[i] + " " + empLastName[i] + ", Age " + empAge[i] + ", " + empJobTitle[i] + ", Medical License: " + String.valueOf(empHasMD[i]).toUpperCase();
    }
}