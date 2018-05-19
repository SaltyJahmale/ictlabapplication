package microservices.ictlab.reservation.repository

import microservices.ictlab.reservation.dao.SimpleReservationDao
import org.springframework.data.jpa.repository.JpaRepository

interface ReservationRepository : JpaRepository<SimpleReservationDao, Long> {
}