import java.util.Scanner;
import java.util.Arrays;

public class Function02 {
    static Scanner in = new Scanner(System.in);
    static double[] przychody = null;
    static double[] kosztyUzyskPrzych = null;
    static double[] dochody = null;

    static void inicjalizacja() {
        System.out.println("Wykonuję analizę przychodów z wybranego okresu");
    }
    static void pokazMenu() {
        System.out.println("Wybierz operację:");
        System.out.println(" 1. Wczytaj przychody i koszty uzyskania przychodu");
        if (przychody != null) {
            System.out.println(" 2. Pokaż przychody i dochody");
            System.out.println(" 3. Wyznacz sumę i średnią przychodów i dochodów");
            System.out.println(" 4. Wyznacz minimum i maksimum przychodów i dochodów");
            System.out.println(" 5. Wyznacz medianę przychodów i dochodów");
        }
        System.out.println(" 0. Zakończ");
        System.out.print("=> ");
    }

    static void wczytajPrzychodyDochody() // 1. Wczytaj przychody i koszty uzyskania przychodu
    {
        int ilePrzychodow = 0;
        System.out.println("Ile będzie przychodów: ");
        ilePrzychodow = in.nextInt();
        przychody = new double[ilePrzychodow];
        for (int i = 0; i < ilePrzychodow; ++i) {
            System.out.print((i + 1) + ": ");
            przychody[i] = in.nextDouble();
        }
        System.out.println("Wczytaj koszty uzyskania przychodu: ");
        kosztyUzyskPrzych = new double[ilePrzychodow];
        for (int i = 0; i < ilePrzychodow; ++i) {
            System.out.print((i + 1) + ": ");
            kosztyUzyskPrzych[i] = in.nextDouble();
        }
        dochody = new double[ilePrzychodow];
        for (int i = 0; i < ilePrzychodow; i++) {
            dochody[i] = przychody[i] - kosztyUzyskPrzych[i];
        }

    }

    static void pokazPrzychodyDochody() // 2. Pokaż przychody i dochody
    {
        System.out.println("\n\nPrzegląd przychodów i dochodów: ");

        for (int i = 0; i < przychody.length; ++i) {
            System.out.println((i + 1) + " Przychody : " + przychody[i]);
            System.out.println((i + 1) + " Dochody : " + dochody[i]);
        }
    }

    static void wyznaczSumAvgPrzychodyDochody() // 3. Wyznacz sumę i średnią
    {
        double sumPrzychody = 0;
        double sumDochody = 0;
        double avgDochody = 0;
        double avgPrzychody = 0;
        for (int i = 0; i < przychody.length; ++i) {
            sumPrzychody += przychody[i];
            sumDochody += dochody[i];
        }
        avgPrzychody = sumPrzychody / przychody.length;
        avgDochody = sumDochody / dochody.length;

        System.out.println("\nSuma przychodów: " + sumPrzychody + ", Suma dochodów: " + sumDochody);
        System.out.println("Średnia przychodów: " + avgPrzychody + ", Średnia dochodów: " + avgDochody);
    }

    static void wyznaczMinMaxPrzychodyDochody() // 4. Wyznacz minimum i maksimum
    {
        Arrays.sort(przychody); // Sortowanie kopii oryginalnych tablic
        Arrays.sort(dochody); // Sortowanie kopii oryginalnych tablic

        System.out.println("Minimalny przychód: " + przychody[0]);
        System.out.println("Maksymalny przychód: " + przychody[przychody.length - 1]);

        System.out.println("Minimalny dochód: " + dochody[0]);
        System.out.println("Maksymalny dochód: " + dochody[dochody.length - 1]);

    }

    static void wyznaczMedianePrzychodyDochody() // 5. Wyznacz medianę
    {
        Arrays.sort(przychody); // Sortowanie kopii oryginalnych tablic
        Arrays.sort(dochody); // Sortowanie kopii oryginalnych tablic
        double medianaPrzychody = 0;
        double medianaDochody = 0;
        if (przychody.length % 2 == 1) {
            medianaPrzychody = przychody[(przychody.length + 1) / 2 - 1];
            medianaDochody = dochody[(dochody.length + 1) / 2 - 1];
        } else {
            medianaPrzychody = (przychody[przychody.length / 2 - 1] + przychody[przychody.length / 2]) / 2;
            medianaDochody = (dochody[dochody.length / 2 - 1] + dochody[dochody.length / 2]) / 2;

        }
        System.out.println("Mediana przychodów: " + medianaPrzychody);
        System.out.println("Mediana dochodów: " + medianaDochody);
    }

    static void wykonanie() {
        int choice = 0;
        do {
            pokazMenu();
            choice = in.nextInt();
            if (choice >= 1 && przychody != null) {
                switch (choice) {
                    case 1:
                        wczytajPrzychodyDochody();
                        break;
                    case 2:
                        pokazPrzychodyDochody();
                        break;
                    case 3:
                        wyznaczSumAvgPrzychodyDochody();
                        break;
                    case 4:
                        wyznaczMinMaxPrzychodyDochody();
                        break;
                    case 5:
                        wyznaczMedianePrzychodyDochody();
                        break;
                }
            }else{
                switch(choice){
                    case 1: 
                        wczytajPrzychodyDochody();
                        break;
                }
                
            }
        }
        while (choice != 0);
    }

    static void zakonczenie() {
        System.out.println("Dziękuję za współpracę, do zobaczenia!");
    }

    public static void main(String[] args) {
        inicjalizacja();
        wykonanie();
        zakonczenie();
    }
}
