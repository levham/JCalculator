package com.levham.jcalculator;

/**
 * Proje: JCalculator 
 * Açıklama: Bu proje ile tarih - yaş hesaplamaları ve dört işlem gibi 
 * temel matematiksel işlemlerizi kolayca yapabilirsiniz.
 * 
 * @author Levham
 * @version 1.0
 * @since 29.01.2026
 */

public class JCalculator {

    public static void main(String[] args) {
        JCalculatorController jCalculatorController = new JCalculatorController();
        jCalculatorController.handleArgument(args);
    }
}
