package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Method implements MakeInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void doIt() {
        if (TaxOffice.isPresent(TaxOffice.userListMap)) {
            System.out.println("Введите имя налогоплательщика");
            TaxOffice.firstName = scanner.nextLine();
            System.out.println("Введите фамилию налогоплательщика");
            TaxOffice.lastName = scanner.nextLine();
            System.out.println("Введите город проживания налогоплательщика");
            TaxOffice.cityOfResidence = scanner.nextLine();
            User user1 = new User(TaxOffice.firstName, TaxOffice.lastName, TaxOffice.individualTaxNumber, TaxOffice.cityOfResidence);
            TaxOffice.userListMap.put(user1, new ArrayList<>());
            System.out.println("Налогоплательщик успешно добавлен !");
        }
    }
}

class MethodSubMenu3 implements MakeInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void doIt() {
        int tmp = 0;
        if (TaxOffice.isPresentAvt(TaxOffice.userListMap)) {
            for (Map.Entry<User, List<Fine>> e : TaxOffice.userListMap.entrySet()) {
                if ((e.getKey().getIndividualTaxNumber().equals(TaxOffice.individualTaxNumber))) {
                    TaxOffice.typeOfTax();
                    TaxOffice.typeOfFine = scanner.nextLine();
                    String tmp1 = TaxOffice.typeOfFineMethod(TaxOffice.typeOfFine);
                    System.out.println("Введите описание штрафа");
                    TaxOffice.fineDescription = scanner.nextLine();
                    System.out.println("Введите сумму штрафа в гривнах");
                    do {
                        try {
                            TaxOffice.penaltyAmount = scanner.nextLine();
                            tmp = Integer.parseInt(TaxOffice.penaltyAmount);
                            break;
                        } catch (Exception ex) {
                            System.out.println("Введите правильно число ");
                        }
                    } while (true);


                    Fine fine = new Fine(TaxOffice.fineDescription, tmp, tmp1);
                    e.getValue().add(fine);
                }
            }
        }
    }
}

class MethodSubMenu4 implements MakeInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void doIt() {
        if (TaxOffice.isPresentAvt(TaxOffice.userListMap)) {
            for (Map.Entry<User, List<Fine>> e : TaxOffice.userListMap.entrySet()) {
                if ((e.getKey().getIndividualTaxNumber().equals(TaxOffice.individualTaxNumber))) {
                    List<Fine> fineList1 = new ArrayList<>(e.getValue());
                    for (int i = 0; i < fineList1.size(); i++) {
                        System.out.println("Н/пп : " + (i + 1) + " " + "Категория штрафа :");
                        System.out.println(fineList1.get(i).getTypeOfFine());
                        System.out.println("Описание штрафа :");
                        System.out.println(fineList1.get(i).getFineDescription());
                        System.out.println("Сумма штрафа :");
                        System.out.println(fineList1.get(i).getPenaltyAmount() + " " + " грн");
                    }
                    String namberTax;
                    do {
                        System.out.println("Введите номер штрафа который нужно удалить");
                        System.out.println("esc - выход");
                        namberTax = scanner.nextLine();
                        if ((!"esc".equals(namberTax))) {
                            int tnp1 = Integer.parseInt(namberTax);
                            if (tnp1 <= fineList1.size()) {
                                e.getValue().remove(tnp1 - 1);
                                System.out.println("Штраф успешно удален");
                                break;
                            }
                            System.out.println("Штраф под таким номером не существует");
                        }
                    } while ((!"esc".equals(namberTax)));

                }

            }
        }
    }
}

class MethodSubMenu5 implements MakeInterface {

    @Override
    public void doIt() {
        for (Map.Entry<User, List<Fine>> e : TaxOffice.userListMap.entrySet()) {
            System.out.println("ИНН налогоплательщика :");
            System.out.println(e.getKey().getIndividualTaxNumber());
            System.out.println("ФИО : " + e.getKey().getLastName() + " " + e.getKey().getFirstName());
            List<Fine> fineList = new ArrayList<>(e.getValue());
            System.out.println("Штрафы :");
            for (int i = 0; i < fineList.size(); i++) {
                System.out.println("Н/пп : " + (i + 1) + " " + "Категория штрафа :");
                System.out.println(fineList.get(i).getTypeOfFine());
                System.out.println("Описание штрафа :");
                System.out.println(fineList.get(i).getFineDescription());
                System.out.println("Сумма штрафа :");
                System.out.println(fineList.get(i).getPenaltyAmount() + " " + " грн");

            }

        }
    }
}

