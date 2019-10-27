package ru.bkmz.kurs.util;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ru.bkmz.kurs.Main;

import static ru.bkmz.kurs.util.RegularExpressions.expression;


public class Functions {
    private static Stage stage = Main.stage;
    VBox vBox;
    Text out;
    Button score;
    /*TODO
       1.дописать https://www.sravni.ru/enciklopediya/info/formula-rascheta-kredita/ Формула расчета кредита аннуитетными платежами
       2. добавить формулы:
       http://www.ereport.ru/articles/macro/macro20.htm
       https://www.berdov.com/ege/credit/osnovnaya-formula/
       https://www.goodstudents.ru/bank/461-econnormativy.html
       http://dgunh.ru/content/umd/umd_econ_sfit_spo_osnovyecon.pdf (дофига формул)
     */


    /**
     * @param value - значение
     * @param vBox  - коробка
     * @param score - кнопка
     */
    public Functions(ObservableValue<? extends Planet> value, VBox vBox, Button score) {
        this.vBox = vBox;

        this.score = score;
        this.vBox.getChildren().clear();
        switch (value.getValue().code) {
            case "Кт":
                Kt();
                break;
            case "Кст":
                Kct();
                break;
            case "Кд":
                Kd();
                break;
            case "Кпк":
                Kpk();
                break;
            case "Квк":
                Kvk();
                break;
            case "all":
                all();
                break;
            case "ргппк":
                prppk();
                break;
            case "пск":
                psc();
                break;
            case "ркап":
                rkap();
                break;

        }


    }

    private void rkap() {
        TextArea inf = textAreaBuild("Аннуитетные платежи отличаются тем, что клиент выплачивает задолженность равными долями.\n" +
                "Размер ежемесячного платежа = СЗ*(П+(П/(1+П)*СК-1)), где\n" +
                "\n" +
                "СЗ — сумма займа;\n" +
                "\n" +
                "П — ставка процента за один месяц;\n" +
                "\n" +
                "СК — срок кредитования.");
        out = textBuild("= ");
        HBox hBox = new HBox(10);
        vBox.getChildren().addAll(hBox, inf);
    }

    /**
     * ПСК
     * Полная стоимость кредита — это и есть та самая величина, отражающая все затраты заемщика, которые он понесет в процессе уплаты основного долга по кредиту. Раньше эту информацию банк старался умалчивать, дабы клиент не передумал оформлять кредит. Однако, согласно закону от 2014 года, банк обязуется указывать эту сумму на первой странице кредитного договора и на обязательном графике платежей. Причем размер этой записи должен быть максимально большим, дабы избежать дальнейших недоразумений.
     * <p>
     * Рассчитать этот показатель можно по простой формуле:
     * <p>
     * ПСК=СК+СВК+%, где:
     * <p>
     * СК — сумма кредита;
     * СВК — сумма всех комиссий (разовых и ежемесячных);
     * % — проценты по кредиту.
     */
    private void psc() {
        TextArea inf = textAreaBuild("Полная стоимость кредита — это и есть та самая величина, отражающая все затраты заемщика, которые он понесет в процессе уплаты основного долга по кредиту. Раньше эту информацию банк старался умалчивать, дабы клиент не передумал оформлять кредит. Однако, согласно закону от 2014 года, банк обязуется указывать эту сумму на первой странице кредитного договора и на обязательном графике платежей. Причем размер этой записи должен быть максимально большим, дабы избежать дальнейших недоразумений.\n" +
                "Рассчитать этот показатель можно по простой формуле:\n" +
                "ПСК=СК+СВК+%, где:\n" +
                "СК — сумма кредита;\n" +
                "СВК — сумма всех комиссий (разовых и ежемесячных);\n" +
                "% — проценты по кредиту.");
        out = textBuild("= ");
        HBox hBox = new HBox(10);
        Text t1 = textBuild("ПСК="),
                t2 = textBuild("+"),
                t3 = textBuild("+");
        TextField ck = textFieldBuild("", "СК"),
                cvk = textFieldBuild("", "CDR"),
                pr = textFieldBuild("", "%");
        score.setOnMouseClicked(event -> {
            double dck = expression(ck);
            double dcvk = expression(cvk);
            double dpr = expression(pr);

            out.setText("= " + (dck + dcvk + dpr));
        });
        hBox.getChildren().addAll(t1, ck, t2, cvk, t3, pr, out);
        vBox.getChildren().addAll(hBox, inf);
    }

