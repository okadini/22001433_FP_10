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

    override def toString:String = s"Balance: $balance"
}

class Bank(val accounts:List[Account]) {
    def negativeBalances:List[Account] = accounts.filter(_.balance < 0)
    
    def totalBalance:Double = accounts.map(_.balance).sum
    
    def applyInterest() : Unit = {
        accounts.foreach { account =>
            if(account.balance > 0) {
                account.deposit(account.balance * 0.05)
            }
            else if(account.balance < 0) {
                account.balance -= account.balance * 0.1
            }
        }
    }
}

object BankTest extends App {
    val acc1 = new Account(1000)
    val acc2 = new Account(-200)
    val acc3 = new Account(500)

    val bank = new Bank(List(acc1,acc2,acc3))

    println(s"Negative balances : ${bank.negativeBalances}")
    println(s"Total balance : ${bank.totalBalance}")

    bank.applyInterest()

    println(s"Final balances : ")
    bank.accounts.foreach { account =>
        println(account)
    }
}