class MethodSubMenu6 implements MakeInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void doIt() {
        System.out.println("Введите ИНН :");
        String tmp = scanner.nextLine();
        if (TaxOffice.isPresentP(TaxOffice.userListMap, tmp)) {
            for (Map.Entry<User, List<Fine>> e : TaxOffice.userListMap.entrySet()) {
                if (e.getKey().getIndividualTaxNumber().equals(tmp)) {
                    System.out.println("ИНН : " + e.getKey().getIndividualTaxNumber());
                    System.out.println("ФИО : " + e.getKey().getFirstName() + " " + e.getKey().getLastName());
                    System.out.println("Город проживания : " + e.getKey().getCityOfResidence());
                    List<Fine> fineList = new ArrayList<>(e.getValue());
                    for (int i = 0; i < fineList.size(); i++) {
                        System.out.println("Н/пп : " + (i + 1) + " " + "Категория штрафа :");
                        System.out.println(fineList.get(i).getTypeOfFine());
                        System.out.println("Описание штрафа :");
                        System.out.println(fineList.get(i).getFineDescription());
                        System.out.println("Сумма штрафа :");
                        System.out.println(fineList.get(i).getPenaltyAmount() + " " + " грн");

                    }
                }
            }
        }
    }
}

class MethodSubMenu7 implements MakeInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void doIt() {
        TaxOffice.typeOfTax();
        TaxOffice.typeOfFine = scanner.nextLine();
        for (Map.Entry<User, List<Fine>> e : TaxOffice.userListMap.entrySet()) {
            List<Fine> fines = new ArrayList<>(e.getValue());
            for (int i = 0; i < fines.size(); i++) {
                if (fines.get(i).getTypeOfFine().equals(TaxOffice.typeOfFineMethod(TaxOffice.typeOfFine))) {
                    System.out.println("ИНН : " + e.getKey().getIndividualTaxNumber());
                    System.out.println("ФИО :  " + e.getKey().getFirstName() + " " + e.getKey().getLastName());
                    System.out.println("Сумма штрафа : " + fines.get(i).getPenaltyAmount());
                }
            }

        }
    }
}

class MethodSubMenu8 implements MakeInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void doIt() {
        List<Fine> fines;
        boolean townSatus = false;
        boolean fineStatus = false;
        System.out.println("Введите название города");
        String town = scanner.nextLine();
        for (Map.Entry<User, List<Fine>> e : TaxOffice.userListMap.entrySet()) {
            if (e.getKey().getCityOfResidence().equals(town)) {
                fines = e.getValue();
                fineStatus = true;
                for (int i = 0; i < fines.size(); i++) {
                    System.out.println("ИНН : " + e.getKey().getIndividualTaxNumber());
                    System.out.println("ФИО :  " + e.getKey().getFirstName() + " " + e.getKey().getLastName());
                    System.out.println("Сумма штрафа : " + fines.get(i).getPenaltyAmount());
                    townSatus = true;
                }
            }
        }
        if (!townSatus && !fineStatus) {
            System.out.println("Такого города в базе данных нет !");
        }
        if ((!townSatus) && fineStatus) {
            System.out.println("Штрафов по данному городу нет !!");

        }
    }
}

class MethodMenu2Submenu1 implements MakeInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void doIt() {
        if (TaxOffice.isPresentAvt(TaxOffice.userListMap)) {
            for (Map.Entry<User, List<Fine>> e : TaxOffice.userListMap.entrySet()) {
                if ((e.getKey().getIndividualTaxNumber().equals(TaxOffice.individualTaxNumber))) {
                    System.out.println("Введите новое имя");
                    String name = scanner.nextLine();
                    e.getKey().setFirstName(name);
                    System.out.println("Имя успешно измененно !");

                }
            }

        }

    }
}

class MethodMenu2Submenu2 implements MakeInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void doIt() {
        if (TaxOffice.isPresentAvt(TaxOffice.userListMap)) {
            for (Map.Entry<User, List<Fine>> e : TaxOffice.userListMap.entrySet()) {
                if ((e.getKey().getIndividualTaxNumber().equals(TaxOffice.individualTaxNumber))) {
                    System.out.println("Введите новую фамилию");
                    String last = scanner.nextLine();
                    e.getKey().setLastName(last);
                    System.out.println("Фамилия успешно измененна !");
                }
            }
        }
    }
}

class MethodMenu2Submenu3 implements MakeInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void doIt() {
        if (TaxOffice.isPresentAvt(TaxOffice.userListMap)) {
            for (Map.Entry<User, List<Fine>> e : TaxOffice.userListMap.entrySet()) {
                if ((e.getKey().getIndividualTaxNumber().equals(TaxOffice.individualTaxNumber))) {
                    System.out.println("Введите новый ИНН");
                    String inn = scanner.nextLine();
                    e.getKey().setIndividualTaxNumber(inn);
                    System.out.println("ИНН успешно изменен !");
                }
            }
        }
    }
}

