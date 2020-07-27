package org.example;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Scanner;

public class TaxOffice {

    static Map<User, List<Fine>> userListMap = new TreeMap<>();
    static String individualTaxNumber;
    static String status;
    static String firstName;
    static String lastName;
    static String cityOfResidence;
    static String typeOfFine;
    static String penaltyAmount;
    static String fineDescription;
    Scanner scanner = new Scanner(System.in);


    public void addTaxBase() {
        String filename = "TaxOfficeDatabase.dat";
        File file = new File(filename);
        if (file.exists()) {
            userListMap = readObject(filename);
        }
        do {

            MethodZero methodZero = new MethodZero();
            Menu menu = new Menu("База данных налоговой инспекции", methodZero);


            Method methodSubMenu1 = new Method();
            Menu subMenu1 = new Menu("Добавить нового налогоплательщика в базу", methodSubMenu1);
            menu.addSabMenu(subMenu1);


            MethodZero methodZero1 = new MethodZero();
            Menu menu2 = new Menu("Корректировать информацию о налогоплательщике и его штрафах", methodZero1);
            menu.addSabMenu(menu2);

            MethodMenu2Submenu1 methodMenu2Submenu1 = new MethodMenu2Submenu1();
            Menu menu2Submenu1 = new Menu("Изменить имя", methodMenu2Submenu1);
            menu2.addSabMenu(menu2Submenu1);

            MethodMenu2Submenu2 methodMenu2Submenu2 = new MethodMenu2Submenu2();
            Menu menu2Submenu2 = new Menu("Изменить фамилию", methodMenu2Submenu2);
            menu2.addSabMenu(menu2Submenu2);

            MethodMenu2Submenu3 methodMenu2Submenu3 = new MethodMenu2Submenu3();
            Menu menu2Submenu3 = new Menu("Изменить ИНН", methodMenu2Submenu3);
            menu2.addSabMenu(menu2Submenu3);

            MethodMenu2Submenu4 methodMenu2Submenu4 = new MethodMenu2Submenu4();
            Menu menu2Submenu4 = new Menu("Изменить город проживания", methodMenu2Submenu4);
            menu2.addSabMenu(menu2Submenu4);

            MethodMenu2Submenu5 methodMenu2Submenu5 = new MethodMenu2Submenu5();
            Menu menu2Submenu5 = new Menu("Изменить информацию о штрафах", methodMenu2Submenu5);
            menu2.addSabMenu(menu2Submenu5);


            MethodSubMenu3 methodSubMenu3 = new MethodSubMenu3();
            Menu subMenu3 = new Menu("Добавить штраф", methodSubMenu3);
            menu.addSabMenu(subMenu3);

            MethodSubMenu4 methodSubMenu4 = new MethodSubMenu4();
            Menu subMenu4 = new Menu("Удалить штраф", methodSubMenu4);
            menu.addSabMenu(subMenu4);

            MethodSubMenu5 methodSubMenu5 = new MethodSubMenu5();
            Menu subMenu5 = new Menu("Полная распечатка базы данных", methodSubMenu5);
            menu.addSabMenu(subMenu5);

            MethodSubMenu6 methodSubMenu6 = new MethodSubMenu6();
            Menu subMenu6 = new Menu("Распечатать базу данных по ИНН", methodSubMenu6);
            menu.addSabMenu(subMenu6);

            MethodSubMenu7 methodSubMenu7 = new MethodSubMenu7();
            Menu subMenu7 = new Menu("Распечатать базу данных по типу штрафа", methodSubMenu7);
            menu.addSabMenu(subMenu7);

            MethodSubMenu8 methodSubMenu8 = new MethodSubMenu8();
            Menu subMenu8 = new Menu("Распечатать базу данных по городу", methodSubMenu8);
            menu.addSabMenu(subMenu8);

            menu.print();
            System.out.println("Выберете действие");
            System.out.println("exit -  выход");
            TaxOffice.status = scanner.nextLine();
            switch (status){
                case "1" :
                    subMenu1.make();
                    break;
                case "2":
                    do {
                        menu2.print();
                        System.out.println("exit - выход");
                        status = scanner.nextLine();
                        switch (status) {
                            case "1":
                                menu2Submenu1.make();
                                break;
                            case "2":
                                menu2Submenu2.make();
                                break;
                            case "3":
                                menu2Submenu3.make();
                                break;
                            case "4":
                                menu2Submenu4.make();
                                break;
                            case "5":
                                menu2Submenu5.make();
                        }
                    } while ((!"exit".equals(status)));
                    status = null;
                    break;
                case "3":
                    subMenu3.make();
                    break;
                case "4":
                    subMenu4.make();
                    break;
                case "5":
                    subMenu5.make();
                    break;
                case "6":
                    subMenu6.make();
                    break;
                case "7":
                    subMenu7.make();
                    break;
                case"8":
                    subMenu8.make();
                    break;
            }

        } while (!("exit".equals(TaxOffice.status)));


        saveObject(userListMap, "TaxOfficeDatabase.dat");
    }

