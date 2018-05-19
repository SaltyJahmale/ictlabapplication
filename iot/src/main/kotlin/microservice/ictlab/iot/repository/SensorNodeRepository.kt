package microservice.ictlab.iot.repository

import microservice.ictlab.iot.domain.node.SensorNode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SensorNodeRepository: JpaRepository<SensorNode, String>