    /**
     * https://jcredit-online.ru/info/formula_rascheta_procentov_po_kreditu_legko_i_prosto
     */
    private void prppk() {
        TextArea inf = textAreaBuild("S = Sз * i * Kк / Kг S - в целом все проценты, которые мы вычисляем;\n" +
                "Sз - размер кредита, исключая первый взнос, если таковой имеется;\n" +
                "i - годовая ставка в процентах, например 15% годовых;\n" +
                "Kк - число дней, которые вы будете платить кредит;\n" +
                "Kг - число дней в этом году.");
        out = textBuild("= ");
        HBox hBox = new HBox(10);
        Text t1 = textBuild("S = "), t2 = textBuild("*"), t3 = textBuild("*"), t4 = textBuild("/");
        TextField S3 = textFieldBuild("", "S3"), i = textFieldBuild("", "i"),
                Kk = textFieldBuild("", "Кк"), Kr = textFieldBuild("", "Кг");
        hBox.getChildren().addAll(t1, S3, t2, i, t3, Kk, t4, Kr, out);
        score.setOnMouseClicked(event -> {

            out.setText("= " + expression("(" + S3.getText() + ")" + t2.getText() + "(" + i.getText() + ")" + t3.getText() + "(" + Kk.getText() + ")" + t4.getText() + "(" + Kr.getText() + ")"));
        });
        vBox.getChildren().addAll(hBox, inf);


    }

    /**
     * Коэффициент динамики числа занятых сотрудников позволяет увидеть динамику численного состава
     * персонала за определенный период, оценить процесс заполнения вакансий с учетом количества увольнений за расчетный период
     * Кд = (Чп – Чу):Чобщ × 100 Где:
     * Кд – коэффициент динамики числа занятых (в процентах);
     * Чп – число принятых на работу сотрудников;
     * Чу – число уволенных из организации сотрудников;
     * Чобщ – число сотрудников организации на начало расчетного периода
     * В организации «Альфа» работают 2000 сотрудников. В 2012 году уволились 136 сотрудников и 168 приняты на работу.
     * Чс = (2000 + (2000 – 136 + 168)) : 2 = 2016 чел. Кд = ((168 – 136) : 2016) × 100 = 2%
     */
    private void Kd() {
        TextArea inf = textAreaBuild("Коэффициент динамики числа занятых сотрудников позволяет увидеть динамику" +
                "численного состава персонала за определенный период, оценить процесс заполнения вакансий с учетом " +
                "количества увольнений за расчетный период" +
                "\nКд = (Чп – Чу):Чобщ × 100 Где:\n" +
                "Кд – коэффициент динамики числа занятых (в процентах);\n" +
                "Чп – число принятых на работу сотрудников;\n" +
                "Чу – число уволенных из организации сотрудников;\n" +
                "Чобщ – число сотрудников организации на начало расчетного периода\n" +
                "В организации «Альфа» работают 2000 сотрудников. В 2012 году уволились 136 сотрудников и 168 приняты на работу.\n" +
                "Чс = (2000 + (2000 – 136 + 168)) : 2 = 2016 чел. Кд = ((168 – 136) : 2016) × 100 = 2%\n" +
                ""
        );
        out = textBuild("");
        HBox hBox = new HBox(10);
        Text t1 = textBuild("Кд = (");
        TextField chp = textFieldBuild("", "Чп");
        Text t2 = textBuild("-");
        TextField chy = textFieldBuild("", "Чу");
        Text t3 = textBuild(") :");
        TextField chobj = textFieldBuild("", "");
        Text t4 = textBuild("X 100 =");
        hBox.getChildren().addAll(t1, chp, t2, chy, t3, chobj, t4, out);
        vBox.getChildren().addAll(hBox, inf);
        score.setOnMouseClicked(event -> {
            double dchp = expression("(" + chp.getText() + ")"),
                    dchy = expression("(" + chy.getText() + ")"),
                    dchobj = expression("(" + chobj.getText() + ")");
            out.setText(String.valueOf((dchp - dchy) / dchobj * 100));
        });
    }

