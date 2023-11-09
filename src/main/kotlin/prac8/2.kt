package prac8


import java.util.*

interface CardOperations{
    fun makeDeposit(amount: Double): Boolean
    fun makeWithdrawal(amount: Double): Boolean
}
abstract class BankCard(val cardNumber: String, val pin: String): CardOperations {
    abstract fun getBalance(): Double
}



class CreditCard(cardNumber: String, pin: String, val creditLimit: Double) : BankCard(cardNumber, pin) {
    private var debt: Double = 0.0

    override fun getBalance(): Double {
        return creditLimit - debt
    }

    override fun makeDeposit(amount: Double): Boolean {
        debt -= amount
        if(debt<0){
            val enough = kotlin.math.abs(debt)
            println("Лишние деньги $enough")
            debt+=enough
        }
        return true

    }

    override fun makeWithdrawal(amount: Double):Boolean {
        return if(debt+amount<=creditLimit){
            debt+=amount
            true
        } else {
            println("Превышен кредитный лимит")
            false
        }
    }
}

class DebitCard(cardNumber: String, pin: String, val initialBalance: Double = 0.0) : BankCard(cardNumber, pin) {
    private var balance: Double = initialBalance

    override fun getBalance(): Double {
        return balance
    }


    override fun makeDeposit(amount: Double):Boolean {
        balance += amount
        return true
    }

    override fun makeWithdrawal(amount: Double):Boolean {
        return if (amount <= balance) {
            balance -= amount
            true
        } else {
            println("Недостаточно денег!")
            false
        }
    }


}

data class Transaction(val cardNumber: String, val amount: Double, val date: Date, val type: TransactionType, val status: Boolean)

enum class TransactionType {
    WITHDRAWAL, DEPOSIT;
    fun getDisplayName(): String {
        return when (this) {
            WITHDRAWAL -> "Вывод"
            DEPOSIT -> "Депозит"
        }
    }
}
class TransactionProcessor {
    private val transactions = mutableListOf<Transaction>()

    fun makeTransaction(card: BankCard, amount: Double, date: Date, type: TransactionType) {
        when (type) {
            TransactionType.WITHDRAWAL -> transactions.add(Transaction(card.cardNumber, amount, date, TransactionType.WITHDRAWAL, card.makeWithdrawal(amount)))
            TransactionType.DEPOSIT -> transactions.add(Transaction(card.cardNumber, amount, date, TransactionType.DEPOSIT, card.makeDeposit(amount)))
        }
    }

    fun printTransactions(cardNumber: String) {
        val cardTransactions = transactions.filter { it.cardNumber == cardNumber }
        if (cardTransactions.isNotEmpty()) {
            println("Транзакции по $cardNumber:")
            for (transaction in cardTransactions) {
                println("Тип: ${transaction.type.getDisplayName()}, Кол-во: ${transaction.amount}, Дата: ${transaction.date}, Статус: ${transaction.status.toString()}")
            }
        } else {
            println("Транзакций для $cardNumber не найдено")
        }
    }
}

fun main() {
    val creditCard = CreditCard("1234-5678-9012-3456", "1234", 1000.0)
    val debitCard = DebitCard("9876-5432-1098-7654", "5678", 500.0)

    val processor = TransactionProcessor()

    println("Credit Card Баланс: ${creditCard.getBalance()}")
    processor.makeTransaction(creditCard, 300.0, Date(), TransactionType.WITHDRAWAL)
    processor.makeTransaction(creditCard, 500.0, Date(), TransactionType.DEPOSIT)
    processor.printTransactions(creditCard.cardNumber)

    println("Credit Card Баланс после операций: ${creditCard.getBalance()}")

    println("Debit Card Баланс: ${debitCard.getBalance()}")
    processor.makeTransaction(debitCard, 200.0, Date(), TransactionType.DEPOSIT)
    processor.makeTransaction(debitCard, 700.0, Date(), TransactionType.WITHDRAWAL)
    processor.printTransactions(debitCard.cardNumber)

    println("Debit Card Баланс после операций: ${debitCard.getBalance()}")


}
