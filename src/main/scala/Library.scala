import scala.collection.immutable._

class Library(books: List[Book]){
  var mapBooks: Map[Book, Boolean] = Map()

  def Library(books: List[Book]) {
    for (book <- books)
      mapBooks += (book -> true)
  }

  Library(books)

  def getBook(isbn: String): Report = {
    var record = mapBooks.filter(_._2)
                          .filter(_._1.isbn == isbn)
    if(record.size==0)
      return new Report(Status.NotAvailable, null)

    val book = record.head._1
    mapBooks += (book -> false)
    new Report(Status.Available, book)
  }
  def giveBook(book: Book): Report = {
    var record = mapBooks.filter(_._2==false).filter(_._1.isbn==book.isbn)
    if(record.size!=0) {
      mapBooks += (book -> true)
      return new Report(Status.Available, null)
    }
    else
      new Report(Status.NotAvailable, null)
  }
}
