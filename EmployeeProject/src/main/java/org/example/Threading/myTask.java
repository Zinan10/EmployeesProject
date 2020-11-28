package org.example.Threading;

import org.example.DTO.EmployeeDTO;
import org.example.DAO.MyLocalDAO;

import java.util.HashMap;

public class myTask implements Runnable {

    public HashMap<Integer, EmployeeDTO> theEmployees;
    MyLocalDAO myLocalDAO = new MyLocalDAO();



    public myTask(HashMap<Integer, EmployeeDTO> toInsert) {
        theEmployees = toInsert;
    }

    @Override
    public synchronized void run()
    {
        try {
            Thread.sleep(3000);
            myLocalDAO.addEmployees(theEmployees);
            System.out.println(Thread.currentThread().getName() + " " + "Is adding records");
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

    }
}
