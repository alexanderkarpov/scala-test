package coursera.course2.week3.lecture1

/**
  * Created by alexander on 9/19/16.
  */
class BankAccount {

  private var balance = 0;

  def deposit(amount: Int): Unit = if(amount > 0) balance += amount

  def withdraw(amount: Int): Int =
    if(0 < amount && amount <= balance) {
      balance = balance - amount
      balance
    } else throw new Error("insufficient funds")

}
