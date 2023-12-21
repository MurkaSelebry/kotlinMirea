package murad

data class Book(val title: String, val author: String)
val library = sequenceOf(
    Book("The Great Gatsby", "F. Scott Fitzgerald"),
    Book("To Kill a Mockingbird", "Harper Lee"),
    Book("1984", "George Orwell"),
    Book("The Catcher in the Rye", "J.D. Salinger"),
    Book("The Lord of the Rings", "J.R.R. Tolkien"),
    Book("The Hobbit", "J.R.R. Tolkien"),
    Book("The Da Vinci Code", "Dan Brown"),
    Book("The Girl with the Dragon Tattoo", "Stieg Larsson"),
    Book("The Hunger Games", "Suzanne Collins"),
    Book("The Fault in Our Stars", "John Green")
)


fun main() {
    val uniqueAuthors = library.map { it.author }.toSet()
    println("Уникальные авторы:")
    uniqueAuthors.forEach{author -> println(author)}

    val author = "J.R.R. Tolkien"
    val booksByAuthor = library.filter { it.author == author }.toList()
    println("Книги от $author")
    booksByAuthor.forEach{book -> println(book)}

}