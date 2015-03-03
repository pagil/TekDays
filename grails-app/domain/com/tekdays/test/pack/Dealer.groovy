package com.tekdays.test.pack

class Dealer extends SellerAbstract {
    @Override
    protected def method1() {
        return 'Dealer implementation'
    }

    private def method2() {
        return 'I am private!!! You cannot see me!!!'
    }

    static Dealer getDealer() {
        return new Dealer()
    }
}
