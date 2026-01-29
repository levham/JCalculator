package com.levham.jcalculator;

/**
 * Show fonksiyonlarının bulunduğu yer
 * @author levham
 */

public class JCalculatorView {

    public static void showHelp() {
        System.out.println("JCalculator @levham");
        System.out.println("Komutlar:");
        System.out.println("  help, -help, h, -h");
        System.out.println("    Yardım menüsünü gösterir.\n");

        System.out.println("  age <date>");
        System.out.println("  yas <tarih>");
        System.out.println("    Yaş hesaplar.");
        System.out.println("    age 1990");
        System.out.println("    age 29.01.1990");
        System.out.println("    age 29/01/1990\n");
        System.out.println("    yas 1990");
        System.out.println("    yas 29.01.1990");
        System.out.println("    yas 29/01/1990\n");

        System.out.println("  sum <number1> <number2> ...");
        System.out.println("  topla <sayı1> <sayı2> ...");
        System.out.println("    Girilen sayıların toplamını verir.");
        System.out.println("      sum 5 10 20 → toplam: 35\n");
        System.out.println("      topla 5 10 20 → toplam: 35\n");

        System.out.println("  calc, cal,c <ifade>");
        System.out.println("  hesapla, hesap,hes <ifade>");
        System.out.println("    Matematiksel ifadeyi hesaplar.");
        System.out.println("     calc 2+3*5 → Sonuç = 17\n");
        System.out.println("     hesapla 2+3*5 → Sonuç = 17\n");
    }

    public static void showError() {
        System.out.println("Hata oluştu.");
        System.out.println("Detaylar için -help.");
    }

    public static void showNullParameters() {
        System.out.println("Parametre bulunamadı");
        System.out.println("Detaylar için -help.");
    }

    public static void showMissingParameter() {
        System.out.println("Hata oluştu.");
        System.out.println("Eksik parametre algılandı.");
        System.out.println("Detaylar için -help.");
    }
}
