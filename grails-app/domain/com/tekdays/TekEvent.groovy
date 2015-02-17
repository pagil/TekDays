package com.tekdays

class TekEvent {

    static constraints = {
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
