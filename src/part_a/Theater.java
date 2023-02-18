package part_a;

import java.io.*;
import java.util.Scanner;

public class Theater {

    private int[] row1 = new int[12];
    private int[] row2 = new int[16];
    private int[] row3 = new int[20];

    public static void main(String[] args) {

        // part_a.Theater Obj
        Theater theater = new Theater();

        System.out.println("\n\t\t\t>>> Welcome to the New Theatre <<<");
        while (true) {
            switch (theater.mainMenu()) {
                case -1:
                    break;

                case 0:
                    System.exit(0);
                    break;

                case 1:
                    theater.buy_ticket();
                    break;

                case 2:
                    theater.print_seating_area();
                    break;

                case 3:
                    theater.cancel_ticket();
                    break;

                case 4:
                    theater.show_available();
                    break;

                case 5:
                    theater.save();
                    break;

                case 6:
                    theater.load();
                    break;

                default:
                    System.out.println("Invalid option !");
                    break;
            }
        }

    }

    private int getIntInput() {
        try {
            Scanner user = new Scanner(System.in);
            return user.nextInt();

        } catch(Exception ex) {
            System.out.println("Invalid input enter integer value !\n");
        }

        return -1;
    }
    private String getStrInput() {
        Scanner user = new Scanner(System.in);
        return user.nextLine();
    }
    private boolean yesOrNoQuestion(String question) {
        boolean returnValue = false;
        while (true) {
            System.out.print(question);

            String yesOrNo = getStrInput();
            if (yesOrNo.equalsIgnoreCase("YES") || yesOrNo.equalsIgnoreCase("Y")) {
                returnValue = true;
                break;
            } else if (yesOrNo.equalsIgnoreCase("NO") || yesOrNo.equalsIgnoreCase("N")) {
                break;
            }
        }
        return returnValue;
    }
    private void optionBreakWithOptionName(String optionName) {
        System.out.println("\n\t------------------------------------------------------------");
        System.out.println("\t\t"+optionName+"\n");
    }
    private int mainMenu() {

        System.out.println("\t------------------------------------------------------------");
        System.out.println("\tPlease select an option :");
        System.out.println("\t1) Buy a ticket");
        System.out.println("\t2) Print seating area");
        System.out.println("\t3) Cancel ticket");
        System.out.println("\t4) List available seats");
        System.out.println("\t5) Save to file");
        System.out.println("\t6) Load from file");
        //System.out.println("\t7) Print ticket information and total price");
        //System.out.println("\t8) Sort tickets by price");
        System.out.println("\t\t0) Quit");
        System.out.println("\t------------------------------------------------------------");
        System.out.print("Enter option : ");

        return getIntInput();
    }
    private void buy_ticket() {

        optionBreakWithOptionName(">>>>> Buy a ticket");

        System.out.println("\tAvailable seat numbers");
        System.out.print("Row 1 :- ");
        for (int i=0;i<row1.length;i++) {
            if (row1[i] != 1) {
                System.out.print((i+1)+", ");
            }
        }
        System.out.print("\nRow 2 :- ");
        for (int i=0;i<row2.length;i++) {
            if (row2[i] != 1) {
                System.out.print((i+1)+", ");
            }
        }
        System.out.print("\nRow 3 :- ");
        for (int i=0;i<row3.length;i++) {
            if (row3[i] != 1) {
                System.out.print((i+1)+", ");
            }
        }
        System.out.println("\n");

        boolean loopBreak = true;
        while (loopBreak) {
            System.out.print("Enter row number : ");
            int rowNumber = getIntInput();

            if (rowNumber > 0 && rowNumber < 4) {
                while(loopBreak) {
                    System.out.print("Enter seat number : ");
                    int seatNumber = getIntInput();

                    switch (rowNumber) {
                        case 1 -> {
                            if (seatNumber > 0 && seatNumber < 13) {
                                if (row1[seatNumber - 1] != 1) {
                                    row1[seatNumber - 1] = 1;
                                    System.out.println(">>> Row " + rowNumber + " Seat " + seatNumber + " booked successfully");
                                    loopBreak = false;

                                } else {
                                    System.out.println("This seat is not available !\n");
                                    if (!yesOrNoQuestion("Do you want to try again this row another seat : ")) {
                                        loopBreak = false;
                                    }
                                }
                            } else if (seatNumber != -1) {
                                System.out.println("Invalid seat number !\n");
                                if (!yesOrNoQuestion("Do you want to try again another seat : ")) {
                                    loopBreak = false;
                                }
                            }
                        }
                        case 2 -> {
                            if (seatNumber > 0 && seatNumber < 17) {
                                if (row2[seatNumber - 1] != 1) {
                                    row2[seatNumber - 1] = 1;
                                    System.out.println(">>> Row " + rowNumber + " Seat " + seatNumber + " booked successfully");
                                    loopBreak = false;

                                } else {
                                    System.out.println("This seat is not available !\n");
                                    if (!yesOrNoQuestion("Do you want to try again this row another seat : ")) {
                                        loopBreak = false;
                                    }
                                }
                            } else if (seatNumber != -1) {
                                System.out.println("Invalid seat number !\n");
                                if (!yesOrNoQuestion("Do you want to try again another seat : ")) {
                                    loopBreak = false;
                                }
                            }
                        }
                        case 3 -> {
                            if (seatNumber > 0 && seatNumber < 21) {
                                if (row3[seatNumber - 1] != 1) {
                                    row3[seatNumber - 1] = 1;
                                    System.out.println(">>> Row " + rowNumber + " Seat " + seatNumber + " booked successfully");
                                    loopBreak = false;

                                } else {
                                    System.out.println("This seat is not available !\n");
                                    if (!yesOrNoQuestion("Do you want to try again this row another seat : ")) {
                                        loopBreak = false;
                                    }
                                }
                            } else if (seatNumber != -1) {
                                System.out.println("Invalid seat number !\n");
                                if (!yesOrNoQuestion("Do you want to try again another seat : ")) {
                                    loopBreak = false;
                                }
                            }
                        }
                    }

                }


            } else if (rowNumber != -1) {
                System.out.println("Invalid row number !\n");
                if (!yesOrNoQuestion("Do you want to try again : ")) {
                    loopBreak = false;
                }
            }

            if (yesOrNoQuestion("\nDo you want to try again : ")) {
                loopBreak = true;
            }
        }


    }
    private void print_seating_area() {

        optionBreakWithOptionName(">>>>> Print seating area");

        System.out.print("\t\t*************\n\t\t*   STAGE   *\n\t\t*************\n\t\t");
        for (int i=0;i<row1.length;i++) {
            if (row1.length/2 == i) {
                System.out.print(" ");
            }
            if (row1[i] != 1) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }

        }
        System.out.printf("\n\t%-2s"," ");

