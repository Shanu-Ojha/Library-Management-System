package manager;
import java.util.ArrayList;
import model.*;

public class LibraryManager {
    ArrayList<Book> books = new ArrayList<>();  
    ArrayList<User> users = new ArrayList<>();

    public LibraryManager() {
        books.add(new Book(1001, "The Alchemist", "Paulo Coelho", "HarperOne", 1988, 5, 0));
        books.add(new Book(1002, "To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", 1960, 3, 0));
        books.add(new Book(1003, "1984", "George Orwell", "Secker & Warburg", 1949, 4, 0));
        books.add(new Book(1004, "Pride and Prejudice", "Jane Austen", "T. Egerton", 1813, 6, 0));
        books.add(new Book(1005, "The Hobbit", "J.R.R. Tolkien", "George Allen & Unwin", 1937, 2, 0));
        books.add(new Book(1006, "The Catcher in the Rye", "J.D. Salinger", "Little, Brown and Company", 1951, 4, 0));
        books.add(new Book(1007, "The Great Gatsby", "F. Scott Fitzgerald", "Charles Scribner’s Sons", 1925, 3, 0));
        books.add(new Book(1008, "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Bloomsbury", 1997, 7, 0));
        books.add(new Book(1009, "The Lord of the Rings", "J.R.R. Tolkien", "Allen & Unwin", 1954, 5, 0));
        books.add(new Book(1010, "Animal Farm", "George Orwell", "Secker and Warburg", 1945, 6, 0));
    }

    public void addBook(Book b)
    {
        books.add(b);
    }

    public void addUser(User u)
    {
        users.add(u);
    }

    public void viewAllBooks()
    {
        for(Book b : books)
        {
            System.out.println(b);
        }
    }

    public ArrayList<User> getAllUsers()
    {
        return users;
    }

    public Book getBookbyId(int bookId)
    {
        for(Book b : books)
        {
            if(b.getBookId() == bookId)
            {
                return b;
            }
        }
        return null;
    }

    public User getUserbyId(int userId)
    {
        for(User u : users)
        {
            if(u.getUserId() == userId)
            {
                return u;
            }
        }
        return null;
    }

    public void searchBookByTitle(String t)
    {
        String title = t.toLowerCase();
        boolean found = false;
        for(Book b : books)
        {
            String bookTitle = b.getTitle().toLowerCase();
            if(bookTitle.contains(title))
            {
                found = true;
                System.out.println(b);
            }
        }
        if(!found)
            System.out.println("Books Not Found");
    }

    public void borrowBook(int bookId, int userId)
    {
        Book b = getBookbyId(bookId);
        User u = getUserbyId(userId);
        if(b != null && u != null && b.getAvailableCopies() > 0)
        {
            b.decreaseCopies();
            u.borrowBook(bookId);
            System.out.println("Book borrowed successfully");
        }
        else
        {
            System.out.println("Unable to borrow book");
        }
    }

    public void returnBook(int bookId, int userId)
    {
        Book b = getBookbyId(bookId);
        User u = getUserbyId(userId);
        if(b != null && u != null)
        {
            b.increaseCopies();
            u.returnBook(bookId);
            System.out.println("Book returned successfully");
        }
        else{
            System.out.println("Unable to return book");
        }
    }
}
