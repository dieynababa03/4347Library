package TableInitializer;

import GUI.DatabaseManager;
import java.io.*;
import java.sql.*;

public class Script {
  public static void main(String[] args) throws IOException {
    try {
      // Establishing JDBC connection to make changes to DB
      // Like insertions
      Connection myConn = DatabaseManager.getConnection();

      // Reading book information from CSV file
      try (BufferedReader br = new BufferedReader(
          new FileReader("src/TableInitializer/books.csv"))) {

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
        }
        
      BufferedReader br2 = new BufferedReader(new FileReader("src/TableInitializer/borrowers.csv"));
      br2.readLine();
      while ((line = br2.readLine()) != null) {
            String[] values2 = line.split(",");
            PreparedStatement preparedStatement = myConn.prepareStatement("INSERT INTO BORROWER VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");

            preparedStatement.setString(1, values2[0]);
            preparedStatement.setString(2, values2[1]);
            preparedStatement.setString(3, values2[2]);
            preparedStatement.setString(4, values2[3]);
            preparedStatement.setString(5, values2[5]);
            preparedStatement.setString(6, values2[6]);
            preparedStatement.setString(7, values2[7]);
            preparedStatement.setString(8, values2[4]);
            preparedStatement.setString(9, values2[8]);

            preparedStatement.executeUpdate(); 
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

  }
}