    /**
     * Коэффициент приема кадров позволяет оценить объем работ по приему персонала в организации
     * Кпк = (Чп : Чс) × 100 Где:
     * Кпк – коэффициент приема кадров (в процентах);
     * Чп – число принятых на работу сотрудников за определенный период;
     * Чс – среднесписочное число сотрудников (рассчитывается как среднее арифметическое численности персонала на начало и на конец отчетного периода)
     * В организации «Альфа» работают 2000 сотрудников. В 2012 году уволились 136 сотрудников и 168 приняты на работу.
     * Чс = (2000 + (2000 – 136 + 168)) : 2 = 2016 чел. Кпк = (168 : 2016) × 100 = 9%
     */
    private void Kpk() {
        out = textBuild("");
        TextArea inf = textAreaBuild("Коэффициент приема кадров позволяет оценить объем работ по приему персонала в организации\n" +
                "Кпк = (Чп : Чс) × 100 Где:\n" +
                "Кпк – коэффициент приема кадров (в процентах);\n" +
                "Чп – число принятых на работу сотрудников за определенный период;\n" +
                "Чс – среднесписочное число сотрудников (рассчитывается как среднее арифметическое численности персонала на начало и на конец отчетного периода)\n" +
                "В организации «Альфа» работают 2000 сотрудников. В 2012 году уволились 136 сотрудников и 168 приняты на работу.\n" +
                "Чс = (2000 + (2000 – 136 + 168)) : 2 = 2016 чел. Кпк = (168 : 2016) × 100 = 9% "
        );
        HBox hBox2 = new HBox(10);
        Text t1 = textBuild("Кд = (");
        TextField chp = textFieldBuild("", "Чп");
        Text t2 = textBuild(":");
        TextField chc = textFieldBuild("", "Чc");
        Text t3 = textBuild(") X 100 =");


        hBox2.getChildren().addAll(t1, chp, t2, chc, t3, out);
        vBox.getChildren().addAll(hBox2, inf);
        score.setOnMouseClicked(event -> {
            double dchp = expression("(" + chp.getText() + ")"),
                    dchy = expression("(" + chc.getText() + ")");
            out.setText(String.valueOf((dchp / dchy) * 100));
        });

    }

    /**
     * Коэффициент выбытия кадров позволяет оценить количество увольнений в процентном отношении к среднесписочной численности сотрудников
     * Квк = (Чу : Чс) × 100 Где:
     * Квк – коэффициент выбытия кадров (в процентах);
     * Чу – число уволенных сотрудников за определенный период;
     * Чс – среднесписочное число сотрудников (рассчитывается как среднее арифметическое численности персонала на начало и на конец отчетного периода)
     */
    private void Kvk() {
        out = textBuild("");
        TextArea inf = textAreaBuild("Коэффициент выбытия кадров позволяет оценить количество увольнений в процентном отношении к " +
                "среднесписочной численности сотрудников\n" +
                "Квк = (Чу : Чс) × 100 Где: \n" +
                "Квк – коэффициент выбытия кадров (в процентах); \n" +
                "Чу – число уволенных сотрудников за определенный период; \n" +
                "Чс – среднесписочное число сотрудников (рассчитывается как среднее арифметическое численности персонала на начало и на конец отчетного периода)"
        );
        HBox hBox = new HBox(10);
        Text t1 = textBuild("Кпк = (");
        TextField chy = textFieldBuild("", "Чу");
        Text t2 = textBuild(":");
        TextField chs = textFieldBuild("", "Чс");
        Text t3 = textBuild(") X 100 =");
        hBox.getChildren().addAll(t1, chy, t2, chs, t3, out);
        score.setOnMouseClicked(event -> {
            double dchp = expression("(" + chy.getText() + ")"),
                    dchy = expression("(" + chs.getText() + ")");
            out.setText(String.valueOf((dchp / dchy) * 100));
        });
        vBox.getChildren().addAll(hBox, inf);
    }

    private void all() {
        out = textBuild("");
        HBox hBox = new HBox(10);

        TextArea inf = textAreaBuild(""
        );
        TextField all = new TextField();
        hBox.setHgrow(all, Priority.ALWAYS);
        all.maxWidth(Double.MAX_VALUE);
        all.setMaxWidth(Double.MAX_VALUE);
        all.prefWidth(Double.MAX_VALUE);
        all.setPromptText("Введите уровнение пример ((1 + 2)*5  - 15 * 8)*7 + 12*(34 - 4)/(7 + 8)");
        Text t1 = textBuild("=");
        hBox.getChildren().addAll(all, t1, out);
        vBox.getChildren().addAll(hBox, inf);
        score.setOnMouseClicked(event -> {

            out.setText(String.valueOf(expression(all.getText().replace(":", "/"))));
            inf.setText(inf.getText() + "\n" + out.getText() + ")");

        });
    }

