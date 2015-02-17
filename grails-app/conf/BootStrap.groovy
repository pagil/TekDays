import com.tekdays.TekEvent

class BootStrap {

    def init = { servletContext ->
        def events = [new TekEvent(name: 'JUG meetup',
                city: 'Melbourne, VIC',
                organizer: 'Kon',
                venue: 'TBD',
                startDate: new Date('21/02/2015'),
                endDate: new Date('21/02/2015'),
                description: 'This conference brings together developers who use Java in their work.'),
                      new TekEvent(name: 'RoR meetup',
                              city: 'Melbourne, VIC',
                              organizer: 'reInteractive',
                              venue: 'TBD',
                              startDate: new Date('25/02/2015'),
                              endDate: new Date('25/02/2015'),
                              description: 'This conference brings together developers who use Ruby on Rails in their work.')]

        events.each {
            if (!it.save()) {
                it.errors.allErrors.eachWithIndex { error, index -> println "An error occurred while saving event${index}: ${error}" }
            }
        }
    }
    def destroy = {
    }
}
