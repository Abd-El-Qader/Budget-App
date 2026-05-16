BudgetApp - Required Implementation Version

Technology:
- Desktop Application
- Java Swing
- OOP
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
1. User Sign-Up
2. Login
3. Add Transaction
4. Create/Edit Budget
5. Budget Over-Limit Alert
6. Set and Track Financial Goals
7. View Reports and Analytics

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
