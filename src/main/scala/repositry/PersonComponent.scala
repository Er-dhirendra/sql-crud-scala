package repositry


import connections.{DataBaseComponent, MySqlDataBaseComponent}
import domain.Person

import scala.concurrent.ExecutionContext.Implicits.global

trait PersonComponent {
  this: DataBaseComponent =>

  import profile.api._


  class Persons(tag: Tag) extends Table[Person](tag, "PERSONS") {
    def id = column[Int]("id", O.PrimaryKey)

    def name = column[String]("name")

    def age = column[Int]("age")

    def email = column[String]("email")

    def * = (id, name, age, email) <> (Person.tupled, Person.unapply)

  }

  val persons = TableQuery[Persons]

  private val personAutoInc = persons returning persons.map(_.id)

  def insert(person: Person): DBIO[Person] =
    (personAutoInc += person).map(id => person.copy(id = id))
}

object PersonComponent extends PersonComponent with MySqlDataBaseComponent