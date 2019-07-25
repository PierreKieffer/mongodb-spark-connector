import utils.AppConfiguration

object mainMongoConnector extends AppConfiguration{

  def main(args: Array[String]): Unit = {

    initializeAppConfig(args(0))

    val mongodb_input_uri = "mongodb://" + interface + ":" + port + "/" + database + "." + collection
    val mongodb_output_uri = "mongodb://" + interface + ":" + port + "/" + database + "." + collection

    val sparkSession = org.apache.spark.sql.SparkSession.builder
      .master("local")
      .appName("MongoSparkConnectorIntro")
      .config("spark.mongodb.input.uri", mongodb_input_uri)
      .config("spark.mongodb.output.uri", mongodb_output_uri)
      .getOrCreate()

    sparkSession.sparkContext.setLogLevel("ERROR")

  }

}
