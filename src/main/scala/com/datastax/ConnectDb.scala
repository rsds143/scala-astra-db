package datastax

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.ResultSet
import com.datastax.oss.driver.api.core.cql.Row
import java.nio.file.Paths

object ConnectDb {
  def main(args: Array[String]) = {
    if (args.size == 0) {
      println("USAGE: connectdb <securebundlepath> <username> <password> <keyspace>")
    } else {
    val secureBundlePath = args(0)
    val username = args(1)
    val password = args(2)
    val keyspaceName = args(3)
    val session = CqlSession.builder()
      .withCloudSecureConnectBundle(Paths.get(secureBundlePath))
      .withAuthCredentials(username,password)
      .withKeyspace(keyspaceName)
      .build()
    //verify connectivity
      val rs = session.execute("select release_version from system.local");
      val row = rs.one();
      if (row != null) {
        println(row.getString("release_version"));
      } else {
        println("An error occurred.");
      }
      session.close()
    }
  }
}
