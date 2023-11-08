-- MySQL Database Creation
-- To run: mysql> source create-tables-proj.sql

-- Notes:
-- -- See Project Specifications for the schema diagram
-- -- The "Bname" attribute in BORROWER is split into two attribute "Fname" and "Lname"
-- -- "Address", "City", and "State" are seperate attributes in BORROWER
-- -- Email is added as an attribute in BORROWER (not shown in schema diagram)
-- -- ISBN10 (not ISBN13)
-- -- SSN Format: xxx-xx-xxxx
-- -- Card Id Format: IDxxxxxx
-- -- Phone number Format: (xxx) xxx-xxxx
-- -- Email addresses need to be <= 64 characters
-- -- Borrower's state is stored as the 2-letter abbreviation
-- -- Fine amount <= $9999.99

DROP TABLE IF EXISTS BOOK;
CREATE TABLE BOOK (
	Isbn CHAR(10) PRIMARY KEY,
	Title VARCHAR(128)
);

DROP TABLE IF EXISTS AUTHORS;
CREATE TABLE AUTHORS (
	Author_id INT AUTO_INCREMENT PRIMARY KEY,
	Name VARCHAR(128)
);

DROP TABLE IF EXISTS BOOK_AUTHORS;
CREATE TABLE BOOK_AUTHORS (
	Author_id INT,
	Isbn CHAR(10),
	PRIMARY KEY (Author_id, Isbn),
	FOREIGN KEY (Isbn) REFERENCES BOOK(Isbn),
	FOREIGN KEY (Author_id) REFERENCES AUTHORS(Author_id)
);

DROP TABLE IF EXISTS BORROWER;
CREATE TABLE BORROWER (
	Card_id CHAR(8) PRIMARY KEY,
	Ssn CHAR(11),
	Fname VARCHAR(64),
	Lname VARCHAR(64),
	Address VARCHAR(64),
	City VARCHAR(32),
	State CHAR(2),
	Email VARCHAR(64),
	Phone CHAR(14)
);

DROP TABLE IF EXISTS BOOK_LOANS;
CREATE TABLE BOOK_LOANS (
	Loan_id INT AUTO_INCREMENT PRIMARY KEY,
	Isbn CHAR(10),
	Card_id CHAR(8),
	Date_out DATE,
	Due_date DATE,
	Date_in DATE,
	FOREIGN KEY (Isbn) REFERENCES BOOK(Isbn),
	FOREIGN KEY (Card_id) REFERENCES BORROWER(Card_id)
);

DROP TABLE IF EXISTS FINES;
CREATE TABLE FINES (
	Loan_id INT PRIMARY KEY,
	Fine_amt DECIMAL(6, 2),
	Paid TINYINT(1) DEFAULT 0,
	FOREIGN KEY (Loan_id) REFERENCES BOOK_LOANS(Loan_id)
);

