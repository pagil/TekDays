package com.tekdays

class TekEvent {

    String city
    String name
    TekUser organizer
    String venue
    Date startDate
    Date endDate
    String description

    static constraints = {
        name()
        city()
        description maxSize: 5000
        organizer()
        venue()
        startDate()
        endDate()
    }

    static hasMany = [volunteers: TekUser]

    @Override
    public String toString() {
        return "$name, $city";
    }
}
