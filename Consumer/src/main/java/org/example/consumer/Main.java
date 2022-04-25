package org.example.consumer;

import org.example.convert.Converter;
import org.example.convert.CurrencyType;

import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {

    Scanner scan = new Scanner(System.in);
    GetConverter getConverter = new GetConverter();
    ServiceLoader<Converter> serviceLoader = ServiceLoader.load(Converter.class);

    float amount;
    boolean run = true;

    public static void main(String[] args) {

        Main main = new Main();

        System.out.println("\nValutaomväxlare från SEK till Euro eller Dansk Krona(Dkk).");

        while (main.run) {
            main.menu();
        }
    }

    public void menu() {

        menuPrint();

        int choice = scan.nextInt();

        if (choice == 1) {
            System.out.println("Ange summa i SEK som du vill omvandla till Euro");
            amount = scan.nextFloat();
            getConverter.toEuro(amount);

        } else if (choice == 2) {
            System.out.println("Ange summa i SEK som du vill omvandla till Dkk");
            amount = scan.nextFloat();
            getConverter.toDkk(amount);

        } else {
            run = false;
        }
    }

    void menuPrint() {

        System.out.println("""
                ==========================================================\s
                Välj ett av alternativen nedan:\s
                """);

        for (Converter converter : serviceLoader) {
            var annotation = converter.getClass().getAnnotation(CurrencyType.class);

            if (annotation == null) {
                System.out.println("Kunde inte hitta valutan.");
            } else {
                System.out.println(annotation.value());
            }
        }

        System.out.println("");
        System.out.println("1 för Euro eller 2 för Dkk.");
        System.out.println("3 för att avsluta programmet.");

    }
}

