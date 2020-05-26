import org.scalatest.FunSuite
import scala.collection.immutable._

class LibraryTest extends FunSuite {

  test("intersect is invoked on a non-empty stack") {
    val baseBooks = List(
      Book("War and Peace", "Leo Tolstoy", "9780786160563"),
      Book("Test1", "", "4"),
      Book("Test2", "", "3"),
      Book("Test3", "", "2"),
      Book("Test4", "", "1")
    )
    val library = new Library(baseBooks)

    val report1 = library.getBook("9780786160563")
    assert(report1.stat === Status.Available && report1.book.isbn === "9780786160563")

    val report2 = library.getBook("978563")
    assert(report2.stat === Status.NotAvailable && report2.book === null)

    val book = Book("War and Peace", "", "9780786160563")
    val report3 = library.giveBook(book)
    assert(report3.stat === Status.Available && report3.book === null)

    val book2 = Book("Test2", "", "3123")
    val report4 = library.giveBook(book2)
    assert(report4.stat === Status.NotAvailable && report4.book === null)
  }
}