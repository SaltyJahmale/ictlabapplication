package microservices.ictlab.reservation.domain.user

class Admin(firstName: String, email: String, password: String, role: Role) : Person(firstName, email, password, role) {

}