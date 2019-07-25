import org.apache.spark.sql.{DataFrame, SparkSession}

object mongoSparkService {

  def writeData(sparkSession: SparkSession, dataframe : DataFrame)= {
    dataframe.write.format("com.mongodb.spark.sql.DefaultSource").mode("append").save()
  }

  def readData(sparkSession: SparkSession): DataFrame = {
    val data = sparkSession.read.format("com.mongodb.spark.sql.DefaultSource").load()

    data

  }
}