    /**
     * Коэффициент стабильности кадров показывает долю сотрудников, проработавших в организации как минимум год,
     * дает возможность оценить степень сохранения организацией квалифицированного персонала
     * Кст = (Чр : Чоб) × 100 Где:
     * Кст – коэффициент стабильности персонала (в процентах);
     * Чр – число сотрудников, работающих в организации с начала отчетного периода;
     * Чоб – общая численность сотрудников на начало отчетного периода
     * В организации «Альфа» работают 2000 сотрудников. В 2012 году по собственному желанию уволились 116 сотрудников и
     * 20 были уволены по инициативе администрации. Кст = (2000 – 116 – 20) : 2000 × 100 = 94%"
     */
    private void Kct() {
        out = textBuild("");
        HBox hBox = new HBox(10);
        TextArea inf = textAreaBuild("Коэффициент стабильности кадров показывает долю сотрудников, проработавших в организации как минимум год," +
                "дает возможность оценить степень сохранения организацией квалифицированного персонала\n" +
                "Кст = (Чр : Чоб) × 100 Где: \n" +
                "Кст – коэффициент стабильности персонала (в процентах); \n" +
                "Чр – число сотрудников, работающих в организации с начала отчетного периода; \n" +
                "Чоб – общая численность сотрудников на начало отчетного периода\n" +
                "В организации «Альфа» работают 2000 сотрудников. В 2012 году по собственному желанию уволились 116 сотрудников и " +
                "20 были уволены по инициативе администрации.\n" +
                "Кст = (2000 – 116 – 20) : 2000 × 100 = 94%"
        );
        Text t1 = textBuild("Кст = (");
        TextField chr = textFieldBuild("", "Чр");
        Text t2 = textBuild(":");
        TextField chob = textFieldBuild("", "Чоб");
        Text t3 = textBuild(") X 100 =");
        hBox.getChildren().addAll(t1, chr, t2, chob, t3, out);
        vBox.getChildren().addAll(hBox, inf);
        score.setOnMouseClicked(event -> {

            double dChr = expression("(" + chr.getText() + ")"),
                    dChob = expression("(" + chob.getText() + ")");
            out.setText((dChr / dChob) * 100 + "");

        });

    }

    /**
     * Коэффициент текучести кадров дает общее представление о количестве увольнений за определенный период
     * Кт = (Чусж + Чуиа) : Чс × 100 Где:
     * Кт – коэффициент текучести (в процентах);
     * Чусж – число сотрудников, уволившихся по собственному желанию за определенный период;
     * Чуиа – число сотрудников, уволенных по инициативе администрации за определенный период;
     * Чс – среднесписочное число сотрудников (рассчитывается как среднее арифметическое численности персонала на начало и на конец отчетного периода)
     * пример
     * В организации «Альфа» работают 2000 сотрудников. В 2012 году по собственному желанию уволились 116 сотрудников и 20 были уволены по инициативе администрации.
     * В течение года были приняты на работу 60 новых сотрудников. Чс = (2000 + (2000 – 116 – 20 + 60)) : 2 = 1962 чел. Кт = ((116 + 20) : 1962) × 100 = 6,9%
     */

    void Kt() {

        out = textBuild("");
        HBox hBox = new HBox(10);
        TextArea inf = textAreaBuild("Коэффициент текучести кадров дает общее представление о количестве увольнений за определенный период\n" +
                "Кт = (Чусж + Чуиа) : Чс × 100 Где:\n" +
                "Кт – коэффициент текучести (в процентах);\n" +
                "Чусж – число сотрудников, уволившихся по собственному желанию за определенный период;\n" +
                "Чуиа – число сотрудников, уволенных по инициативе администрации за определенный период;\n" +
                "Чс – среднесписочное число сотрудников (рассчитывается как среднее арифметическое " +
                "численности персонала на начало и на конец отчетного периода) пример\n" +
                "В организации «Альфа» работают 2000 сотрудников. В 2012 году по собственному желанию уволились 116 " +
                "сотрудников и 20 были уволены по инициативе администрации.\n" +
                "В течение года были приняты на работу 60 новых сотрудников. Чс = (2000 + (2000 – 116 – 20 + 60)) : 2 =" +
                "1962 чел. Кт = ((116 + 20) : 1962) × 100 = 6,9%"
        );
        Text t1 = textBuild("Кт = (");
        TextField chusah = textFieldBuild("", "Чусж");
        Text t2 = textBuild("+");
        TextField chusa = textFieldBuild("", "Чуиа");
        Text t3 = textBuild(") :");


        TextField chs = textFieldBuild("", "Чс");
        Text t4 = textBuild("X 100 =");
        score.setOnMouseClicked(event -> {


            try {
                double dChusah = expression("(" + chusah.getText() + ")"),
                        dChusa = expression("(" + chusa.getText() + ")"),
                        dChs = expression("(" + chs.getText() + ")");
                double d = (dChusah + dChusa) / dChs * 100;
                out.setText("" + d);
            } catch (NumberFormatException NFE) {
                new Notification("Уведомление", "Заполниет все поля");
            }


        });
        hBox.getChildren().addAll(t1, chusah, t2, chusa, t3, chs, t4, out);
        vBox.getChildren().addAll(hBox, inf);


    }

