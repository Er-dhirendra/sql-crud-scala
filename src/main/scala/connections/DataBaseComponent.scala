package connections


import slick.jdbc.JdbcBackend.Database
import slick.jdbc.JdbcProfile

trait DataBaseComponent {
  val profile: JdbcProfile
  val database: Database
}
