package model;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class PersonList {
    private final int SIZE = 5;
    private Person[] people = new Person[SIZE];
    private int index = 0;


    public void saveToFile(String fileName) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Person person) {
        if (person ! = null){
            if (index == people.length) {
                person = Arrays.copyOf(people, people.length * 2);

            }
            people[index] = person;
        }
    }

    public void show() {
        System.out.println("people lost:");
        for (int i = 0; i < index; i++) {
            System.out.println(people[1]);


        }
    }


    public void loadFromFile(String fileName) {
        try {
            try (Scanner scanner = new Scanner(new FileReader(fileName))) {


                while (scanner.hasNextLine()) {
                    String FileLine = scanner.nextLine();
                    String[] fields = fileName.split(" ");
                    switch (fields[0]) {
                        case "Person":
                            add(new Person(fields[1], Integer.parseInt(fields[2])));
                            break;
                        case "Student":
                            add(new Person(fields[1], Integer.parseInt(fields[2]), Double.parseDouble(fields[3])));
                            break;

                        case "Employee":
                            add(new Person(fields[1], Integer.parseInt(fields[2]), Double.parseDouble(fields[3])));
                            break;
                    }
                }


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
