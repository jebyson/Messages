package com.company;

import java.util.*;

public class Message {
    static String numOfReceiver;
    static String sendText;
    static String sender;
    static String receiver;

    private static String nextText;

    Message(String sentFrom, String sentTo, String phoneNumber, String textMessage)
    {
        sender = sentFrom;
        receiver = sentTo;
        numOfReceiver = phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6);
        sendText = sender + ": " + textMessage;
        MessageList.firstText();
    }

    private static MessageList texter = new MessageList(sender, receiver, numOfReceiver);

    static void textConvo()
    {
        boolean abc = true;

        while (true)
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
                MessageList.addAnotherText(nextText);
            }
            else if(sendRespQuit.equalsIgnoreCase("resp"))
            {
                System.out.println("Input the response message.");
                String response = inputNext.nextLine();
                nextText = receiver + ": " + response;
                MessageList.addAnotherText(nextText);
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

    static void continueOrNot()
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
            MessageList.printConvo();
        }
        else
        {
            System.out.println("Invalid input. Goodbye.");
        }

        MessageList.clearData();
    }
}
