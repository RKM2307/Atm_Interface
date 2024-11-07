The ATM Simulation Program in Java is designed to replicate the basic operations of an Automated Teller Machine (ATM). It allows users to perform various tasks such as checking their account balance, depositing money, withdrawing money, viewing a mini statement (transaction history), changing their PIN, and exiting the system.

When the program starts, the user is prompted to enter a 4-digit PIN for authentication. The user has three attempts to enter the correct PIN. If the user fails to enter the correct PIN after three attempts, the account is locked. The program also handles non-numeric inputs gracefully, ensuring smooth operation even if the user enters invalid data.

After successful authentication, the user is presented with a main menu that lists the available options:

Check account balance
Deposit money
Withdraw money
View mini statement
Change PIN
Exit the system
The user can select any of these options. If they choose to check the balance, the program displays the current balance in the account. For depositing money, the user enters an amount to deposit. The program validates that the amount is positive and ensures it doesn’t exceed ₹100,000. If valid, the amount is added to the balance, and the transaction is recorded in the mini statement. Similarly, for withdrawals, the program ensures the user has sufficient balance, checks if the withdrawal amount is within ₹50,000, and then processes the transaction accordingly, updating the balance and transaction history.

The mini statement option displays all previous transactions (deposits and withdrawals). If no transactions have occurred, the program notifies the user that the transaction history is empty.

For users who wish to change their PIN, the program prompts them to enter the current PIN followed by a new 4-digit PIN. The new PIN must be different from the current one. After the change, the user is required to authenticate using the new PIN for further operations.

To exit the ATM system, the user is prompted to confirm their choice. If the user decides to exit, the program ends; otherwise, they can return to the menu.

The program includes error handling for invalid PIN entries, non-numeric inputs, and invalid transaction amounts (either for deposit or withdrawal). It also ensures the user cannot perform transactions that exceed the balance or transaction limits.

From a security standpoint, the program uses a PIN authentication system, locks the account after three failed attempts, and keeps a record of all transactions in the transaction history for transparency.

In summary, this ATM simulation program provides a comprehensive and secure interface that simulates real-world ATM functionality. It ensures that user transactions are valid, recorded, and that the system behaves securely and efficiently, with options for PIN management and access control.
