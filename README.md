# Sparta Employees Project
### Tools Used

![git](https://img.shields.io/badge/git-%23F05032.svg?&style=for-the-badge&logo=git&logoColor=white)
![intellij](https://img.shields.io/badge/intelliJ%20IDEA-%23000000.svg?&style=for-the-badge&logo=intellij-idea&logoColor=white)
![mysql](https://img.shields.io/badge/mysql-%2300f.svg?&style=for-the-badge&logo=mysql&logoColor=white)
![java](https://img.shields.io/badge/java-%23ED8B00.svg?&style=for-the-badge&logo=java&logoColor=white)
![maven](https://img.shields.io/badge/Apache%20Maven-%23C71A36.svg?&style=for-the-badge&logo=apache-maven&logoColor=white)

<img src = "https://i.pinimg.com/originals/d3/70/e5/d370e515ecba80b8cc994e849fd0c44d.gif" width = "700px" >

# Requirements 

Perform data migration from a CSV file to a MySQL database.

The files provided contain details about Employees. (EmployeeRecords.csv / EmployeeRecordsLarge.csv)

Your program will need to read the data from the CSV file and then import the data into the database. Please note that there may be errors in the CSV file that you need to check for. It is recommend to create some kind of collection to store the invalid employee records, so they can be checked later.

The program needs thorough testing at all points to ensure the data migration has taken place correctly. It should also report on the time takes to read the CSV, populate the database and the overall time for the migration.

Be sure to consider the use of design patterns to follow good clean code standards (DTO, DAO).

# Brief Introduction

The employee project is a task that required the persistence of data from a CSV file into a MYSQL database using Java in-between. The completion of thi sproject would show a deceny understanding of concepts such as:

- DTO (Data Transfer Objects)
- DAO (Data Access Objects)
- Threads and Concurrency
- Reading and Writing data through a BufferedReader in combination with a FileReader
- Manipulation of a MYSQL database

# Accomplishments

- I was able to successfully establish a live connection with a MYSQL database through Java plug-ins and brief lines of code and authentication
- I was able to successfully persist thousands of data from the CSV file to the MYSQL database without the use of threads in under 20 seconds
- I was able to successfully persist thousands of data from the CSV file to the MYSQL database with the use of threads in under 20 seconds
- I was able to use the collection framework and various data structures to manipulate the data.




## Tools Needed

In order to run the program the following tools are required

- [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) 
- [MYSQL Server](https://dev.mysql.com/downloads/windows/installer/8.0.html)
- [InteliJ](https://www.jetbrains.com/idea/download/#section=mac) 

When these tools have been successfully downloaded and installed the repository can be cloned and used.

**Note** *The MYSQL application would require a username and passowrd and not being able to remember the password would make these steps difficult. 
If you face difficulties please see [this](https://www.a2hosting.co.uk/kb/developer-corner/mysql/reset-mysql-root-password) for help*


## Future Work

- Although persistence was successful when using threads not all the fields were persisted when using the small CSV file, this should be fixed.
- Addition of tests to ensure the code is working the way it is suppsoed to.
- More performance tests to get a proper runtime for both threaded persistence and non threaded persistence.
