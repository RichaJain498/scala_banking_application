object Main  {
def main(args:Array[String]) : Unit = {
println("-" * 50)

code (args)

 println("." * 50)
 }
def code(args:Array[String]) : Unit = {
 def bankAccount (initialBalance: Int): Symbol => Any = {
  var balance: Int = initialBalance

   val withdraw: Int => Int = amount =>
     if (balance >= amount) {
      balance = balance - amount

      balance 
   } else
     sys.error ("Insufficient funds" )
        val deposit: Int => Int = amount =>
        if(balance >= 1 ){
              balance = balance + amount
              balance
        }else
        sys.error("It's only possible to deposit positive number")
        
        val getBalance: () => Int = () =>
        balance

        val dispatch : Symbol => Any = operation =>
        if(operation == 'withdraw)
           withdraw
        else if(operation == 'deposit)
           deposit
        else if(operation == 'getBalance)
         getBalance
        else
          sys.error("Unknown operation: $operation")
      dispatch
}

  val bankAccount1 = bankAccount (initialBalance = 100)
  
   bankAccount1('withdraw).asInstanceOf[Int => Unit](10)
   println(bankAccount1('getBalance).asInstanceOf[() => Int]())

   bankAccount1('withdraw).asInstanceOf[Int => Unit](15)
   println(bankAccount1('getBalance).asInstanceOf[() => Int]())

   println()
   bankAccount1('deposit).asInstanceOf[Int => Unit](125)
   println(bankAccount1('getBalance).asInstanceOf[() => Int]())

 }
}