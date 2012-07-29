package scales.xml

trait PullType

class QName {
}

trait XmlPull {
  def it : Iterator[PullType]
}

/**
 * Iteratees related to pull parsing
 */ 
trait PullIteratees {

  /**
   * Without the overload it doesn't trigger the CCE, even though its
   * not used
   */ 
  def iterate(path: List[QName], xml: XmlPull): FlatMapIterator[String] = new Iterate(path)
  
  
  class Iterate(path: List[QName]) extends FlatMapIterator[String] { self =>
    var hasonce = false
    def hasNext = !hasonce
    def next = {
      if (!hasonce) {
	  hasonce = true
      }
      "fred"
    }
        
  }

  /**
   * A wrapping around withIter(onDone(List(onQNames(path))))(enumXml(xml, _))
   * it unwraps the data providing an Iterator[XPath]
   */
  def iterate(path: List[QName], xml: Iterator[PullType]): FlatMapIterator[String] =
    new Iterate(path)

}
