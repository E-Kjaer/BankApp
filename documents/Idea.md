
Idea: A backend application that can store information about users, 
transactions.

#### Functional requirements

| ID      | Name            | Description                                                                                |
| ------- | --------------- | ------------------------------------------------------------------------------------------ |
| F00     | User            | The program should be able to store users information                                      |
| F00.1   | User.Name       | The program should be able to store the full name of the user                              |
| F00.2   | User.Email      | The program should be able to store the email adress of the user                           |
| F00.3   | User.Id         | The program should store a unique id for each user                                         |
| F00.4   | User.Accounts   | The program should store a list of bank accounts associated with the user                  |
| F00.5   | Password/key    | The program should store a keyphrase to validate the user                                  |
| F01     | Account         | The program should be able to store information about an account                           |
| F01.1   | Account.Balance | The program should store the balance of an account                                         |
| F01.1.1 | GetBalance      | The program should be able to return the balance of the account to the user                |
| F01.2   | Withdraw        | The user should be able to withdraw money from the system                                  |
| F01.3   | Deposit         | The user should be able to deposit money into a specified account                          |
| F01.4   | Account.Name    | The program should store the name of the account                                           |
| F01.5   | Account.Id      | The program should store a unique id for each account                                      |
| F01.6   | Transactionlist | The program should store a list of transactions for the account                            |
| F02     | Transaction     | The program should store a transactions                                                    |
| F02.1   | Sender          | The Transaction should know the sender                                                     |
| F02.2   | Reciever        | The Transaction should know the reciever                                                   |
| F02.3   | Amount          | The Transaction should store the amount to be sent                                         |
| F02.4   | Finished        | The Transaction should store state of the transaction, whether the money has been sent     |
| F02.5   | Execute         | The Transaction should have an execute method which changes it's state and sends the money |
|         |                 |                                                                                            |


CRC cards

| User                           |               |
| ------------------------------ | ------------- |
| Responsibility                 | Collaborators |
| - name: String                 | Account       |
| - email: String                |               |
| - id: int                      |               |
| - accounts: ArrayList(Account) |               |
| - password: String             |               |
| - count: int                   |               |

| Account                                |               |
|----------------------------------------| ------------- |
| Responsibility                         | Collaborators |
| - balance: double                      | Transaction   |
| - name: String                         |               |
| - transactions: ArrayList(Transaction) |               |
| - id: int                              |               |
| - count: int                           |               |
| - user: User                           |               |
| + getBalance(): double                 |               |
| + withdraw(double): double             |               |
| + deposit(double): void                |               |

| Transaction           |               |
|-----------------------| ------------- |
| Responsibility        | Collaborators |
| - id: int             | Account              |
| - count: int          |               |
| - sender: Account     |               |
| - reciever: Account   |               |
| - amount: double      |               |
| - isFinished: boolean |               |
| + execute(): void     |               |

