package com.JavaRush.Tasks.TasksWithArguments.FirtsTask;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Task1 {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    /*
    -c => создать SimpleDateFormat, для хранения дня рождения человека
    создаем SimpleDateFormat и преобразуем третий аргумент main в строку через Date, т.к.
    второй параметр в Person.create***** является Date
    switch (смотрим на первый аргумент параметров)
    case -c -> m\f? addPeople.man:addPeople.woman(args[1],args[3])
    case -r -> args[1] у нас id => преобразовать в int и вывести под данным номером данные из списка
    case -u -> обновить данные, т.е. если пришли новые параметры, то заменить параметры некоторых свойств
    на новые через сеттеры по id
    case -d -> просто все удалить через get(id)
     */

    public static void main(String args[]) throws ParseException {
        switch (args[0]) {
            case ("-c"):
                doMethodC(args);
                break;
            case ("-r"):
                doMethodR(args);
                break;
            case ("-u"):
                doMethodU(args);
                break;
            case ("-d"):
                doMethodD(args);
                break;
        }
    }

    public static void doMethodC(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = simpleDateFormat.parse(args[3]);
        if (args[2].equals("м")) {
            allPeople.add(Person.createMale(args[1], date));
        } else {
            allPeople.add(Person.createFemale(args[1], date));
        }
        System.out.println(allPeople.size() - 1);
    }

    public static void doMethodR(String[] args) throws ParseException {
        int id = Integer.parseInt(args[1]);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String maleOrFemale = allPeople.get(id).getSex() == Sex.MALE ? "м" : "ж";
        System.out.println(allPeople.get(id).getName() + " " + maleOrFemale + " "
                + simpleDateFormat.format(allPeople.get(id).getBirthDate()));
    }

    public static void doMethodU(String[] args) throws ParseException {
        int id = Integer.parseInt(args[1]);
        DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        allPeople.get(id).setBirthDate(simpleDateFormat.parse(args[4]));
        allPeople.get(id).setName(args[2]);
        if (args[3].equals("м")) {
            allPeople.get(id).setSex(Sex.MALE);
        } else {
            allPeople.get(id).setSex(Sex.FEMALE);
        }
        allPeople.set(id, allPeople.get(id));
    }

    public static void doMethodD(String[] args) {
        int id = Integer.parseInt(args[1]);
        allPeople.get(id).setBirthDate(null);
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
    }
}