    public static boolean isPresent(Map<User, List<Fine>> userListMap) {
        boolean isPresent = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ИНН налогоплательщика");
        individualTaxNumber = scanner.nextLine();
        for (Map.Entry<User, List<Fine>> e : userListMap.entrySet()) {
            if (e.getKey().getIndividualTaxNumber().equals(individualTaxNumber)) {
                isPresent = false;
                System.out.println("Такой ИНН уже зарегистрирован ");
            }
        }
        return isPresent;
    }

    private static void saveObject(Map<User, List<Fine>> userListMap, String filename) {
        try (ObjectOutput output = new ObjectOutputStream(new FileOutputStream(filename))) {
            output.writeObject(userListMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<User, List<Fine>> readObject(String filename) {
        Map<User, List<Fine>> userListMap = null;
        try (ObjectInput input = new ObjectInputStream(new FileInputStream(filename))) {
            userListMap = (Map<User, List<Fine>>) input.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return userListMap;
    }

    public static boolean isPresentAvt(Map<User, List<Fine>> userListMap) {
        boolean isPresent = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ИНН налогоплательщика");
        individualTaxNumber = scanner.nextLine();
        for (Map.Entry<User, List<Fine>> e : userListMap.entrySet()) {
            if (e.getKey().getIndividualTaxNumber().equals(individualTaxNumber)) {
                isPresent = true;
            }
        }
        if (!isPresent) {
            System.out.println("Такого ИНН в Базе нет !");
        }
        return isPresent;
    }

    public static void typeOfTax() {
        System.out.println("Выберете категорию штрафа ");
        System.out.println("1 - Штрафные санкции за неуплату или несвоевременную уплату единого" +
                " социального взноса (ЕСВ) и неподачу отчетности");
        System.out.println("2 - Штрафные санкции за непредоставление отчетности");
        System.out.println("3 - Штрафные санкции за неуплату или несвоевременную уплату" +
                " налоговых обязательств");
        System.out.println("4 - Штрафные санкции за занижение налоговых обязательств, выявленное в результате проверок");
        System.out.println("5 - Штрафные санкции за неведение, ненадлежащее ведение, потерю или ведение" +
                " незарегистрированной книги учета доходов предпринимателем"
        );
        System.out.println("6 - Штрафные санкции за вовлечение в деятельность неоформленного работника, за" +
                " невыплату заработной платы, невыплату в полном объеме"
        );
        System.out.println("7 - Штрафные санкции за неоприходование наличности в кассу");
        System.out.println("8 - Штрафные санкции за получение дохода за деятельность не указанную" +
                " в свидетельстве единого налога"
        );
        System.out.println("9 - Штрафные санкции за нарушение условий пребывания на едином налоге"
        );
    }

    public static String typeOfFineMethod(String typeOfFine) {
        switch (typeOfFine) {
            case "1":
                typeOfFine = "Штрафные санкции за неуплату или несвоевременную уплату единого социального взноса (ЕСВ) и неподачу отчетности";
                break;
            case "2":
                typeOfFine = "Штрафные санкции за непредоставление отчетности";
                break;
            case "3":
                typeOfFine = "Штрафные санкции за неуплату или несвоевременную уплату налоговых обязательств";
                break;
            case "4":
                typeOfFine = "Штрафные санкции за занижение налоговых обязательств, выявленное в результате проверок";
                break;
            case "5":
                typeOfFine = "Штрафные санкции за неведение, ненадлежащее ведение, потерю или ведение незарегистрированной книги учета доходов предпринимателем";
                break;
            case "6":
                typeOfFine = "Штрафные санкции за вовлечение в деятельность неоформленного работника, за невыплату заработной платы, невыплату в полном объеме";
                break;
            case "7":
                typeOfFine = "Штрафные санкции за неоприходование наличности в кассу";
                break;
            case "8":
                typeOfFine = "Штрафные санкции за получение дохода за деятельность не указанную в свидетельстве единого налога";
                break;
            case "9":
                typeOfFine = "Штрафные санкции за нарушение условий пребывания на едином налоге";
                break;
            default:
                System.out.println("Введите правильный номер категории штрафа");

        }
        return typeOfFine;
    }

    public static boolean isPresentP(Map<User, List<Fine>> userListMap, String inn) {
        boolean isPresent = false;
        individualTaxNumber = inn;
        for (Map.Entry<User, List<Fine>> e : userListMap.entrySet()) {
            if (e.getKey().getIndividualTaxNumber().equals(individualTaxNumber)) {
                isPresent = true;
            }
        }
        System.out.println("Такого ИНН в Базе нет !");
        return isPresent;
    }
}
