package org.example.Starter;

import org.example.DAO.MyLocalDAO;
import org.example.DAO.SendToDB;
import org.example.Threading.Threading;

import java.util.Scanner;

public class Starter {


    public static void choiceOfInsert() {
        int choice = 0;

        Scanner firstScanner = new Scanner(System.in);

        do {
            System.out.println("Do you want to insert files with threads or without threads?");
            System.out.println("Press 1 for the without Threads");
            System.out.println("Press 2 for using Threads");
            System.out.println("Press 3 to cancel");


            try {
                choice = firstScanner.nextInt();

                if (choice == 1) {
                    MyLocalDAO myLocalDAO = new MyLocalDAO();
                    myLocalDAO.connectToDatabase();
                    SendToDB stb = new SendToDB();
                    stb.readingData();

                }

                else if (choice == 2) {
                    Threading threadRun = new Threading();
                    threadRun.threadRun();
                }

                else if (choice == 3) {
                   break;
                }

            } catch (Exception e) {
                System.err.println("Please enter a valid number for the sorting");
                e.printStackTrace();
            } finally {
                firstScanner = new Scanner(System.in);
            }
        }

            while (choice >= 1 || choice <= 3) ;

    }

}



