import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    // Method to add a book
    public void addBook(Book book) {
        books.add(book);
        Collections.sort(books); // Ensure the list is sorted after adding a book
    }

    // Method to perform linear search by title
    public List<Book> linearSearchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    // Method to perform binary search by title (assuming the list is sorted)
    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = books.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Book midBook = books.get(mid);
            int cmp = midBook.title.compareToIgnoreCase(title);
            if (cmp == 0) {
                return midBook;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null; // book not found
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books
        library.addBook(new Book("1", "The Great Gatsby", "F. Scott Fitzgerald"));
        library.addBook(new Book("2", "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("3", "1984", "George Orwell"));
        library.addBook(new Book("4", "The Catcher in the Rye", "J.D. Salinger"));
        library.addBook(new Book("5", "The Hobbit", "J.R.R. Tolkien"));

        // Linear search by title
        System.out.println("Linear Search for '1984':");
        List<Book> linearResult = library.linearSearchByTitle("1984");
        for (Book book : linearResult) {
            System.out.println(book);
        }

        // Binary search by title
        System.out.println("Binary Search for 'The Hobbit':");
        Book binaryResult = library.binarySearchByTitle("The Hobbit");
        System.out.println(binaryResult != null ? binaryResult : "Book not found");
    }
}
