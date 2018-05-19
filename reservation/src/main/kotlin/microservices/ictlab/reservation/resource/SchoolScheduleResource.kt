package microservices.ictlab.reservation.resource

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/schoolSchedule"])
class SchoolScheduleResource (val schoolScheduleResource: SchoolScheduleResource) {

    fun createSchoolSchedule() {

    }

}