package scales.xml
//import scales.xml._ // using another pacakge and importing doesn't CCE

object CCE_Test extends App {
  // without the import it doesn't trigger the CCE
  import scaley.funny._

  val pull = null.asInstanceOf[Iterator[PullType]]
  val LogEntries = null.asInstanceOf[List[QName]]
  iterate(LogEntries, 
	  pull)
}
