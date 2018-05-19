package microservices.ictlab.reservation.domain.notification

interface ObserverType {
    fun notifyObserver()
    fun subscribe()
    fun unsubscribe()
}