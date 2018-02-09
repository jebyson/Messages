package com.company;

import java.text.*;
import java.util.*;

public class MessageList {
    private static String from;
    private static String to;
    private static String phoneNumber;
    private static ArrayList <String> textMessages = new ArrayList<>();

    MessageList(String sendFrom, String sendTo, String number)
    {
        from = sendFrom;
        to = sendTo;
        phoneNumber = number;
    }

    static void firstText()
    {
        textMessages.add(Message.sendText);
    }

    static void addAnotherText(String addThisText)
    {
        textMessages.add(addThisText);
    }

    static void printConvo()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String dateTime = dateFormat.format(date);
        String additionalInfo = " " + Message.sender + " to " + Message.receiver + " (" + Message.numOfReceiver + ")";
        System.out.println("\n" + dateTime + additionalInfo);
        for (String textMessage : textMessages)
        {
            System.out.println(textMessage);
        }
    }

    static void clearData()
    {
        textMessages.clear();
    }
}
