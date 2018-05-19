package microservices.ictlab.reservation.domain.notification

interface SubjectType {
    fun addObserver()
    fun deleteObserver()
    fun notifyObserver()
}