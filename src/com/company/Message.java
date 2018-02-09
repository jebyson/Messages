package com.company;

import java.util.*;

public class Message {
    public static String numOfReceiver;
    public static String sendText;
    public static String sender;
    public static String receiver;

    public static String nextText;
    public static MessageList texter = new MessageList();

    public Message(String sentFrom, String sentTo, String phoneNumber, String textMessage)
    {
        sender = sentFrom;
        receiver = sentTo;
        numOfReceiver = phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6);
        sendText = sender + ": " + textMessage;
        texter.firstText();
    }

    public static void textConvo()
    {
        boolean abc = true;

        while (abc)
        {
            Scanner input = new Scanner(System.in);

            System.out.println("Will you send another text ('send'), the other person respond ('resp'), or quit ('quit').");
            String sendRespQuit = input.next();

            Scanner inputNext = new Scanner(System.in);

            if(sendRespQuit.equalsIgnoreCase("send"))
            {
                System.out.println("Input your next message.");
                String sendAgain = inputNext.nextLine();
                nextText = sender + ": " + sendAgain;
                texter.addAnotherText(nextText);
            }
            else if(sendRespQuit.equalsIgnoreCase("resp"))
            {
                System.out.println("Input the response message.");
                String response = inputNext.nextLine();
                nextText = receiver + ": " + response;
                texter.addAnotherText(nextText);
            }
            else if(sendRespQuit.equalsIgnoreCase("quit"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid input. Goodbye");
                break;
            }
        }
    }

    public static void continueOrNot()
    {
        Scanner inputNow = new Scanner(System.in);

        System.out.println("\nWould you like to continue the conversation ('cont') or end and see the conversation ('done')");
        String contDone = inputNow.next();
        if(contDone.equalsIgnoreCase("cont"))
        {
            textConvo();
        }
        else if ((contDone.equalsIgnoreCase("done")))
        {
            texter.printConvo();
        }
        else
        {
            System.out.println("Invalid input. Goodbye.");
        }

        texter.clearData();
    }
}
