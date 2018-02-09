package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        boolean abc = true;

        while (abc)
        {
            System.out.println("Input the name of the person who will send the text.");
            Scanner input = new Scanner(System.in);
            String senderName = input.nextLine();
            System.out.println("Input the name of the person who will receive the text.");
            String receiverName = input.nextLine();
            System.out.println("Input this person's area code (e.g.: '610').");
            String areaCode = input.nextLine();
            System.out.println("Input the rest of the phone number (e.g.: '1234567').");
            String shortNumber = input.nextLine();
            String phoneNumber = areaCode + shortNumber;
            System.out.println("What is the message that is being sent?");
            String sendText = input.nextLine();

            new Message(senderName, receiverName, phoneNumber, sendText);
            Message.textConvo();
            Message.continueOrNot();

            System.out.println("\nWould you like to start again ('rep') or quit the program ('quit')?");
            Scanner finalOne = new Scanner(System.in);
            String repQuit = finalOne.next();
            if(repQuit.equalsIgnoreCase("quit"))
            {
                abc = false;
            }
            else if(!(repQuit.equalsIgnoreCase("rep")))
            {
                System.out.println("Invalid input. Goodbye.");
                abc = false;
            }
        }
    }
}
