package com.JavaRush.Tasks.TasksWithArguments.FirstTask;

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
        allPeople.add(Person.createMale("������ ����", new Date()));  //������� �������    id=0
        allPeople.add(Person.createMale("������ ����", new Date()));  //������� �������    id=1
    }

    /*
    -c => ������� SimpleDateFormat, ��� �������� ��� �������� ��������
    ������� SimpleDateFormat � ����������� ������ �������� main � ������ ����� Date, �.�.
    ������ �������� � Person.create***** �������� Date
    switch (������� �� ������ �������� ����������)
    case -c -> m\f? addPeople.man:addPeople.woman(args[1],args[3])
    case -r -> args[1] � ��� id => ������������� � int � ������� ��� ������ ������� ������ �� ������
    case -u -> �������� ������, �.�. ���� ������ ����� ���������, �� �������� ��������� ��������� �������
    �� ����� ����� ������� �� id
    case -d -> ������ ��� ������� ����� get(id)
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
        if (args[2].equals("�")) {
            allPeople.add(Person.createMale(args[1], date));
        } else {
            allPeople.add(Person.createFemale(args[1], date));
        }
        System.out.println(allPeople.size() - 1);
    }

    public static void doMethodR(String[] args) throws ParseException {
        int id = Integer.parseInt(args[1]);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String maleOrFemale = allPeople.get(id).getSex() == Sex.MALE ? "�" : "�";
        System.out.println(allPeople.get(id).getName() + " " + maleOrFemale + " "
                + simpleDateFormat.format(allPeople.get(id).getBirthDate()));
    }

    public static void doMethodU(String[] args) throws ParseException {
        int id = Integer.parseInt(args[1]);
        DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        allPeople.get(id).setBirthDate(simpleDateFormat.parse(args[4]));
        allPeople.get(id).setName(args[2]);
        if (args[3].equals("�")) {
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

