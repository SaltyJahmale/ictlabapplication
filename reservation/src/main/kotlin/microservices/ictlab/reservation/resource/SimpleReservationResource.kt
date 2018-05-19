package microservices.ictlab.reservation.resource

import microservices.ictlab.reservation.dao.SimpleReservationDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping(value = ["/simpleReservation"])
class SimpleReservationResource @Autowired constructor(
        val simpleReservationDao: SimpleReservationDao) {


}