package com.levham.jcalculator;

/**
 * Argumanlar kontrol edilip Serviceye gönderilir 
 * @author levham
 */

class JCalculatorController {
    void handleArgument(String[] args) {

        //arguman yoksa
        if (args == null || args.length == 0) {
            JCalculatorView.showNullParameters();
            return;
        }

        //ilk parametre
        String firstArg = args[0];

        //ilk parametre dışındakiler
        String[] otherArg = new String[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            otherArg[i - 1] = args[i];
        }

        // 1 parametreli ise 
        if (args.length >= 1) {
            switch (firstArg) {
                case "help", "-help", "h", "-h", "/?" -> {
                    JCalculatorView.showHelp();
                    return;
                }
            }
        }

        // 2 veya daha fazla parametreli ise 
        if (args.length >= 2) {
            switch (firstArg) {
                case "age", "yaş", "yas" ->
                    JCalculatorService.age(args[1]);

                case "date", "tarih" -> {
                    if (args.length == 3) {
                        JCalculatorService.date(args[1], args[2]);
                    }
                }

                case "sum", "topla" ->
                    JCalculatorService.sum(otherArg);

                case "calc", "cal", "c", "hesapla", "hesap", "hes" ->
                    JCalculatorService.calc(otherArg);

                default ->
                    JCalculatorView.showError();

            }
        }

    }
}