class MethodMenu2Submenu4 implements MakeInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void doIt() {
        if (TaxOffice.isPresentAvt(TaxOffice.userListMap)) {
            for (Map.Entry<User, List<Fine>> e : TaxOffice.userListMap.entrySet()) {
                if ((e.getKey().getIndividualTaxNumber().equals(TaxOffice.individualTaxNumber))) {
                    System.out.println("Введите новый город проживания");
                    String town = scanner.nextLine();
                    e.getKey().setCityOfResidence(town);
                    System.out.println("Город проживания успешно изменнен !");
                }
            }
        }
    }
}

class MethodMenu2Submenu5 implements MakeInterface {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void doIt() {
        if (TaxOffice.isPresentAvt(TaxOffice.userListMap)) {
            for (Map.Entry<User, List<Fine>> e : TaxOffice.userListMap.entrySet()) {
                if ((e.getKey().getIndividualTaxNumber().equals(TaxOffice.individualTaxNumber))) {

                    List<Fine> fineList1 = new ArrayList<>(e.getValue());
                    for (int i = 0; i < fineList1.size(); i++) {
                        System.out.println("Н/пп : " + (i + 1) + " " + "Категория штрафа :");
                        System.out.println(fineList1.get(i).getTypeOfFine());
                        System.out.println("Описание штрафа :");
                        System.out.println(fineList1.get(i).getFineDescription());
                        System.out.println("Сумма штрафа :");
                        System.out.println(fineList1.get(i).getPenaltyAmount() + " " + " грн");
                    }
                    System.out.println("Ведите номер штрафа который нужно изменить");
                    String numfine = scanner.nextLine();
                    int nunfn = Integer.parseInt(numfine);
                    if (nunfn <= fineList1.size()) {
                        String cnh;
                        do {
                            System.out.println("1 - изменить описание штрафа");
                            System.out.println("2 - изменить тип штрафа");
                            System.out.println("3 - изменить сумму штрафа");
                            System.out.println("esc - выход");
                            cnh = scanner.nextLine();
                            switch (cnh) {
                                case "1":
                                    System.out.println("Введите новое описание штрафа");
                                    String desc = scanner.nextLine();
                                    e.getValue().get(nunfn - 1).setFineDescription(desc);
                                    System.out.println("Описание штрафа изменено !");
                                    break;
                                case "2":
                                    TaxOffice.typeOfTax();
                                    String tax = scanner.nextLine();
                                    switch (tax) {
                                        case "1":
                                            e.getValue().get(nunfn - 1).setTypeOfFine("Штрафные санкции за неуплату или несвоевременную уплату единого социального взноса (ЕСВ) и неподачу отчетности");
                                            break;
                                        case "2":
                                            e.getValue().get(nunfn - 1).setTypeOfFine("Штрафные санкции за непредоставление отчетности");
                                            break;
                                        case "3":
                                            e.getValue().get(nunfn - 1).setTypeOfFine("Штрафные санкции за неуплату или несвоевременную уплату налоговых обязательств");
                                            break;
                                        case "4":
                                            e.getValue().get(nunfn - 1).setTypeOfFine("Штрафные санкции за занижение налоговых обязательств, выявленное в результате проверок");
                                            break;
                                        case "5":
                                            e.getValue().get(nunfn - 1).setTypeOfFine("Штрафные санкции за неведение, ненадлежащее ведение, потерю или ведение незарегистрированной книги учета доходов предпринимателем");
                                            break;
                                        case "6":
                                            e.getValue().get(nunfn - 1).setTypeOfFine("Штрафные санкции за вовлечение в деятельность неоформленного работника, за невыплату заработной платы, невыплату в полном объеме");
                                            break;
                                        case "7":
                                            e.getValue().get(nunfn - 1).setTypeOfFine("Штрафные санкции за неоприходование наличности в кассу");
                                            break;
                                        case "8":
                                            e.getValue().get(nunfn - 1).setTypeOfFine("Штрафные санкции за получение дохода за деятельность не указанную в свидетельстве единого налога");
                                            break;
                                        case "9":
                                            e.getValue().get(nunfn - 1).setTypeOfFine("Штрафные санкции за нарушение условий пребывания на едином налоге");
                                            break;
                                    }
                                case "3":
                                    System.out.println("Ведите новую сумму штрафа");
                                    String sum = scanner.nextLine();
                                    int sumpen = Integer.parseInt(sum);
                                    e.getValue().get(nunfn - 1).setPenaltyAmount(sumpen);
                                    System.out.println("Сумма штрафа изменена !");
                                    break;
                            }
                        } while (!("esc".equals(cnh)));
                    }
                    if (nunfn < fineList1.size()) {
                        System.out.println("Введите правильно номер штрафа ");
                    }
                }

            }


        }
    }
}

class MethodZero implements MakeInterface {

    @Override
    public void doIt() {

    }
}