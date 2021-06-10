package pl.edu.pwsztar

import spock.lang.Specification;
import spock.lang.Unroll;

class DeleteAccountSpec extends Specification {

    static BankOperation bank;

    def setupSpec() {
        bank = new Bank();
        bank.createAccount()
    }

    @Unroll
    def "should delete account with number #accountNumber and return #balance"() {

        given: "preparing accounts"
        bank.deposit(1, 200)

        when: "the account is deleted"
        def result = bank.deleteAccount(accountNumber)

        then: "check account number"
        result == expectedResult

        where:
        accountNumber  | expectedResult
        1              | 200
        2              | -1
        -1             | -1
        0              | -1
    }


}
