# Similar-Doctors
Practice Fusion Coding Challenge

1) Problem Statement:
   A site contains a listing of doctors. Users can browse for doctors given a specific specialty, area, review score etc.
   Write a class which when given a doctor, provides a list of similar doctors, in a prioritized order. You define what similar means and the result ordering, but clearly document any assumptions in your code.
   Please, include unit tests. You can assume the entire directory of doctors fits into memory.
   
2) Technology & Tools: Java, JSON Library, MySQL, Junit

3) Assumptions:
   When user enter Doctor’s Id than program displays Particular doctor’s information like first name, Last name, Id, Specialty, city and review score. 
   And by using same specialty & city for this doctor it will display similar doctors with same specialty and same city. And result ordering using Review scores. 

4) Description: 
   First of all, Program calls addDoctorFromJSON() method to store Doctor’s information in the MySQL database by reading a JSON File. JSON file contains 70 doctors.
   Doctors database contains one Doctor_Information table. It has Id, First name, Last name, Specialty, City and Review score columns.
   Program will ask user to enter Doctor’s Id which he is searching. Then It fires SQL query to get all information about particular doctor from database. And it also provides a list of similar doctors in a prioritized order. 
   
   Class have three methods for finding similar doctors from database.
   
   1)	similarSpecCityDoctors() – Which provides all similar doctors with same specialty and same city.                                           
   2) similarSpecCityWorstDoctors() – Which Provides all similar doctors with same specialty and same city but worst review.     
   3)	similarSpeciltyDoctors() – Which provides all similar doctors with same specialty but not same city. 
   
5) Challenges:
   When I used float type for storing Review Score into MySQL Database than I was facing some issues. Floating-Point numbers sometimes cause confusion because they are approximate and not stored as exact values. 
   A floating-point value as written in an SQL statement may not be the same as the value represented internally. So, when I was firing SQL queries I was getting wrong values. 
   For solving this issues, I used Decimal type for storing Review Score and it works fine.
   
6) Unit Testing:
   I used Junit Test Framework for Unit Testing. DoctorTest.Java is test file.
   I wrote unit test cases using  @After, @Before, @Test annotation and assertTrue() method.
   I tested MySQL Database working or not. And I also tested pass Doctor’s Id is valid or not.
   
7) Future Enhancement:
   In future, we can create better user interface using front end technologies like HTML, CSS, JavaScript and AngularJS.
   By Giving new feature “Enter Specialty”, we can get all similar specialty doctors in a prioritized order.
   Another feature “Enter Specialty and Enter City”, we can get all doctors with same specialty & city in a prioritized order.



