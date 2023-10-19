
Idea: A backend application that can store information about users, 
transactions.

#### Functional requirements

| ID       | Name               | Description                                                                                           |
| -------- | ------------------ | ----------------------------------------------------------------------------------------------------- |
| F00      | User               | The program should be able to store users information                                                 |
| F00.1    | User.Name          | The program should be able to store the full name of the user                                         |
| F00.2    | User.Email         | The program should be able to store the email adress of the user                                      |
| F00.3    | User.Id            | The program should store a unique id for each user                                                    |
| F00.4    | User.Accounts      | The program should store a list of bank accounts associated with the user                             |
| F00.5    | Password/key       | The program should store a keyphrase to validate the user                                             |
| F01      | Account            | The program should be able to store information about an account                                      |
| F01.1    | Account.Balance    | The program should store the balance of an account                                                    |
| F01.1.1  | GetBalance         | The program should be able to return the balance of the account to the user                           |
| F01.2    | Withdraw           | The user should be able to withdraw money from the system                                             |
| F01.3    | Deposit            | The user should be able to deposit money into a specified account                                     |
| F01.4    | Account.Name       | The program should store the name of the account                                                      |
| F01.5    | Account.Id         | The program should store a unique id for each account                                                 |
| F01.6    | Transactionlist    | The program should store a list of transactions for the account                                       |
| F02      | Transaction        | The program should store a transactions                                                               |
| F02.1    | Sender             | The Transaction should know the sender                                                                |
| F02.2    | Reciever           | The Transaction should know the reciever                                                              |
| F02.3    | Amount             | The Transaction should store the amount to be sent                                                    |
| F02.4    | Finished           | The Transaction should store state of the transaction, whether the money has been sent                |
| F02.5    | Execute            | The Transaction should have an execute method which changes it's state and sends the money            |
| F03      | Command            | The program should contain a command class for translating user input into executing the right method |
| F03.1    | Adminmode          | The commands should have an adminmode                                                                 |
| F03.1.1  | AddUser            | A command for adding a new user to the system                                                         |
| F03.1.2  | DeleteUser         | A command for deleting a user from the system                                                         |
| F03.1.3  | UpdateUser         | A command for updating the specified user                                                             |
| F03.1.4  | AddAccount         | A command for adding an account                                                                       |
| F03.1.5  | DeleteAccount      | A command for deleting an account                                                                     |
| F03.1.6  | UpdateAccount      | A command for updating the specified account                                                          |
| F03.1.7  | AddTransaction     | A command for adding a transaction                                                                    |
| F03.1.8  | DeleteTransaction  | A command for deleting a transaction                                                                  |
| F03.1.9  | UpdateTransaction  | A command for updating the specified transaction                                                      |
| F03.1.10 | ExecuteTransaction | A command for executing the specified transaction                                                                                                      |
| F03.2    | Usermode           | The commands should have a usermode for normal users                                                  |
| F03.2.1  | Deposit            | A command for depositing money into the account                                                       |
| F03.2.2  | Withdraw           | A command for withdrawing money into the account                                                      |
| F03.2.3  | AddUserTransaction     | A command for creating a transaction, from the user's account to another account                      |
| F03.2.4  | ExecuteTransaction | A command for executing the specified transaction.                                                    |


#### CRC cards

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
| --------------------- | ------------- |
| Responsibility        | Collaborators |
| - id: int             | Account       | 
| - count: int          |               |
| - sender: Account     |               |
| - reciever: Account   |               |
| - amount: double      |               |
| - isFinished: boolean |               |
| + execute(): void     |               |

| Command                      |               |
| ---------------------------- | ------------- |
| Responsibility               | Collaborators |
| + enterCommandMode(): void   | User          |
| - enterAdminMode(): void     | Account       |
| - enterUserMode(): void      | Transaction   |
| - addUser(): void            |               |
| - deleteUser(): void         |               |
| - updateUser(): void         |               |
| - addAccount(): void         |               |
| - deleteAccount(): void      |               |
| - updateAccount(): void      |               |
| - addTransaction(): void     |               |
| - deleteTransaction(): void  |               |
| - updateTransaction(): void  |               |
| - executeTransaction(): void |               |
| - deposit(): void            |               |
| - withdraw(): double         |               |
| - addUserTransaction(): void |               |
| - executeTransaction(): void |               |
