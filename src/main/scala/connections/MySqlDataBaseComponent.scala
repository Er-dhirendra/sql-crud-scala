package connections


import slick.jdbc.JdbcBackend.Database
trait MySqlDataBaseComponent extends DataBaseComponent {
  val profile = slick.jdbc.MySQLProfile
  val database: Database = Database.forConfig("mysql.db")
}
