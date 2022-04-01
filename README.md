# JAVA-Bank-Accounts
- This project is a JAVA Console App
- It is programmed using core JAVA, using Object-Oriented Programming(OOP)
- OOP helps to keep the JAVA code DRY `Don't Repeat Yourself`, and makes the code easier to maintain, modify and debug


## About the App
- This Java Console app acts like an online Bank
- It allows to you log in into your account(Checkings/Savings)
- It allows you to withdraw and/or deposit money into the account
- A detailed version of problem statement can be found at root level of this repo, file name: `bank_account_problem_statement.pdf`

## Softwares Used
- [Java Runtime Environment - 1.8.0 (JRE)](https://www.java.com/en/download/manual.jsp)
- [Java Development Kit - 17.0.2 (JDK)](https://www.oracle.com/java/technologies/downloads/)
- [Apache Netbeans - 13 - IDE](https://netbeans.apache.org/download/index.html)

## Start the App
- Install all the above mentioned softwares
- Clone the repository
- Open this project in `Apache Netbeans`
- Then open file `JAVA-Bank-Accounts\src\bank_account\Bank_Account.java`
- The above file contains the main JAVA function
- Click on `Run Project` or `F6` to start the game, you should be able to see initial screen as below:

```bash
Hello! Greetings for the day!
Please enter your Account Username:
```

## Classes Created
- `Bank_Account` : This class contains the main class(starting point of this app)
- `CreateDB` : This class handles customer and their respective accounts creation activities
- `Customer` : This class is used to store customer information like: custID, firstName, lastName, location, username, password
- `Account` : This is an abstract class includes deposit and withdrawal activities. Method *withdrawAmount()* is an abstract method inside this class
- `CheckingAcc` : This class handles deposit and withdrawal activities related to a checking account. It also takes care about the abstract method(*withdrawAmount*) implementation
- `SavingAcc` : This class handles deposit and withdrawal activities related to a savings account. It also takes care about the abstract method(*withdrawAmount*) implementation

## Author
[Manali Darji](https://www.linkedin.com/in/manalidarji/)