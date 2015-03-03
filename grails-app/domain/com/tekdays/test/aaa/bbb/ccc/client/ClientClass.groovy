package com.tekdays.test.aaa.bbb.ccc.client

import com.tekdays.test.pack.Dealer

class ClientClass {
    public static void main(String[] args) {
        def obj = Dealer.getDealer()
        println obj.method1()
        println obj.method2()
    }
}
