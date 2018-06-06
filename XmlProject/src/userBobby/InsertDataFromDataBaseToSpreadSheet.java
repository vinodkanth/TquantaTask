package userBobby;

import java.io.File;
import java.io.FileOutputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertDataFromDataBaseToSpreadSheet {
   public static void main(String[] args) throws Exception {

      //Connecting to the database
      Class.forName("com.mysql.jdbc.Driver");
      Connection connect = DriverManager.getConnection(
         "jdbc:mysql://localhost:3306/details", "root" , "viratkohli12345");

      //Getting data from the table emp_tbl
      Statement statement = connect.createStatement();
      ResultSet resultSet = statement.executeQuery("select * from student_data");

      //Creating a Work Book
      XSSFWorkbook workbook = new XSSFWorkbook();

      //Creating a Spread Sheet
      XSSFSheet spreadsheet = workbook.createSheet("employe db");
      XSSFRow row = spreadsheet.createRow(1);
      XSSFCell cell;
      
      cell = row.createCell(1);
      cell.setCellValue("EMP ID");
      
      cell = row.createCell(2);
      cell.setCellValue("EMP NAME");
      
      cell = row.createCell(3);
      cell.setCellValue("DEG");
      
      cell = row.createCell(4);
      cell.setCellValue("SALARY");
      
      cell = row.createCell(5);
      cell.setCellValue("DEPT");
      int i = 2;

      while(resultSet.next()) {
         row = spreadsheet.createRow(i);
         cell = row.createCell(1);
         cell.setCellValue(resultSet.getInt("ID"));
         
         cell = row.createCell(2);
         cell.setCellValue(resultSet.getString("NAME"));
         
         cell = row.createCell(3);
         cell.setCellValue(resultSet.getString("BRANCH"));
         
         cell = row.createCell(4);
         cell.setCellValue(resultSet.getString("PERCENTAGE"));
         
         cell = row.createCell(5);
         cell.setCellValue(resultSet.getString("EMAIL"));
         i++;
      }
      
      FileOutputStream out = new FileOutputStream(
         new File("C:/poiexcel/exceldatabase.xlsx"));
      
      workbook.write(out);
      out.close();
      
      System.out.println("exceldatabase.xlsx written successfully");
   }
}
