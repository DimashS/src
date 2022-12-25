package com.JavaRush.Tasks.TasksWithArguments.SecondTask;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        switch (args[0]) {
            case ("-c"):
                synchronized (allPeople) {
                    doMethodC(args);
                    break;
                }
            case ("-u"):
                synchronized (allPeople) {
                    doMethodU(args);
                    break;
                }
            case ("-d"):
                synchronized (allPeople) {
                    doMethodD(args);
                    break;
                }
            case ("-i"):
                synchronized (allPeople) {
                    doMethodI(args);
                    break;
                }
        }
    }

    public static void doMethodC(String[] args) throws ParseException {
        for (int i = 1; i < args.length; i = i + 3) {
            if (args[i + 1].equals("м")) {
                allPeople.add(Person.createMale(args[i], simpleDateFormat.parse(args[i + 2])));
            } else {
                allPeople.add(Person.createFemale(args[i], simpleDateFormat.parse(args[i + 2])));
            }
            System.out.println(allPeople.size() - 1);
        }
    }

    public static void doMethodU(String[] args) throws ParseException {
        for (int i = 1; i < args.length; i += 4) {
            Person person = allPeople.get(Integer.parseInt(args[i]));
            person.setName(args[i + 1]);
            person.setBirthDate(simpleDateFormat.parse(args[i + 3]));
            if (args[i + 2].equals("м")) {
                person.setSex(Sex.MALE);
            } else {
                person.setSex(Sex.FEMALE);
            }
        }
    }

    public static void doMethodD(String[] args) {
        for (int i = 1; i < args.length; i++) {
            Person person = allPeople.get(Integer.parseInt(args[i]));
            person.setSex(null);
            person.setName(null);
            person.setBirthDate(null);

        }
    }

    public static void doMethodI(String[] args) {
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (int i = 1; i < args.length; i++) {
            Person person = allPeople.get(Integer.parseInt(args[i]));
            System.out.println(person.getName() + " "
                    + (person.getSex() == Sex.MALE ? "м" : "ж") + " "
                    + simpleDateFormat1.format(person.getBirthDate()));
        }
    }
}

