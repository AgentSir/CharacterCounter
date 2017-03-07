package ua.sputilov.entities;

import java.util.Scanner;

/**
 * The class represents an object that is able to communicate with the user via console.
 */
public class UserInterface  {

    private String inputString;
    private Scanner scanner = new Scanner(System.in);

    public UserInterface() {

        System.out.println("---------------------");
        System.out.println("| Character Counter |");
        System.out.println("---------------------");
    }

    /**
     * The method reads input line
     * @return String
     */
    public String getStringToProcess() {

        System.out.println("Please enter a string to process:");
        this.inputString = this.scanner.nextLine();

        return this.inputString;
    }

    public void printResult(String result) {

        System.out.println("The result is: " + result);
    }
}
