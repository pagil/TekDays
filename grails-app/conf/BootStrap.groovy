import com.tekdays.Sponsor
import com.tekdays.Sponsorship
import com.tekdays.TekEvent
import com.tekdays.TekUser

class BootStrap {

    def init = { servletContext ->
        def users = [new TekUser(fullName: 'John Doe',
                userName: 'jdoe',
                password: 't0ps3cr3t',
                email: 'jdoe@johnsgroovyshop.com',
                website: 'blog.johnsgroovyshop.com',
                bio: '''John has been programming for over 40 years. He has
                        worked with every programming language known to man
                        and has settled on Groovy. In his spare time, John
                        dabbles in astro physics and plays
                        shuffleboard.''').save(),
                     new TekUser(fullName: 'John Deere',
                             userName: 'tractorman',
                             password: 't0ps3cr3t',
                             email: 'john.deere@porkproducers.org',
                             website: 'www.perl.porkproducers.org',
                             bio: '''John is a top notch Perl programmer and a pretty
                        good hand around the farm. If he can't program it he
                        can plow it!''').save()]
        persistList(users, 'event')

        def events = [new TekEvent(name: 'JUG meetup',
                city: 'Melbourne, VIC',
                organizer: TekUser.findByFullName('John Doe'),
                venue: 'TBD',
                startDate: new Date('21/02/2015'),
                endDate: new Date('21/02/2015'),
                description: 'This conference brings together developers who use Java in their work.'),
                      new TekEvent(name: 'RoR meetup',
                              city: 'Melbourne, VIC',
                              organizer: TekUser.findByFullName('John Deere'),
                              venue: 'TBD',
                              startDate: new Date('25/02/2015'),
                              endDate: new Date('25/02/2015'),
                              description: 'This conference brings together developers who use Ruby on Rails in their work.')]

        persistList(events, 'event')

        def g1 = TekEvent.findByName('JUG meetup')
        g1.addToVolunteers(new TekUser(fullName: 'Sarah Martin',
                userName: 'sarah',
                password: '54321',
                email: 'sarah@martinworld.com',
                website: 'www.martinworld.com',
                bio: 'Web designer and Grails afficianado.'))
        g1.addToVolunteers(new TekUser(fullName: 'Bill Smith',
                userName: 'Mr_Bill',
                password: '12345',
                email: 'mrbill@email.com',
                website: 'www.mrbillswebsite.com',
                bio: 'Software developer, claymation artist.'))
        g1.addToResponders('mad@tut.by')
        g1.addToResponders('mex@mail.ru')
        g1.addToResponders('max@gmail.com')
        g1.save()

        def s1 = new Sponsor(name: 'Contegix',
                website: 'http://www.contegix.com',
                description: 'Beyond Managed Hosting for your Enterprise').save()

        def s2 = new Sponsor(name: 'Object Computing Incorporated',
                website: 'http://ociweb.com',
                description: 'An OO Software Engineering Company'
        ).save()
        def sp1 = new Sponsorship(event: g1,
                sponsor: s1,
                contributionType: 'Other',
                description: 'Cool T-Shirts').save()
        def sp2 = new Sponsorship(event: g1,
                sponsor: s2,
                contributionType: 'Venue',
                description: 'Will be paying for the Moscone').save()

    }

    def destroy = {
    }

    def persistList(def items, itemName) {
        items.each {
            if (!it.save()) {
                it.errors.allErrors.eachWithIndex { item, index -> println "An error occurred while saving ${itemName}${index}: ${item}" }
            }
        }
    }
}
