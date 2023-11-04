// DON'T RUN PLEASE LOL

package TableInitializer;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Script {
  public static void main(String[] args) throws IOException {
    try {
      //Establishing JDBC connection to make changes to DB
      //Like insertions
      Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARYPROJECT", "project_user",
          "password");

      //Reading book infromation from CSV file
      try (BufferedReader br = new BufferedReader(
          new FileReader("/Users/dieynababa/4347/4347Library/TableInitializer/books.csv"))) {
        String header = br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
          String[] values = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

          //Insertion statement
          Statement insertion = myConn.createStatement();
          
          //Insertion query text
          String insertionQuery = "INSERT INTO BOOKS (ISBN, TITLE, AUTHOR, COVER, PUBLISHER, PAGES) VALUES" + "(" + '"'  + values[0] + '"'  + ", " + '"' + values[2].replace("\"", "") + '"' + ", "  + '"'
          + values[3].replace("\"", "") + '"' + ", " + '"' + values[4] + '"' + ", " + '"' + values[5].replace("\"", "") + '"' + ", " + values[6] + ");";

          insertion.executeUpdate(insertionQuery);

        }
      } catch (FileNotFoundException e) {
        System.out.println("Error");
        e.printStackTrace();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
