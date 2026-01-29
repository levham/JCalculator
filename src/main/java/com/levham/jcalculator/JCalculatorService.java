package com.levham.jcalculator;
 
import org.apache.commons.jexl3.*;
import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.JexlException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * age -> yasş hesabı
 * date -> iki tarih arası hesap
 * sum -> toplama yapılan yer
 * cal -> 4 işlem hesabın yapıldığı yer
 * @author levham
 */

public class JCalculatorService {

    //yaş hesaplama
    public static void age(String date1) {
        LocalDate tarih = null;
        String input = date1;
        input = input.trim();

        try {
            if (input.matches("\\d{4}")) {
                // sadece yıl
                int yil = Integer.parseInt(input);
                tarih = LocalDate.of(yil, 1, 1);

            } else if (input.contains(".")) {
                DateTimeFormatter formatter
                        = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                tarih = LocalDate.parse(input, formatter);

            } else if (input.contains("/")) {
                DateTimeFormatter formatter
                        = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                tarih = LocalDate.parse(input, formatter);
            }

            if (tarih == null) {
                System.out.println("Geçersiz tarih formatı");
                return;
            }

            Period fark = Period.between(tarih, LocalDate.now());

            System.out.println(
                     Math.abs(fark.getDays()) + " gün"
                    + Math.abs(fark.getMonths()) + " ay, "
                    + Math.abs(fark.getYears()) + " yıl, "
            );

        } catch (DateTimeParseException | NumberFormatException e) {
            System.out.println("Geçersiz tarih girdisi");
        }
    }

    //iki tarih arasındaki farkı bulma 
    public static void date(String date1, String date2) {
        LocalDate tarih1 = null;
        LocalDate tarih2 = null;

        String input1 = date1.trim();
        String input2 = date2.trim();

        try {
            // 1. Tarih parse et
            if (input1.matches("\\d{4}")) {
                int yil1 = Integer.parseInt(input1);
                tarih1 = LocalDate.of(yil1, 1, 1);
            } else if (input1.contains(".")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                tarih1 = LocalDate.parse(input1, formatter);
            } else if (input1.contains("/")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                tarih1 = LocalDate.parse(input1, formatter);
            }

            // 2. Tarih parse et
            if (input2.matches("\\d{4}")) {
                int yil2 = Integer.parseInt(input2);
                tarih2 = LocalDate.of(yil2, 1, 1);
            } else if (input2.contains(".")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                tarih2 = LocalDate.parse(input2, formatter);
            } else if (input2.contains("/")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                tarih2 = LocalDate.parse(input2, formatter);
            }

            // Kontrol
            if (tarih1 == null || tarih2 == null) {
                System.out.println("Geçersiz tarih formatı");
                return;
            }

            // Fark hesapla
            Period fark = Period.between(tarih1, tarih2);

            System.out.println(
                     Math.abs(fark.getDays()) + " gün"
                    +  Math.abs(fark.getMonths()) + " ay, "
                    +  Math.abs(fark.getYears()) + " yıl, "
            );

        } catch (DateTimeParseException | NumberFormatException e) {
            System.out.println("Geçersiz tarih girdisi");
        }
    }

    //girilen parametreleri toplar
    public static void sum(String[] otherArg) {
        try {
            long total = 0;
            long value = 0;
            for (String item : otherArg) {
                value += Long.parseLong(item);
                total = Math.addExact(total, value);
            }
            System.out.println("toplam: " + total);

        } catch (ArithmeticException e) {
            System.out.println("Sayı sınırlarını aştınız ");

        } catch (NumberFormatException e) {
            System.out.println("Bir hata oluştu: Veri sadece sayıdan oluşmalı");
            System.out.println(e);

        } catch (Exception e) {
            System.out.println("Bir hata oluştu: " + e);
        }
    }

    //hesaplama yeri
    public static void calc(String[] otherArg) {
        StringBuilder lineArg = new StringBuilder();
        for (String item : otherArg) {
            lineArg.append(item);
        }

        String ifade = lineArg.toString().trim();

        // Hesaplama yeri
        JexlEngine jexl = new JexlBuilder()
                .strict(true)
                .silent(false)
                .arithmetic(new JexlArithmetic(true)) // safe arithmetic
                .create();

        try {
            JexlExpression expr = jexl.createExpression(ifade);
            Object result = expr.evaluate(null);
            System.out.println("Sonuç = " + result);
        } catch (JexlException e) {
            System.out.println("Geçersiz matematik ifade: " + e.getMessage());
        }

    }
}
