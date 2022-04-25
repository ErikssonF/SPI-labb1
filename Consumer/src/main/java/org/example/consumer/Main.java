package org.example.consumer;

import org.example.convert.Address;
import org.example.convert.Converter;

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

        while (main.run) {
            main.menu();
        }
    }

    public void menu() {

        System.out.println("""

                Valutaomväxlare från SEK till Euro eller Dansk Krona(Dkk).\s
                Välj ett av alternativen nedan:\s
                """);

        for (Converter converter : serviceLoader) {
            var annotation = converter.getClass().getAnnotation(Address.class);

            if (annotation == null) {
                System.out.println("Kunde inte hitta valutan.");
            } else {
                System.out.println(annotation.value());
            }
        }

        System.out.println("");
        System.out.println("1 för Euro eller 2 för Dkk.");
        System.out.println("3 för att avsluta programmet.");

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
}

