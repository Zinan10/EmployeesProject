package org.example.Threading;

import org.example.DTO.EmployeeDTO;
import org.example.DAO.MyLocalDAO;
import org.example.Printer.Printer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Threading
{
    private static List<Thread> threads = new ArrayList<>();
    MyLocalDAO myLocalDAO = new MyLocalDAO();
  static  HashMap<Integer, EmployeeDTO> databaseInfo = new HashMap<>();
  static  List<EmployeeDTO> duplicates = new ArrayList<>();
  int i = 0;
    long start = System.nanoTime();
    long lengthOfTime;
   // private Log myLog = new Log();

    public  void  threadRun() {



            String textToRead = "resources/EmployeeRecords.csv";

            try (BufferedReader buffer = new BufferedReader(new FileReader(textToRead))) {
                buffer.readLine();
                String line = "";
                while ((line = buffer.readLine()) != null) {
                    EmployeeDTO employee = new EmployeeDTO(line.split(","));
                    databaseInfo.put(employee.getEmployeeId(), employee);
                    duplicates.add(employee);


                    if (databaseInfo.size() > 100) {
                        Thread thread = new Thread(new myTask(databaseInfo));
                        threads.add(thread);
                        thread.start();
                        databaseInfo = new HashMap<>();

                    }

                }
            } catch (FileNotFoundException e) {

            } catch (IOException e) {
                e.printStackTrace();

            }
        myLocalDAO.addEmployees(databaseInfo);
        lengthOfTime = System.nanoTime() - start;


        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {

            }
        }

        printTime(lengthOfTime);

    }
    public long getLengthOfTime()

    {
        return lengthOfTime;
    }

    public void printTime(long lengthOfTime)

    {
        Printer.runTime(lengthOfTime);
    }
}
