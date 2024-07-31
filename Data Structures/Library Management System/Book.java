class Book implements Comparable<Book> {
    String bookId;
    String title;
    String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{bookId='" + bookId + "', title='" + title + "', author='" + author + "'}";
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
}
