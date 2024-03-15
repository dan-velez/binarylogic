package com.blit;

import com.blit.models.Person;
import java.util.Scanner;
import java.time.LocalDate;

public class Models {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        Person person = new Person();

        System.out.println("What is your name?");
        String answer = scan.nextLine();
        person.name = answer;

        System.out.println("What is your age?");
        answer = scan.nextLine();
        person.setAge(Short.parseShort(answer));

        System.out.println("What is your year of birth?");
        answer = scan.nextLine();
        int year = Integer.parseInt(answer);

        System.out.println("What is your month of birth?");
        answer = scan.nextLine();
        int month = Integer.parseInt(answer);

        System.out.println("What is your day of birth?");
        answer = scan.nextLine();
        int day = Integer.parseInt(answer);

        person.dateOfBirth = LocalDate.of(year, month, day);

        System.out.println("Are you married?");
        answer = scan.nextLine().toUpperCase();
        if(answer.equals("YES")) {
            person.married = true;
        } else {
            person.married = false;
        }

        System.out.println("Hello "+person.name+"! What is it like being born" +
            "on "+person.dateOfBirth+"? That makes you "+person.getAge()+
            " years old, correct?");
        if(person.married) {
            System.out.println("Congrats on being married!");
        } else {
            System.out.println("Congrats on being single!");
        }

        System.out.println("How many steps would you like to walk?");
        answer = scan.nextLine();
        person.walk(Integer.parseInt(answer));

        Person person2 = new Person();
        person2.name =  "Majid";
        person2.setAge((short)21);
        person2.dateOfBirth = LocalDate.of(2003, 03, 21);
        person2.married = true;
    }
}