/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

/**
 *
 * @author Hernandez
 */
import java.sql.*;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JOptionPane;

public class BookCheckOut extends javax.swing.JFrame {
    private ArrayList<String> ISBNs = new ArrayList<>();
    /**
     * Creates new form BookCheckOut
     */
    public BookCheckOut() {
        initComponents();
        setTable();
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        jTable1MouseClicked(evt);
    }
});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(856, 709));
        setSize(new java.awt.Dimension(500, 200));

        jPanel1.setBackground(new java.awt.Color(241, 248, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(85, 85, 85));
        jLabel1.setText("Check-Out");
        jLabel1.setToolTipText("");

        jButton1.setText("x");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 809, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ISBN", "Title", "Author", "Availability"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Name/ISBN/Author:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton2.setText("Check-Out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Check-Out by ISBN");
        jButton3.setToolTipText("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Dashboard db = new Dashboard();
        db.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        String searchValue = jTextField1.getText();
        performQuery(searchValue);
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    StringBuilder selectedBooksMessage = new StringBuilder("Check-out\n");
    
// Display the names of the selected books
    for (String isbn : ISBNs) {
        String title = getBookTitle(isbn);
        selectedBooksMessage.append("ISBN: ").append(isbn).append(", Title: ").append(title).append("\n");
    }

    // Display the information for all selected books
    String cardId = JOptionPane.showInputDialog(this, selectedBooksMessage.toString() + "\nEnter your Card ID:");

    if (cardId == null || cardId.isEmpty()) {
        // Display an error message or prompt the user that a card ID is required
        JOptionPane.showMessageDialog(this, "Card ID is required to check out books.", "Error", JOptionPane.ERROR_MESSAGE);
        return;  // Exit the method, preventing further checkout attempts
    }

    if (!isCardIdValid(cardId)) {
        JOptionPane.showMessageDialog(this, "Invalid Card ID. Please enter a valid Card ID.", "Error", JOptionPane.ERROR_MESSAGE);
        return;  // Exit the method if the card ID is not valid
    }
    
// Iterate through the selected ISBNs and execute SQL code
    for (String isbn : ISBNs) {
        // Retrieve book details (you can modify this part based on your actual table structure)
        String title = getBookTitle(isbn); // Assuming you have a method to get book details
        selectedBooksMessage.append("ISBN: ").append(isbn).append(", Title: ").append(title).append("\n");

        // Insert a row for the current book
        try (Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?allowMultiQueries=TRUE", "team", "password")) {
            // Check if the user has already checked out 3 books
            if (getCheckedOutBookCount(cardId) >= 3) {
                JOptionPane.showMessageDialog(this, "You cannot check out more than 3 books.", "Error", JOptionPane.ERROR_MESSAGE);
                return;  // Exit the method, preventing further checkout attempts
            }

            if (!isBookAvailable(isbn)) {
                JOptionPane.showMessageDialog(this, "The selected book is not available for check-out.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Create a new tuple in the BOOK_LOANS table
            String insertBookLoanQuery = "INSERT INTO BOOK_LOANS (Isbn, Card_id, Date_out, Due_date) VALUES (?, ?, ?, ?)";
            try (PreparedStatement insertBookLoanStatement = myConn.prepareStatement(insertBookLoanQuery)) {
                insertBookLoanStatement.setString(1, isbn);
                insertBookLoanStatement.setString(2, cardId);

                // Set Date_out to the current date
                insertBookLoanStatement.setDate(3, new Date(Calendar.getInstance().getTime().getTime()));

                // Set Due_date to 14 days from the current date (adjust as needed)
                Calendar dueDate = Calendar.getInstance();
                dueDate.add(Calendar.DAY_OF_MONTH, 14);
                insertBookLoanStatement.setDate(4, new Date(dueDate.getTime().getTime()));

                insertBookLoanStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed, display an error message, log the error, etc.
        }
    }

    JOptionPane.showMessageDialog(this, "Book(s) checked out successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    ISBNs.clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String isbn = JOptionPane.showInputDialog(this, "Enter ISBN to check out:");

    // Check if the entered ISBN is valid (you may need additional validation)
    if (isbn == null || isbn.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Invalid ISBN. Please enter a valid ISBN.", "Error", JOptionPane.ERROR_MESSAGE);
        return;  // Exit the method if the ISBN is not valid
    }

    // Display the information for the selected book
    String title = getBookTitle(isbn); // Assuming you have a method to get book details
    String bookInfo = "ISBN: " + isbn + ", Title: " + title;

    // Prompt the user to enter a Card ID
    String cardId = JOptionPane.showInputDialog(this, "Selected book:\n" + bookInfo + "\nEnter your Card ID:");

    // Validate Card ID
    if (cardId == null || cardId.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Card ID is required to check out the book.", "Error", JOptionPane.ERROR_MESSAGE);
        return;  // Exit the method, preventing further checkout attempts
    }

    if (!isCardIdValid(cardId)) {
        JOptionPane.showMessageDialog(this, "Invalid Card ID. Please enter a valid Card ID.", "Error", JOptionPane.ERROR_MESSAGE);
        return;  // Exit the method if the Card ID is not valid
    }

    try (Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?allowMultiQueries=TRUE", "team", "password")) {
        // Check if the user has already checked out 3 books
        if (getCheckedOutBookCount(cardId) >= 3) {
            JOptionPane.showMessageDialog(this, "You cannot check out more than 3 books.", "Error", JOptionPane.ERROR_MESSAGE);
            return;  // Exit the method, preventing further checkout attempts
        }

        // Check if the selected book is available
        if (!isBookAvailable(isbn)) {
            JOptionPane.showMessageDialog(this, "The selected book is not available for check-out.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a new tuple in the BOOK_LOANS table
        String insertBookLoanQuery = "INSERT INTO BOOK_LOANS (Isbn, Card_id, Date_out, Due_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement insertBookLoanStatement = myConn.prepareStatement(insertBookLoanQuery)) {
            insertBookLoanStatement.setString(1, isbn);
            insertBookLoanStatement.setString(2, cardId);

            // Set Date_out to the current date
            insertBookLoanStatement.setDate(3, new Date(Calendar.getInstance().getTime().getTime()));

            // Set Due_date to 14 days from the current date (adjust as needed)
            Calendar dueDate = Calendar.getInstance();
            dueDate.add(Calendar.DAY_OF_MONTH, 14);
            insertBookLoanStatement.setDate(4, new Date(dueDate.getTime().getTime()));

            insertBookLoanStatement.executeUpdate();
        }

        JOptionPane.showMessageDialog(this, "Book checked out successfully!\n", "Success", JOptionPane.INFORMATION_MESSAGE);
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception as needed, display an error message, log the error, etc.
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookCheckOut().setVisible(true);
            }
        });
        
    }
    public void setTable(){
        TableColumnModel columnModel = jTable1.getColumnModel();
        columnModel.getColumn(1).setPreferredWidth(300);
        columnModel.getColumn(2).setPreferredWidth(200);
        
    }
    private String getBookTitle(String isbn) {
    String title = null;

    try (Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?allowMultiQueries=TRUE", "team", "password")) {
        String query = "SELECT Title FROM BOOK WHERE Isbn = ?";
        try (PreparedStatement statement = myConn.prepareStatement(query)) {
            statement.setString(1, isbn);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    title = resultSet.getString("Title");
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception as needed
    }

    return title;
}

    private int getCheckedOutBookCount(String cardId) throws SQLException {
    try (Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?allowMultiQueries=TRUE", "team", "password")) {
        String countQuery = "SELECT COUNT(*) FROM BOOK_LOANS WHERE Card_id = ? AND Date_in IS NULL";
        try (PreparedStatement countStatement = myConn.prepareStatement(countQuery)) {
            countStatement.setString(1, cardId);
            try (ResultSet resultSet = countStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        }
    }
    return 0;
}

private boolean isBookAvailable(String isbn) {
    try (Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?allowMultiQueries=TRUE", "team", "password")) {
        String availabilityQuery = "SELECT COUNT(*) FROM BOOK_LOANS WHERE Isbn = ? AND Date_in IS NULL";
        try (PreparedStatement availabilityStatement = myConn.prepareStatement(availabilityQuery)) {
            availabilityStatement.setString(1, isbn);
            try (ResultSet resultSet = availabilityStatement.executeQuery()) {
                if (resultSet.next()) {
                    // Check if there are no outstanding loans (Date_in is NULL)
                    boolean isAvailable = resultSet.getInt(1) == 0;
                    return isAvailable;
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();  // Print the exception details for debugging
    }
    return false;
}

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
    int selectedRow = jTable1.getSelectedRow();
    String isbn = jTable1.getValueAt(selectedRow, 0).toString(); // Assuming ISBN is in the first column

    if (!ISBNs.contains(isbn)) {
        ISBNs.add(isbn);
    } else {
        // ISBN already selected, implement deselect logic if needed
        ISBNs.remove(isbn);
    }
    }
    private void deselectButtonActionPerformed(java.awt.event.ActionEvent evt) {
    int selectedRow = jTable1.getSelectedRow();
    String isbn = jTable1.getValueAt(selectedRow, 0).toString();

    ISBNs.remove(isbn);
}
    
    private boolean isCardIdValid(String cardId) {
    try (Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?allowMultiQueries=TRUE", "team", "password")) {
        String validateCardIdQuery = "SELECT COUNT(*) FROM BORROWER WHERE Card_id = ?";
        try (PreparedStatement validateCardIdStatement = myConn.prepareStatement(validateCardIdQuery)) {
            validateCardIdStatement.setString(1, cardId);
            try (ResultSet resultSet = validateCardIdStatement.executeQuery()) {
                return resultSet.next() && resultSet.getInt(1) > 0;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception as needed
    }
    return false;
}

    public void performQuery(String searchValue) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?allowMultiQueries=TRUE", "team",
                    "password");
            Statement search = myConn.createStatement();
            String queryStatementAuthor = "SELECT BOOK.Isbn, GROUP_CONCAT(AUTHORS.Name SEPARATOR ', ') AS AuthorsName, BOOK.Title "
                + "FROM AUTHORS "
                + "INNER JOIN BOOK_AUTHORS ON AUTHORS.Author_id = BOOK_AUTHORS.Author_id "
                + "INNER JOIN BOOK ON BOOK_AUTHORS.ISBN = BOOK.ISBN "
                + "WHERE AUTHORS.Name LIKE '%" + searchValue + "%' " +
                "GROUP BY BOOK.Isbn;";
            ResultSet res = search.executeQuery(queryStatementAuthor);

            while (res.next()) {
                String name = res.getString("AuthorsName");
                String isbn = res.getString("Isbn");
                String title = res.getString("Title");
                String availability = isBookAvailable(isbn) ? "available" : "unavailable";

                model.addRow(new Object[]{isbn, title, name, availability});
            }
            String queryStatementTitle = "SELECT BOOK.Isbn, GROUP_CONCAT(AUTHORS.Name SEPARATOR ', ') AS AuthorsName, BOOK.Title "
                + "FROM AUTHORS "
                + "INNER JOIN BOOK_AUTHORS ON AUTHORS.Author_id = BOOK_AUTHORS.Author_id "
                + "INNER JOIN BOOK ON BOOK_AUTHORS.ISBN = BOOK.ISBN "
                + "WHERE BOOK.Title LIKE '%" + searchValue + "%' " +
                "GROUP BY BOOK.Isbn;";
            ResultSet res2 = search.executeQuery(queryStatementTitle);
            while (res2.next()) {
                String name = res2.getString("AuthorsName");
                String isbn = res2.getString("Isbn");
                String title = res2.getString("Title");

                model.addRow(new Object[]{isbn, title, name, "available"});

            }
            String queryStatementIsbn = "SELECT BOOK.Isbn, GROUP_CONCAT(AUTHORS.Name SEPARATOR ', ') AS AuthorsName, BOOK.Title "
                + "FROM AUTHORS "
                + "INNER JOIN BOOK_AUTHORS ON AUTHORS.Author_id = BOOK_AUTHORS.Author_id "
                + "INNER JOIN BOOK ON BOOK_AUTHORS.ISBN = BOOK.ISBN "
                + "WHERE BOOK.Isbn LIKE '%" + searchValue + "%' " +
                "GROUP BY BOOK.Isbn;";
            ResultSet res3 = search.executeQuery(queryStatementIsbn);
            while (res3.next()) {
                String name = res3.getString("AuthorsName");
                String isbn = res3.getString("Isbn");
                String title = res3.getString("Title");

                model.addRow(new Object[]{isbn, title, name, "available"});

            }
            res.close();
            res2.close();
            res3.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
