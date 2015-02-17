package com.tekdays

class TekEvent {

    static constraints = {
        name()
        city()
        description maxSize: 5000
        organizer()
        venue()
        startDate()
        endDate()
    }

    String city
    String name
    String organizer
    String venue
    Date startDate
    Date endDate
    String description

    @Override
    public String toString() {
        return "TekEvent{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
