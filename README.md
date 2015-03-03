# OutsideInTdd
Exploring Outside In using London and Chicago school of TDD @ Socrates Canaries

##### Objective
Learn and practise the double loop of tdd test application from outside, identifying side effects.

##### Problem Description - Bank Kata
Create a simple bank application with the following features
- Deposit into Account
- Withdraw from Account
- Print a bank statement to the console

##### Acceptance Criteria
Statement should have the following format
```
 | DATE       | AMOUNT  | BALANCE |
 | 10/04/2014 | 500.00  | 1400.00 |
 | 02/04/2014 | -100.00 | 900.00  |
 | 01/04/2014 | 1000.00 | 1000.00 |
```

##### Implementation Guidelines
 **Note:** Start with an acceptance test

```java
      @Test
      public void should_print_statement_containing_all_transactions() {
          account.deposit(1000);
          account.withdraw(100);
          account.deposit(500);

          account.printStatement();

          verify(console).println("DATE | AMOUNT | BALANCE");
          verify(console).println("10/04/2014 | 500.00 | 1400.00");
          verify(console).println("02/04/2014 | -100.00 | 900.00");
          verify(console).println("01/04/2014 | 1000.00 | 1000.00");
      }
```

Tests should be done through the Accounts class.

```java
public class Account {
    public void deposit(int amount);

    public void withdraw(int amount);

    public void printStatement();

 }
```

 This interface can not be changed.


