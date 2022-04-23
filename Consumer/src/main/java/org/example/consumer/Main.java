package org.example.consumer;

import java.util.Scanner;

public class Main {
    Scanner scan = new Scanner(System.in);
    getConverter getConverter = new getConverter();

    boolean run = true;

    public static void main(String[] args) {

        Main main = new Main();

        while (main.run) {
            main.menu();
        }
    }

    public void menu() {

        float amount;

        System.out.println("Valutaomväxlare från SEK till Euro eller Dansk Krona(Dkk) Dollar.");
        System.out.println("Välj 1 för Euro eller 2 för Dkk.");
        System.out.println("Välj 3 för att avsluta programmet.");

        int choice = scan.nextInt();

        if(choice == 1) {
            System.out.println("Ange summa i SEK som du vill omvandla till Euro");
            amount = scan.nextFloat();
            getConverter.toEuro(amount);
        } else if (choice == 2) {
            System.out.println("Ange summa i SEK som du vill omvandla till Dkk");
            amount = scan.nextFloat();
            getConverter.toDollar(amount);
        }else{
            run = false;
        }
    }
}