    private TextArea textAreaBuild(String value) {
        TextArea textArea = new TextArea(value);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        return textArea;
    }

    private TextField textFieldBuild(String value, String promptText) {
        TextField textField = new TextField(value);
        textField.setPromptText(promptText);
        VBox.setVgrow(textField, Priority.ALWAYS);
        //textField.setId("text");
        textProperty(textField);
        return textField;
    }

    private Text textBuild(String value) {
        Text text = new Text(value);
        text.setId("text");

        return text;
    }


    private void textProperty(TextField textField) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("[\\d*,.()*/+-:]")) {
                    textField.setText(newValue.replaceAll("[^\\d,.*/+()-:]", ""));
                }
            }
        });
    }

}

class RegularExpressions {
    public static double expression(TextField TFstr) {
        String str = TFstr.getText();
        //Удаляем внешние пробелы. Из-за рекурсии удаляются все пробелы, кроме таких "5 5+7"
        str = str.trim();
        // кривой способ удаления всех внешних скобок
        while ((str = removeOuterBrackets(str)) != removeOuterBrackets(str)) ;
        //конец рекурсии, если блок содержит только число
        if (isNumber(str)) {
            return Double.parseDouble(str);
        }


        //вызываем метод, который делит строку на два блока, делает  вызов expression() внутри и так пока не наткнемся на блок, состоящий только из числа
        return splicing(str);
    }

    public static double expression(String str) {
        //Удаляем внешние пробелы. Из-за рекурсии удаляются все пробелы, кроме таких "5 5+7"
        str = str.trim();
        // кривой способ удаления всех внешних скобок
        while ((str = removeOuterBrackets(str)) != removeOuterBrackets(str)) ;
        //конец рекурсии, если блок содержит только число
        if (isNumber(str)) {
            return Double.parseDouble(str);
        }


        //вызываем метод, который делит строку на два блока, делает  вызов expression() внутри и так пока не наткнемся на блок, состоящий только из числа
        return splicing(str);
    }

    public static double splicing(String str) {
        //ищем точку для разделения строки на два блока
        int splice = findSplice(str);
        String block1, block2;
        block1 = str.substring(0, splice);
        block2 = str.substring(splice + 1);

        //тут происходит вызов expression() и так будет происходить, пока мы не получим только число в блоке
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
            for (int i = 1; i < str.length() - 1; i++) {
                switch (str.charAt(i)) {
                    case '(':
                        count++;
                        break;
                    case ')':
                        count--;
                        break;
                }
                if (count < 0) {
                    return str; //возвращаем исходную строку, т.к. нечго удалять
                }
            }
            if (count != 0) {

                throw new IllegalArgumentException("Brakets! (()");
            }
            return str.substring(1, str.length() - 1); //возвращаем строку без одних внешних скобок
        }
        return str; //никогда сюда не попадем
    }

    public static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException e) {
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
            count = getCount(str, count, i);
            if (count == 0 &&
                    (str.charAt(i) == '+' || str.charAt(i) == '-')) {
                return i;
            }
        }
        count = 0;
        for (int i = 0; i < str.length(); i++) {
            count = getCount(str, count, i);
            if (count == 0 &&
                    (str.charAt(i) == '*' || str.charAt(i) == '/')) {
                //TODO вызов метода для конвертации строки 1/7/5*2 -> 1*2/(7*5)
                //а лучше вообще переписать findSplice и removeOuterBrackets, много повторяющегося кода
                return i;
            }
        }
        if (count != 0) {

            throw new IllegalArgumentException("Brakets! (()");
        } else if (count == 0) {

            throw new IllegalArgumentException("symbols||spaces between numbers||double operators|| *) /) (+ etc");
        }
        return 0; //никогда сюда не попадем
    }

    private static int getCount(String str, int count, int i) {
        switch (str.charAt(i)) {
            case '(':
                count++;
                break;
            case ')':
                count--;
                break;
        }
        if (count < 0) {

            throw new IllegalArgumentException("Brackets! )(");
        }
        return count;
    }

    public static int convert(String str) {
        //TODO конвертация строки 1/7/5*2 -> 1*2/(7*5)
        return 0;
    }
}