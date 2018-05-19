package microservices.ictlab.reservation.domain.user

import microservices.ictlab.reservation.domain.scheduling.SimpleReservation
import javax.persistence.*

@Entity
class Student( @Id
               @GeneratedValue(strategy = GenerationType.AUTO)
               val studentId: Long = 0,

               firstName: String,

               email: String,

               password: String,

               role: Role,

               @OneToMany(mappedBy = "student")
               var simpleReservation: List<SimpleReservation>

) : Person(firstName, email, password, role) {


}