        for (int i=0;i<row2.length;i++) {
            if (row2.length/2 == i) {
                System.out.print(" ");
            }
            if (row2[i] != 1) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }

        }
        System.out.printf("\n%-4s"," ");

        for (int i=0;i<row3.length;i++) {
            if (row3.length/2 == i) {
                System.out.print(" ");
            }
            if (row3[i] != 1) {
                System.out.print("O");
            } else {
                System.out.print("X");
            }

        }
        System.out.println("\n");

    }
    private void cancel_ticket() {

        optionBreakWithOptionName(">>>>> Cancel ticket");

        System.out.println("\tBooked seat numbers");
        System.out.print("Row 1 :- ");
        for (int i=0;i<row1.length;i++) {
            if (row1[i] != 0) {
                System.out.print((i+1)+", ");
            }
        }
        System.out.print("\nRow 2 :- ");
        for (int i=0;i<row2.length;i++) {
            if (row2[i] != 0) {
                System.out.print((i+1)+", ");
            }
        }
        System.out.print("\nRow 3 :- ");
        for (int i=0;i<row3.length;i++) {
            if (row3[i] != 0) {
                System.out.print((i+1)+", ");
            }
        }
        System.out.println("\n");

        boolean loopBreak = true;
        while (loopBreak) {
            System.out.print("Enter row number : ");
            int rowNumber = getIntInput();

            if (rowNumber > 0 && rowNumber < 4) {
                while(loopBreak) {
                    System.out.print("Enter seat number : ");
                    int seatNumber = getIntInput();

                    switch (rowNumber) {
                        case 1 -> {
                            if (seatNumber > 0 && seatNumber < 13) {
                                if (row1[seatNumber - 1] != 0) {
                                    row1[seatNumber - 1] = 0;
                                    System.out.println(">>> Row " + rowNumber + " Seat " + seatNumber + " cancel ticket successfully");
                                    loopBreak = false;

                                } else {
                                    System.out.println("This seat is available !\n");
                                    if (!yesOrNoQuestion("Do you want to cancel this row another ticket : ")) {
                                        loopBreak = false;
                                    }
                                }
                            } else if (seatNumber != -1) {
                                System.out.println("Invalid seat number !\n");
                                if (!yesOrNoQuestion("Do you want to cancel another ticket : ")) {
                                    loopBreak = false;
                                }
                            }
                        }
                        case 2 -> {
                            if (seatNumber > 0 && seatNumber < 17) {
                                if (row2[seatNumber - 1] != 0) {
                                    row2[seatNumber - 1] = 0;
                                    System.out.println(">>> Row " + rowNumber + " Seat " + seatNumber + " cancel ticket successfully");
                                    loopBreak = false;

                                } else {
                                    System.out.println("This seat is available !\n");
                                    if (!yesOrNoQuestion("Do you want to cancel this row another ticket : ")) {
                                        loopBreak = false;
                                    }
                                }
                            } else if (seatNumber != -1) {
                                System.out.println("Invalid seat number !\n");
                                if (!yesOrNoQuestion("Do you want to cancel another ticket : ")) {
                                    loopBreak = false;
                                }
                            }
                        }
                        case 3 -> {
                            if (seatNumber > 0 && seatNumber < 21) {
                                if (row3[seatNumber - 1] != 0) {
                                    row3[seatNumber - 1] = 0;
                                    System.out.println(">>> Row " + rowNumber + " Seat " + seatNumber + " cancel ticket successfully");
                                    loopBreak = false;

                                } else {
                                    System.out.println("This seat is available !\n");
                                    if (!yesOrNoQuestion("Do you want to cancel this row another ticket : ")) {
                                        loopBreak = false;
                                    }
                                }
                            } else if (seatNumber != -1) {
                                System.out.println("Invalid seat number !\n");
                                if (!yesOrNoQuestion("Do you want to cancel another ticket : ")) {
                                    loopBreak = false;
                                }
                            }
                        }
                    }

                }


            } else if (rowNumber != -1) {
                System.out.println("Invalid row number !\n");
                if (!yesOrNoQuestion("Do you want to try again : ")) {
                    loopBreak = false;
                }
            }

            if (yesOrNoQuestion("\nDo you want to try again : ")) {
                loopBreak = true;
            }
        }
    }
    private void show_available() {

        optionBreakWithOptionName(">>>>> List available seats");

        System.out.print("Seats available in row 1 : ");
        for (int i=0;i<row1.length;i++) {
            if (row1[i] != 1) {
                System.out.print((i+1)+", ");
            }
        }
        System.out.print("\nSeats available in row 2 : ");
        for (int i=0;i<row2.length;i++) {
            if (row2[i] != 1) {
                System.out.print((i+1)+", ");
            }
        }
        System.out.print("\nSeats available in row 3 : ");
        for (int i=0;i<row3.length;i++) {
            if (row3[i] != 1) {
                System.out.print((i+1)+", ");
            }
        }
        System.out.println("\n");
    }
    private void save() {
        try {
            File dataFile = new File("Part_A_Data_File.txt");
            if (dataFile.exists()) {
                dataFile.delete();
            }
            if (dataFile.createNewFile()) {
                BufferedWriter saveData = new BufferedWriter(new FileWriter(dataFile.getName(),true));
                for (int i=0;i<row1.length;i++) {
                    if (row1[i] != 0) {
                        saveData.write("X");
                    } else {
                        saveData.write("O");
                    }
                }
                saveData.newLine();
                for (int i=0;i<row2.length;i++) {
                    if (row2[i] != 0) {
                        saveData.write("X");
                    } else {
                        saveData.write("O");
                    }
                }
                saveData.newLine();
                for (int i=0;i<row3.length;i++) {
                    if (row3[i] != 0) {
                        saveData.write("X");
                    } else {
                        saveData.write("O");
                    }
                }
                saveData.close();
                System.out.println(">>> Successfully save data into file\n");
            }

        } catch(IOException ex) {
            System.out.println("Try again !\n");
        }
    }
    private void load() {
        try {
            File dataFile = new File("Part_A_Data_File.txt");
            if (dataFile.exists()) {

                BufferedReader loadData = new BufferedReader(new FileReader(dataFile.getName()));
                String[] data = new String[3];

                for (int i=0;i<data.length;i++) {
                    data[i] = loadData.readLine();
                }
                for (int i=0;i<row1.length;i++) {
                    if (data[0].toCharArray()[i] != 'O') {
                        row1[i] = 1;
                    } else {
                        row1[i] = 0;
                    }
                }
                for (int i=0;i<row2.length;i++) {
                    if (data[1].toCharArray()[i] != 'O') {
                        row2[i] = 1;
                    } else {
                        row2[i] = 0;
                    }
                }
                for (int i=0;i<row3.length;i++) {
                    if (data[2].toCharArray()[i] != 'O') {
                        row3[i] = 1;
                    } else {
                        row3[i] = 0;
                    }
                }

                loadData.close();
                System.out.println(">>> Successfully load data into programme\n");

            } else {
                System.out.println("No data file is available !\n");
            }

        } catch(IOException ex) {
            System.out.println("Try again !\n");

        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
