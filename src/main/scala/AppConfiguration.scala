package utils

import java.io.{File, FileInputStream}
import java.util
import org.yaml.snakeyaml.Yaml


trait AppConfiguration {
  private var props : java.util.HashMap[String,String] = new util.HashMap

  var interface = ""
  var port = ""
  var database = ""
  var collection = ""

  def initializeAppConfig(configFilePath : String) : Unit = {

    val fileInputStream = new FileInputStream(new File(configFilePath))
    val confObj = new Yaml().load(fileInputStream)

    props = confObj.asInstanceOf[java.util.HashMap[String,String]]
    interface = props.get("interface")
    port = props.get("port")
    database = props.get("database")
    collection = props.get("collection")

  }
}
