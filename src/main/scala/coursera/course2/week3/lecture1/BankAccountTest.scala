package coursera.course2.week3.lecture1

/**
  * Created by alexander on 9/19/16.
  */
object BankAccountTest extends App{

  val acct = new BankAccount
  acct deposit 50
  acct withdraw 20
  acct withdraw 20
  acct withdraw 15

}
