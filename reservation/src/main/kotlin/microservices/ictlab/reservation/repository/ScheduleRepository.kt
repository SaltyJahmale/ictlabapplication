package microservices.ictlab.reservation.repository

import microservices.ictlab.reservation.dao.SchoolScheduleDao
import org.springframework.data.repository.CrudRepository

interface ScheduleRepository : CrudRepository<SchoolScheduleDao, Long> {

}