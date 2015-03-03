package com.tekdays

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(TekEvent)
class TekEventSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test toString"() {
        when: "a tekEvent has a name and a city"
            def tekEvent = new TekEvent(name: name, city: city, organizer: [fullName: 'John Doe'] as TekUser)
            def tekEvent2 = new TekEvent(name: name, city: city)
        then: "the toString method will combine them"
            tekEvent.toString() == expectedString
            (tekEvent.organizer?.fullName && true) == expectedCmpRes1
            tekEvent2.organizer == null
            tekEvent2.organizer?.fullName == null
            (tekEvent2.organizer?.fullName && true) == expectedCmpRes2
        where:
            name         | city        | organizer   | expectedString          | expectedCmpRes1 | expectedCmpRes2
            'Groovy One' | 'Melbourne' | 'Peter Pen' | 'Groovy One, Melbourne' | true            | false
    }
}
