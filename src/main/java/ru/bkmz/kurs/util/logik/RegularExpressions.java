package ru.bkmz.kurs.util.logik;


import ru.bkmz.kurs.util.Plant.Notification;

public class RegularExpressions {
    public static  double expression(String str) {
        //Удаляем внешние пробелы. Из-за рекурсии удаляются все пробелы, кроме таких "5 5+7"
        str = str.trim();
        // кривой способ удаления всех внешних скобок
        while((str = removeOuterBrackets(str)) != removeOuterBrackets(str)) ;
        //конец рекурсии, если блок содержит только число
        if (isNumber(str)) {
            return Double.parseDouble(str);
        }
        //вызываем метод, который делит строку на два блока, делает  вызов expression() внутри и так пока не наткнемся на блок, состоящий только из числа
        return splicing(str);
    }

    public static double splicing(String  str) {
        //ищем точку для разделения строки на два блока
        int splice = findSplice(str);
        String block1,block2;
        block1 = str.substring(0, splice);
        block2 = str.substring(splice + 1);
        //тут проиходит вызов expression() и так будет происходить, пока мы не получим только число в блоке
        //потом блоки будут склеиваться снизу вверх
        switch (str.charAt(splice)) {
            case '+':
                return expression(block1) + expression(block2);
            case '-':
                return expression(block1) - expression(block2);
            case '*':
                return expression(block1) * expression(block2);
            case '/':
                return expression(block1) / expression(block2);
        }
        return 0; //никогда сюда не попадем
    }

    private static String removeOuterBrackets(String str) {
        if (str.startsWith("(") && str.endsWith(")")) {
            int count = 0;
            for (int i = 1; i < str.length()-1; i++) {
                switch (str.charAt(i)) {
                    case '(':
                        count++;
                        break;
                    case ')':
                        count--;
                        break;
                }
                if (count < 0) {
                    return str;
                }
            }
            if (count !=0) {
                new Notification("Уведомление", "Brakets! (()");
                throw new IllegalArgumentException("Brakets! (()");
            }
            return str.substring(1, str.length()-1);
        }
        return str; //никогда сюда не попадем
    }

    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e)
        {
            return false;
        }
        return true;
    }

    //приоритет при поиске разделителя у + -, потом * /
    // (5+6)*7+8  -> (5+6)*7 [+] 8
    // если не можем найти + или - для разделения строки, ищем * /
    // если не находим, то кидается ошибка, т.к. сюда строка только с числом не может попасть
    public static int findSplice(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '(':
                    count++;
                    break;
                case ')':
                    count--;
                    break;
            }
            if (count < 0) {
                new Notification("Уведомление", "Brackets! )(");
                throw new IllegalArgumentException("Brackets! )(");
            }
            if (count == 0 &&
                    (str.charAt(i) == '+' || str.charAt(i) == '-')) {
                return i;
            }
        }
        count =0;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '(':
                    count++;
                    break;
                case ')':
                    count--;
                    break;
            }
            if (count < 0) {
                new Notification("Уведомление", "Brackets! )(");
                throw new IllegalArgumentException("Brackets! )(");
            }
            if (count == 0 &&
                    (str.charAt(i) == '*' || str.charAt(i) == '/')) {
                //TODO вызов метода для конвертации строки 1/7/5*2 -> 1*2/(7*5)
                //а лучше вообще переписать findSplice и removeOuterBrackets, много повторяющегося кода
                return i;
            }
        }
        if (count != 0) {
            new Notification("Уведомление", "Brakets! (()");
            throw new IllegalArgumentException("Brakets! (()");
        } else if (count ==0) {
            new Notification("Уведомление", "symbols||spaces between numbers||double operators|| *) /) (+ etc");
            throw new IllegalArgumentException("symbols||spaces between numbers||double operators|| *) /) (+ etc");
        }
        return 0; //никогда сюда не попадем
    }

    public static int convert(String str) {
        //TODO конвертация строки 1/7/5*2 -> 1*2/(7*5)
        return 0;
    }

    public static void main(String[] args) {
        String str = "((1 + 2) + 7- 15 * 8)*7 + (34 - 4)/(7 + 8)";
        System.out.println(str);
        System.out.println(expression(str));
    }
}