package ru.sbtqa.tag.pagefactory.web.utils;

import io.qameta.allure.Allure;
import ru.sbtqa.tag.datajack.Stash;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Converter {
    public DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

    final String lexicon = "АБВгдкежзиклморствгудосмитбюяу";
    final String englishlexicon = "AbscdFjhkrijfn38439dofskbdwllnmlpoiuyttew0qsdqazxc";

    final Random rand = new Random();

    // consider using a Map<String,Boolean> to say whether the identifier is being used or not
    final Set<String> identifiers = new HashSet<String>();
    String lastTelNumber = "6";

    public String randomIdentifier() {
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(5) + 5;
            for (int i = 0; i < length; i++) {
                builder.append(lexicon.charAt(rand.nextInt(lexicon.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    public String randomEnglishIdentifier() {
        StringBuilder builder = new StringBuilder();
        while (builder.toString().length() == 0) {
            int length = rand.nextInt(15) + 15;
            for (int i = 0; i < length; i++) {
                builder.append(englishlexicon.charAt(rand.nextInt(englishlexicon.length())));
            }
            if (identifiers.contains(builder.toString())) {
                builder = new StringBuilder();
            }
        }
        return builder.toString();
    }

    public String transform(String value) {
        timeFormat.setTimeZone(TimeZone.getTimeZone("GMT+3"));
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+3"));
        Date date;

        if (Stash.asMap().containsKey(value)) {
            return Stash.getValue(value);
        }
        if (value.contains("текущее время плюс")) {
            String time = timeFormat.format(addMinutes(Integer.parseInt(value.replaceAll("[^0-9-]", ""))));
            System.out.println("было задано время " + time);
            return time;
        }

        if (value.contains("случайный номер телефона") && (!value.equals("случайный номер телефона"))&& (!value.equals("случайный номер телефона для пега")))
        {
            lastTelNumber = value.replace("случайный номер телефона", "");
            value = "случайный номер телефона";
        }

        switch (value) {
            case "сегодня":
                date = new Date();
                return dateFormat.format(date);
            case "вчера":
                return dateFormat.format(yesterday());
            case "завтра":
                return dateFormat.format(tomorrow());
            case "назад44":
                return dateFormat.format(before44());
            case "назад45":
                return dateFormat.format(before45());
            case "назад46":
                return dateFormat.format(before46());
            case "случайное число":
                return String.valueOf(ThreadLocalRandom.current().nextInt(111, 999999999));
            case "случайная сумма":
                return String.valueOf(ThreadLocalRandom.current().nextInt(111111, 999999));
            case "случайная большая сумма":
                return String.valueOf(ThreadLocalRandom.current().nextInt(1000000, 50000000));
            case "случайная маленькая сумма":
                return String.valueOf(ThreadLocalRandom.current().nextInt(1, 10));
            case "случайнаясумма":
                return String.valueOf(ThreadLocalRandom.current().nextInt(1, 50000));
            case "случайнаябольшаясумма":
                return String.valueOf(ThreadLocalRandom.current().nextInt(1000000, 50000000));
            case "случайнаямаленькаясумма":
                return String.valueOf(ThreadLocalRandom.current().nextInt(1, 10));
            case "случайный номер телефона":
                String telNumber = "926" + String.valueOf(ThreadLocalRandom.current().nextInt(111111, 999999)) + lastTelNumber;
                System.out.println("телефонный номер " + telNumber);
                return telNumber;
            case "случайный телефон семь-семь":
                String telNumber1 = "926" + String.valueOf(ThreadLocalRandom.current().nextInt(11111, 99999)) + "77";
                System.out.println("телефонный номер " + telNumber1);
                return telNumber1;
            case "случайныйномертелефона":
                String telNumber2 = "926" + String.valueOf(ThreadLocalRandom.current().nextInt(1111111, 9999999));
                System.out.println("телефонный номер" + telNumber2);
                return telNumber2;
            case "случайный номер телефона для пега":
                String telNumber4 = getRndTelPrefix() + String.valueOf(ThreadLocalRandom.current().nextInt(1111, 9999)) + "222";
                System.out.println("телефонный номер " + telNumber4);
                return telNumber4;
            case "случайныйномертелефонадляпега":
                String telNumber5 = getRndTelPrefix() + String.valueOf(ThreadLocalRandom.current().nextInt(1111, 9999)) + "222";
                System.out.println("телефонный номер " + telNumber5);
                return telNumber5;
            case "случайный номер паспорта":
                String number = String.valueOf(ThreadLocalRandom.current().nextInt(1111, 9999)) + " " + String.valueOf(ThreadLocalRandom.current().nextInt(111111, 999999));
                System.out.println(number);
                return number;
            case "случайная почта":
                String email = String.valueOf(ThreadLocalRandom.current().nextInt(111111, 999999)) + "partnerIC@mailinator.com";
                System.out.println(email);
                Allure.addAttachment("почта", email);
                return email;
            case "случайныйномерпаспорта":
                String number2 = String.valueOf(ThreadLocalRandom.current().nextInt(1111, 9999)) + " " + String.valueOf(ThreadLocalRandom.current().nextInt(111111, 999999));
                System.out.println(number2);
                return number2;
            case "случайный номер паспорта04":
                String number3 = String.valueOf(ThreadLocalRandom.current().nextInt(11, 99)) + "04 " + String.valueOf(ThreadLocalRandom.current().nextInt(111111, 999999));
                System.out.println(number3);
                return number3;
            case "случайныйномерпаспорта04":
                String number4 = String.valueOf(ThreadLocalRandom.current().nextInt(11, 99)) + "04 " + String.valueOf(ThreadLocalRandom.current().nextInt(111111, 999999));
                System.out.println(number4);
                return number4;
            case "случайный номер паспорта09":
                String number5 = String.valueOf(ThreadLocalRandom.current().nextInt(11, 99)) + "09 " + String.valueOf(ThreadLocalRandom.current().nextInt(111111, 999999));
                System.out.println(number5);
                return number5;
            case "случайныйномерпаспорта09":
                String number6 = String.valueOf(ThreadLocalRandom.current().nextInt(11, 99)) + "09 " + String.valueOf(ThreadLocalRandom.current().nextInt(111111, 999999));
                System.out.println(number6);
                return number6;
            case "случайный номер паспорта16":
                String number7 = String.valueOf(ThreadLocalRandom.current().nextInt(11, 99)) + "16 " + String.valueOf(ThreadLocalRandom.current().nextInt(111111, 999999));
                System.out.println(number7);
                return number7;
            case "случайныйномерпаспорта16":
                String number8 = String.valueOf(ThreadLocalRandom.current().nextInt(11, 99)) + "16 " + String.valueOf(ThreadLocalRandom.current().nextInt(111111, 999999));
                System.out.println(number8);
                return number8;
            case "случайная фамилия":
                String last_name = randomIdentifier().substring(0,4);
                System.out.println(last_name);
                return last_name;
            case "случайнаяфамилия":
                String last_name2 = randomIdentifier().substring(0,4);
                System.out.println(last_name2);
                return last_name2;
            case "случайное имя":
                String name = randomIdentifier().substring(0,4);
                System.out.println(name);
                return name;
            case "случайноеимя":
                String name2 = randomIdentifier().substring(0,4);
                System.out.println(name2);
                return name2;
            case "случайное английское значение":
                String name5 = randomEnglishIdentifier();
                System.out.println(name5);
                return name5;
            case "случайная небюджетная организация":
                String name6 = getRndnotBudgetOrg ();
                System.out.println(name6);
                return name6.replace("'", "\"");
            case "случайная бюджетная организация":
                String name7 = getRndBudgetOrg();
                System.out.println(name7);
                return name7.replace("'", "\"");
            case "пусто":
                return "";
            default:
                return value.replace("'", "\"");
        }
    }

    private String getRndTelPrefix (){
        String[] list = {"910", "915", "916", "917", "985", "964", "936", "929", "925", "965", "966", "967", "968", "969", "936", "980", "983", "986", "958", "977"};
        Random r = new Random();
        return list[r.nextInt(list.length)];
    }

    private String getRndnotBudgetOrg (){
        String[] list = {"ООО '100М3'", "ППО РОСПРОФЖЕЛ ООО 'ЛОКОТЕХ-СЕРВИС'", "ООО 'ЛМ-ФУД' ФИЛИАЛ В СВЕРДЛОВСКОЙ ОБЛАСТИ"};
        Random r = new Random();
        return list[r.nextInt(list.length)];
    }

    private String getRndBudgetOrg (){
        String[] list = {"ПЕРВИЧНАЯ ПРОФСОЮЗНАЯ ОБЩЕСТВЕННАЯ ОРГАНИЗАЦИЯ ФГУП 'ГОСНИИАС'; ППОО ФГУП 'ГОСНИИАС'"};
        Random r = new Random();
        return list[r.nextInt(list.length)];
    }

    private Date addMinutes(int val) {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, val);
        return cal.getTime();
    }

    public String addHours(String myTime, int hours) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date d = df.parse(myTime);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.HOUR, hours);
        String newTime = df.format(cal.getTime());
        return newTime;
    }

    private Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    private Date before44() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -44);
        return cal.getTime();
    }

    private Date before45() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -45);
        return cal.getTime();
    }

    private Date before46() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -46);
        return cal.getTime();
    }

    private Date tomorrow() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +1);
        return cal.getTime();
    }

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        if (str.isEmpty()) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (str.length() == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
