package pl.edu.pwsztar

import spock.lang.Specification
import spock.lang.Unroll

class WithdrawSpec extends Specification{
    static BankOperation bank;

    def setupSpec() {
        bank = new Bank()
        bank.createAccount()

    }

    @Unroll
    def "should add #amount to account with number #accountNumber if exists return true if not return false"() {

        given: "preparing accounts"
        bank.deposit(1, 200)

        when: "the account is deleted"
        def result = bank.deposit(accountNumber, amount)

        then: "check account number"
        result == expectedResult

        where:
        amount  | accountNumber  | expectedResult
        200     | 1              | true
        -200    | 1              | false
        0       | 1              | false
        200     | 1000           | false
        200     | -1             | false
    }
}
