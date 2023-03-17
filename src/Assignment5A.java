import java.util.Scanner;

public class Assignment5A {
    public static String menu = """
            1) List all employees
            2) Search employee records by ID
            3) Search employee records by Last Name
            4) Quit
            Choice:\s""";

    public static final int[] ID = new int[]{0, 1, 2, 3, 4};
    public static final String[] FIRSTNAME = new String[]{"Mark", "Amanda", "Norman", "Steve", "Jesse"};
    public static final String[] LASTNAME = new String[]{"Sloan", "Bentley", "Briggs", "Sloan", "Travis"};
    public static final int[] AGES = new int[]{67, 33, 47, 35, 24};
    public static final String[] JOBTITLE = new String[]{"Chief of Internal Medicine", "Pathologist", "Administrator", "Hospital Security", "Surgeon Intern"};
    public static final boolean[] HASDOCTORATES = new boolean[]{true, true, false, false, true};
    public static int choice, choiceID;
    public static String nameChoice;
    public static boolean  receivedNoResults = true, IDisInvalid = true;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("[Community General Hospital Directory]");
        do {
            System.out.print(menu);
            choice = sc.nextInt();
            sc.nextLine(); //I don't really having to use this solution, but without it, we'll have the scanner in case 3 reading the leftover escape sequence from the nextInt() call.
            switch (choice) {
                case 1 -> {
                    System.out.println();
                    PrintAllUserInfo();
                    System.out.println();
                }
                case 2 -> {
                    do {
                        System.out.print("ID: ");
                        choiceID = sc.nextInt();
                        PrintUserInfoOfID(choiceID);
                        System.out.println();
                    } while (IDisInvalid);
                }
                case 3 -> {
                    System.out.print("Last Name: ");
                    nameChoice = sc.nextLine();
                    PrintRecordsOfLastName(nameChoice);
                    System.out.println();
                }
                case 4 -> System.out.println("[Closing Directory...]");
                default -> System.out.println("No option " + choice);
            }
        } while (choice != 4);
        sc.close();
    }

    private static void PrintRecordsOfLastName(String nameChoice) {
        for (int i = 0; i < LASTNAME.length; i++) {
            if (LASTNAME[i].equalsIgnoreCase(nameChoice)) {
                System.out.println(UserDetails(i));
                receivedNoResults = false;
            }
        }
        if (receivedNoResults) {
            System.out.println("No Records Found!");
        }
    }

    private static void PrintUserInfoOfID(int choiceID) {
        for (int i = 0; i < ID.length; i++) {
            if (ID[i] == choiceID) {
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
        return "#" + ID[i] + ": " + FIRSTNAME[i] + " " + LASTNAME[i] + ", Age " + AGES[i] + ", " + JOBTITLE[i] + ", Medical License: " + String.valueOf(HASDOCTORATES[i]).toUpperCase();
    }
}