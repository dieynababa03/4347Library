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
      // Establishing JDBC connection to make changes to DB
      // Like insertions
      Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library", "team",
          "password");

      // Reading book information from CSV file
      try (BufferedReader br = new BufferedReader(
          new FileReader("/Users/dieynababa/4347Library/4347Library/TableInitializer/books_2.csv"))) {

        String header = br.readLine();
        String line;

        // Reading line by line
        while ((line = br.readLine()) != null) {
          String[] values = line.split("\t");

          // Inserting into Book table the ISBN as well as Title
          Statement insertionIntoBook = myConn.createStatement();

          String insertionIntoBookQuery = "INSERT INTO BOOK (Isbn, Title) VALUES" + "(" + '"' + values[0] + '"' + ", "
              + '"' + values[2].replace("\"", "") + '"' + ");";
          insertionIntoBook.executeUpdate(insertionIntoBookQuery);

          // Inserting into Authors table
          Statement insertionIntoAuthors = myConn.createStatement();
          Statement insertionIntoBookAuthors = myConn.createStatement();
          Statement authorIdRetrieval = myConn.createStatement();
          // Splitting Authors line for when there's more than one author
          String names[] = values[3].split(",");

          if (names.length > 1) {
            // Iterating when a book has multiple authors as well as inserting into the book_authors table
            for (int i = 0; i < names.length; i++) {
              names[i] = names[i].replace("\"", "");
              String insertionIntoAuthorsQuery = "INSERT INTO AUTHORS (Name) SELECT (" + '"' + names[i].replace("\"", "") + '"'
                  + ") FROM dual  WHERE NOT EXISTS (SELECT Name FROM AUTHORS WHERE Name=" + '"' + names[i].replace("\"", "") + '"' + ");";
              insertionIntoAuthors.executeUpdate(insertionIntoAuthorsQuery);

              // Get Author_ID
              String getAuthorIDQuery = "SELECT Author_id FROM AUTHORS WHERE Name=" + '"' + names[i].replace("\"", "") + '"';
              ResultSet res = authorIdRetrieval.executeQuery(getAuthorIDQuery);
              int authorID = 0;
              if (res.next()) {
                authorID = res.getInt("Author_id");
              }

              //Only insert into Book_Authors if the author id does not exist
              String insertionIntoBookAuthorsQuery = "INSERT INTO BOOK_AUTHORS(Author_id, Isbn) SELECT " + authorID + ", " + '"' + values[0] + '"' + " FROM dual WHERE NOT EXISTS (" + "SELECT Author_id FROM BOOK_AUTHORS WHERE Author_id=" + authorID + " AND Isbn=" + '"' + values[0] + '"' + ");";


                  
              insertionIntoBookAuthors.executeUpdate(insertionIntoBookAuthorsQuery);
            }
          } else {
            // Same as above but in the case where there is only 1 author
            String insertionIntoAuthorsQuery = "INSERT INTO AUTHORS (Name) SELECT (" + '"' + names[0].replace("\"", "") + '"'
                + ") FROM dual  WHERE NOT EXISTS (SELECT Name FROM AUTHORS WHERE Name=" + '"' + names[0].replace("\"", "") + '"' + ");";
            insertionIntoAuthors.executeUpdate(insertionIntoAuthorsQuery);

            // Get Author_ID
            String getAuthorIDQuery = "SELECT Author_id FROM AUTHORS WHERE Name=" + '"' + names[0].replace("\"", "") + '"';
            ResultSet res = authorIdRetrieval.executeQuery(getAuthorIDQuery);
            int authorID = 0;
            if (res.next()) {
              authorID = res.getInt("Author_id");
            }

            //Insert into Book_Authors
            String insertionIntoBookAuthorsQuery = "INSERT INTO BOOK_AUTHORS(Author_id, Isbn) VALUES("
                + authorID + ", " + '"' + values[0] + '"' + ");";
            insertionIntoBookAuthors.executeUpdate(insertionIntoBookAuthorsQuery);
          }

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
