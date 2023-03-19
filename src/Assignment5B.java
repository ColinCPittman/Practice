import java.util.Scanner;
//GitHub Version
public class Assignment5B {
    public static Scanner sc = new Scanner(System.in);
    public static int[][] userArrayPBM;
    public static String direction;
    public static int width, height, color, length, menuChoice, rowIndex, columnIndex, newColor;

    public static void main(String[] args) {
        System.out.println("[KSU Image Manipulation Program]");
        GetInitialSizeAndColor();
        GenerateInitialUserArray();
        do {
            PrintMainMenu();
            GetUserMenuChoice();
            switch (menuChoice) {
                case 1 -> { //If user chose to fill a pixel
                    GetRowFromUser();
                    GetColumnFromUser();
                    GetNewColorFromUser();
                    FillNewIndexPositionWithNewColor();
                }
                case 2 -> { //If user chose to fill a line
                    GetRowFromUser();
                    GetColumnFromUser();
                    GetNewColorFromUser();
                    GetLengthFromUser();
                    GetDirectionFromUser();
                    DrawLineUsingStoredInput();
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
        sc.close();
    }

    private static void DisplayCurrentUserArray() {
        System.out.println("PGM Image Contents\n" + "P2\n" + width + " " + height + "\n255");
        for (int i = 0; i < userArrayPBM.length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(userArrayPBM[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void DrawLineUsingStoredInput() {
        for (int i = 0; i < userArrayPBM.length; i++) {
            for (int j = 0; j < width; j++) {
                if (direction.equalsIgnoreCase("left")) {
                    if (i == rowIndex && (j <= columnIndex && j > (columnIndex - length))) {
                            userArrayPBM[i][j] = newColor;
                    }
                } else if (direction.equalsIgnoreCase("right")) {
                    if (i == rowIndex && (j >= columnIndex && j < (columnIndex + length))) {
                        userArrayPBM[i][j] = newColor;
                    }
                } else if (direction.equalsIgnoreCase("up")) {
                    if ((i <= rowIndex && i > (rowIndex - length)) && j == columnIndex) {
                        userArrayPBM[i][j] = newColor;
                    }
                } else if (direction.equalsIgnoreCase("down")) {
                    if ((i >= rowIndex && i < (rowIndex + length)) && j == columnIndex) {
                        userArrayPBM[i][j] = newColor;
                    }
                }
            }
        }
    }

    private static void GetLengthFromUser() {
        System.out.print("Length: ");
        length = sc.nextInt();
    }

    private static void GetDirectionFromUser() {
        sc.nextLine(); //To skip the leftover escape sequence from previous nextInt() method.
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

    private static void FillNewIndexPositionWithNewColor() {
        userArrayPBM[rowIndex][columnIndex] = newColor;
    }

    private static void GenerateInitialUserArray() {
        userArrayPBM = new int[height][width];
        for (int i = 0; i < userArrayPBM.length; i++) {
            for (int j = 0; j < width; j++) {
                userArrayPBM[i][j] = color;
            }
        }
    }

    private static void GetColumnFromUser() {
        boolean stayInLoop = true;
        do {
            System.out.print("Column: ");
            columnIndex = sc.nextInt();
            if (!(columnIndex >= width || columnIndex < 0)) {
                stayInLoop = false;
            } else {
                System.out.println("Value is outside the bounds of the array.");
            }
        } while (stayInLoop);
    }


    private static void GetNewColorFromUser() {
        boolean stayInLoop = true;
        do {
            System.out.print("New Color: ");
            newColor = sc.nextInt();
            if (newColor >= 0 && newColor < 256) {
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
            if (!(rowIndex > height || rowIndex < 0)) {
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
            if (color >= 0 && color < 256) {
                stayInLoop = false;
            } else {
                System.out.println("Color must be from 0 to 255.");
            }
        } while (stayInLoop);
        System.out.println();
    }

}
