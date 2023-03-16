import java.util.Scanner;

public class Assignment5B {
    public static Scanner sc = new Scanner(System.in);
    public static int[][] userArrayPBM;
    public static String direction;
    public static int width, height, color, length, menuChoice, rowIndex, columnIndex, newColor;

    public static void main(String[] args) {
        System.out.println("[KSU Image Manipulation Program]");
        GetInitialSizeAndColor();
        GenerateIntialUserArray();
        do {
            PrintMainMenu();
            GetUserMenuChoice();
            switch (menuChoice) {
                case 1 -> { //If user chose to fill a pixel
                    GetUserColumn();
                    GetRowFromUser();
                    GetUserNewColor();
                    FillNewIndiciesPositionWithNewColor();
                }
                case 2 -> { //If user chose to fill a line
                    GetUserColumn();
                    GetRowFromUser();
                    GetUserNewColor();
                    GetUserLength();
                    GetUserDirection();
                    DrawLineUsingLastNewUserInput();

                }
                case 3 -> { //If user chose to print the image
                    DisplayCurrentUserArray();
                }
                case 4 -> { //If user chose to quit the program
                    System.out.println("[Exiting KSU Image Manipulation Program]");
                }
                default -> { //If user entered invalid response
                    System.out.println("Please enter an integer 1 through 4.");
                }
            }
        } while (menuChoice != 4);
    }

    private static void DisplayCurrentUserArray() {
        System.out.println("PGM Image Contents\n" + "P2\n" + width + " " + height + "\n255\n");
        for (int i = 0; i < userArrayPBM.length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(userArrayPBM[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void DrawLineUsingLastNewUserInput() {
        for (int i = 0; i < userArrayPBM.length; i++) {
            for (int j = 0; j < width; j++) {
                if (direction.equalsIgnoreCase("up")) {
                    if (j == rowIndex && i >= columnIndex) {
                        userArrayPBM[i][j] = newColor;
                    }
                } else if (direction.equalsIgnoreCase("down")) {
                    if (j == rowIndex && i < columnIndex) {
                        userArrayPBM[i][j] = newColor;
                    }
                } else if (direction.equalsIgnoreCase("left")) {
                    if (j <= rowIndex && i == columnIndex) {
                        userArrayPBM[i][j] = newColor;
                    }
                } else if (direction.equalsIgnoreCase("right")) {
                    if (j > rowIndex && i == columnIndex) {
                        userArrayPBM[i][j] = newColor;
                    }
                }
            }
        }
    }

    private static void GetUserLength() {
        System.out.print("Length: ");
        length = sc.nextInt();

    }

    private static void GetUserDirection() {
        sc.nextLine();
        boolean stayInLoop = true;
        do {
            System.out.print("Direction: ");
            direction = sc.nextLine();
            if (direction.equalsIgnoreCase("up") || direction.equalsIgnoreCase("down") || direction.equalsIgnoreCase("left") || direction.equalsIgnoreCase("right")) {
                stayInLoop = false;
            } else {
                System.out.println("Please enter up, down, left, or right.");
            }
        } while (stayInLoop);
    }

    private static void FillNewIndiciesPositionWithNewColor() {
        userArrayPBM[rowIndex][columnIndex] = newColor;
    }

    private static void GenerateIntialUserArray() {
        userArrayPBM = new int[height][width];
        for (int i = 0; i < userArrayPBM.length; i++) {
            for (int j = 0; j < width; j++) {
                userArrayPBM[i][j] = color;
            }
        }
    }

    private static void GetUserColumn() {
        boolean stayInLoop = true;
        do {
            System.out.print("Column: ");
            columnIndex = sc.nextInt();
            if (rowIndex >= userArrayPBM.length) {
                stayInLoop = false;
            } else {
                System.out.println("Value is outside the bounds of the array.");
            }
        } while (stayInLoop);
    }


    private static void GetUserNewColor() {
        boolean stayInLoop = true;
        do {
            System.out.print("New Color: ");
            newColor = sc.nextInt();
            if (newColor > 0 && newColor < 256) {
                stayInLoop = false;
            } else {
                System.out.println("Color must be from 0 to 255.");
            }
        } while (stayInLoop);
    }

    private static void GetRowFromUser() {
        boolean stayInLoop = true;
        do {
            System.out.print("Row: ");
            rowIndex = sc.nextInt();
            if (rowIndex >= userArrayPBM[0].length) {
                stayInLoop = false;
            } else {
                System.out.println("Value is outside the bounds of the array.");
            }
        } while (stayInLoop);
    }

    private static void GetUserMenuChoice() {
        System.out.print("Choice? ");
        menuChoice = sc.nextInt();
        System.out.println();
    }

    private static void PrintMainMenu() {
        System.out.println("What will you do?\n" +
                "1) Fill in a pixel\n" +
                "2) Fill in a line\n" +
                "3) Print the image\n" +
                "4) Quit");
    }

    private static void GetInitialSizeAndColor() {
        boolean stayInLoop = true;
        System.out.print("Enter an image width: ");
        width = sc.nextInt();
        System.out.print("Enter an image height: ");
        height = sc.nextInt();
        do {
            System.out.print("Enter the fill color: ");
            color = sc.nextInt();
            if (color > 0 && color < 256) {
                stayInLoop = false;
            } else {
                System.out.println("Color must be from 0 to 255.");
            }
        } while (stayInLoop);
        System.out.println();
    }

}
