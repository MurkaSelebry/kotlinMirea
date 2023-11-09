open class Book(val title: String, val author: String)

open class Visitor(title: String, author: String,val id: Int,val name: String) : Book(title, author) {
    var takenBook: Book? = null
    val bookRatings = mutableMapOf<String, MutableList<Int>>()
}


open class Library(title: String,author: String, id: Int, name: String) :Visitor(title,author,id,name){
    private val books = mutableMapOf<String, Book>()
    private val visitors = mutableMapOf<Int, Visitor>()

    fun addBook(book: Book) {
        if (!books.containsKey(book.title)) {
            books[book.title] = book
        }
    }
    fun addVisitor(visitor: Visitor){
        if (!visitors.containsKey(visitor.id)) {
            visitors[visitor.id] = visitor
        }
    }


    fun removeBook(title: String) {
        if (books.containsKey(title) && !isBookTaken(title)) {
            books.remove(title)
        }
    }

    fun findBookByTitle(title: String): Book? {
        return books[title]
    }

    fun findBooksByAuthor(author: String): List<Book> {
        return books.values.filter { it.author == author }
    }

    fun takeBook(title: String, visitorId: Int) {
        val book = findBookByTitle(title)
        val visitor = visitors[visitorId]

        if (book != null && !isBookTaken(title) && visitor?.takenBook == null) {
            visitor?.takenBook = book
            books.remove(title)
        }
    }

    fun returnBook(visitorId: Int, rating: Int) {
        val visitor = visitors[visitorId]

        visitor?.takenBook?.let { book ->
            books[book.title] = book
            visitor.takenBook = null

            val bookTitle = book.title
            visitor.bookRatings.computeIfAbsent(bookTitle) { mutableListOf() }.add(rating)
        }
    }


    private fun isBookTaken(title: String): Boolean {
        return !books.containsKey(title)
    }
    fun printAllBooks() {
        for (book in books.values) {
            println("${book.title} by ${book.author}")
        }
    }
    fun getBookRating(bookTitle: String): Double? {
        val ratings = mutableListOf<Int>()
        for (visitor in visitors.values) {
            visitor.bookRatings[bookTitle]?.let { ratings.addAll(it) }
        }

        if (ratings.isEmpty()) {
            return null
        }

        val averageRating = ratings.average()
        return averageRating
    }

}
fun main() {
    val book1 = Book("Book1", "Author1")
    val book2 = Book("Book2", "Author2")
    val visitor1 = Visitor("Book1", "Author1",1, "Visitor1")
    val visitor2 = Visitor("Book2", "Author2",2, "Visitor2")

    val library = Library(book1.title,book1.author,visitor1.id,visitor1.name)

    library.addBook(book1)
    library.addBook(book2)



    library.addVisitor(visitor1)
    library.addVisitor(visitor2)

    val foundBook1 = library.findBookByTitle("Book1")
    var foundBook2 = library.findBookByTitle("Book2")
    val foundBook3 = library.findBookByTitle("Book3")


    println("Found book 1: ${foundBook1?.title} by ${foundBook1?.author}")
    println("Found book 2: ${foundBook2?.title} by ${foundBook2?.author}")
    println("Found book 3: ${foundBook3?.title} by ${foundBook3?.author}")

    library.takeBook("Book1", 1)
    library.takeBook("Book2", 2)
    foundBook2 = library.findBookByTitle("Book2")
    println("Found book 1: ${foundBook1?.title} by ${foundBook1?.author}")
    println("Found book 2: ${foundBook2?.title} by ${foundBook2?.author}")
    library.returnBook(2,4)
    val booksByAuthor = library.findBooksByAuthor("Author2")
    println("Books by Author2:")
    for (book in booksByAuthor) {
        println("1 ${book.title} by ${book.author}")
    }

    library.returnBook(1,5)
    library.takeBook("Book1", 1)
    library.returnBook(1,10)

    println("---------------------Books in library:")
    library.printAllBooks()

    library.removeBook("Book1")

    // Печать оставшихся книг в библиотеке
    println("----------------------------------Books in library:")
    library.printAllBooks()
    val book1Rating = library.getBookRating("Book1")
    val book2Rating = library.getBookRating("Book2")

    println("Rating for Book1: $book1Rating")
    println("Rating for Book2: $book2Rating")
}
