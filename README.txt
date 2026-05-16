<<<<<<< HEAD
BudgetApp - Required Implementation Version
=======
BudgetApp - Final Version Without External Libraries
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf

Technology:
- Desktop Application
- Java Swing
- OOP
<<<<<<< HEAD
- SQLite Database

Project Structure:
src/database:
- DBConnection.java
- DatabaseInitializer.java

src/model:
- User.java
- Transaction.java
- Budget.java
- Goal.java

src/repository:
- UserRepository.java
- TransactionRepository.java
- BudgetRepository.java
- GoalRepository.java

src/service:
- AuthService.java
- TransactionService.java
- BudgetService.java
- GoalService.java
- ReportService.java

src/ui:
- MainFrame.java

src:
- Main.java

Implemented First 7 User Stories from the SRS:
=======
- File Persistence

Important:
This version does not need sqlite-jdbc.jar.
It stores data in text files:
- users.txt
- transactions.txt
- budgets.txt
- goals.txt

Implemented First 7 User Stories:
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
1. User Sign-Up
2. Login
3. Add Transaction
4. Create/Edit Budget
5. Budget Over-Limit Alert
6. Set and Track Financial Goals
7. View Reports and Analytics

<<<<<<< HEAD
Requirement Mapping:
- Supports OOP through model, repository, service, and UI layers.
- Persists data using SQLite database.
- Loads stored data from previous runs through repository getAll methods and the Load Saved Data button.
- Desktop technology is Java Swing.
- Main.java starts the desktop GUI.

How to Run:
1. Open the project in your Java IDE.
2. Make sure sqlite-jdbc is added to the project libraries.
3. Run src/Main.java.
=======
How to Run:
Open terminal inside the project folder and run:

javac -cp "src" src/Main.java
java -cp "src" Main

This version satisfies the requirement because the assignment accepts persistence using a Database OR files.
Updated by 20114
>>>>>>> 91424dc46448f39f46604c85f5c8d446ef4d53cf
