import java.util.Scanner;

public class Input {
    public static void main (String[] args) {
        System.out.println("Scanner Inputs");
        System.out.println("--------------");
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("What is your name?");
        String name = scan.nextLine();
        System.out.println("Hello "+ name + ", it is good to meet you. \n");

        System.out.println("What is your age?");
        String ageString = scan.nextLine();
        System.out.println("You are "+ ageString +" years old.");
        int age = Integer.parseInt(ageString);

        age += 10;

        System.out.println("You will be "+ age +" in ten years.");

        System.out.println(name+" would you like to play a guessing game?");
        String answer = scan.nextLine().toUpperCase();
        if(answer.equals("YES")) {
            playGame();
        } else {
            System.out.println("Okay thanks.");
        }
        
        System.out.println("Thank you "+ name +" see you agian soon.");
    }

    public static void playGame () {
        Scanner scan = new Scanner(System.in);
        byte rand = (byte)Math.floor(Math.random()*10);
        System.out.println("I have created a random number "+
            "between 0 and 9. What is your guess?");
        String answer = scan.nextLine();
        byte ans = Byte.parseByte(answer);

        do {
            if(rand == ans) {
                System.out.println("CONGRATS!! You won the game!!");
            } else {
                System.out.println("Sorry that is not correct.");
                if(ans > rand) {
                    System.out.println("Your answer was greater.");
                } else {
                    System.out.println("Your answer was less.");
                }
                System.out.println("Guess again.");
                ans = Byte.parseByte(scan.nextLine());
            }
        } while (rand != ans);
    } 
}