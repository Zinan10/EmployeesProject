package org.example.Printer;


public class Printer {





    public static void getInt ( int number)
    {
        System.out.println(number);
    }

    public static void getDuplicateSize ( int number)
    {
        System.out.println("The size of the duplicate value is" + " " + number);
    }

    public static void getString (String message){
        System.out.println(message);
    }

    public static void runTime(long timeTaken)

    {
        System.out.println("The time taken to insert the values is " + timeTaken);
    }

    public static void printEntryDetails()

    {
        System.out.println("Do you want to see an entry in the table?");
    }
}

