package com.company;

import java.text.*;
import java.util.*;

public class MessageList {
    public static String from;
    public static String to;
    public static String phoneNumber;
    public static ArrayList <String> textMessages = new ArrayList<>();

    public MessageList(String sendFrom, String sendTo, String number)
    {
        from = sendFrom;
        to = sendTo;
        phoneNumber = number;
    }

    public static void firstText()
    {
        textMessages.add(Message.sendText);
    }

    public static void addAnotherText(String addThisText)
    {
        textMessages.add(addThisText);
    }

    public static void printConvo()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String dateTime = dateFormat.format(date);
        String additionalInfo = " " + Message.sender + " to " + Message.receiver + "(" + Message.numOfReceiver + ")";
        System.out.println("\n" + dateTime + additionalInfo);
        for(int j = 0; j < textMessages.size(); j++)
        {
            System.out.println(textMessages.get(j));
        }
    }

    public static void clearData()
    {
        textMessages.clear();
    }
}
