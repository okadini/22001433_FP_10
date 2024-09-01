class Account(var balance:Double) {
    def deposit(amount:Double) : Unit = {
        balance += amount
    }

    def withdraw(amount:Double) : Unit = {
        if(amount <= balance)
            balance -= amount
        else 
            throw new IllegalArgumentException("Insufficient funds")
    }

    def transfer(amount:Double,to:Account) : Unit = {
        this.withdraw(amount)
        to.deposit(amount)
    }

    override def toString:String = s"$balance"
}

object AccountTest extends App {
    val account1 = new Account(1000)
    val account2 = new Account(500)

    account1.transfer(200,account2)

    println(s"Balance of account1 : Rs.$account1")
    println(s"Balance of account2 : Rs.$account2")
}