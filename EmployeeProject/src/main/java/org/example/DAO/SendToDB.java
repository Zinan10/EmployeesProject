package org.example.DAO;

import org.example.DTO.EmployeeDTO;
import org.example.Printer.Printer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SendToDB

{
    MyLocalDAO myLocalDAO = new MyLocalDAO();
    HashMap<Integer, EmployeeDTO> databaseInfo = new HashMap<>();
    List<EmployeeDTO> duplicates = new ArrayList<>();
    long start = System.nanoTime();
    long lengthOfTime;

    // private Log myLog = new Log();



    public void readingData() {

        String textToRead = "resources/EmployeeRecords.csv";

        try (BufferedReader buffer = new BufferedReader(new FileReader(textToRead))) {
            buffer.readLine();
                String line = "";
            while ((line = buffer.readLine()) != null) {
                EmployeeDTO employee = new EmployeeDTO(line.split(","));
                databaseInfo.put(employee.getEmployeeId(), employee);
                duplicates.add(employee);


            }
            System.out.println(databaseInfo.size());
        } catch (FileNotFoundException e) {

        } catch (IOException e) {
            e.printStackTrace();
           // myLog.logException(e);
        }
        myLocalDAO.addEmployees(databaseInfo);
         lengthOfTime = System.nanoTime() - start;

            printTime(lengthOfTime);

    }
    public void getDuplicates()
    {
        for (Map.Entry entry:databaseInfo.entrySet())
        {
            if(duplicates.contains(entry.getValue()))

            {
                duplicates.remove(entry.getValue());
            }
        }

        Printer.getDuplicateSize(duplicates.size());
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
