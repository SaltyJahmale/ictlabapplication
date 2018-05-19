package microservices.ictlab.reservation.domain.scheduling

import microservices.ictlab.reservation.domain.user.Student
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class SimpleReservation (
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val simpleReservationId: Long = 0,

        @get: NotBlank
        val email: String,

        @get: NotBlank
        val startDateTime: LocalDateTime,

        @get: NotBlank
        val endDateTime: LocalDateTime

) {
    @ManyToOne
    lateinit var student: Student

}