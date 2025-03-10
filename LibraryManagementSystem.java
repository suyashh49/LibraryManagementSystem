import java.util.ArrayList;
import java.util.List;

// abstracting the common properties and method
abstract class LibraryItem {
    private String title;
    private String author;
    private int id;
    private boolean isPresent;

    //getter functions
    public LibraryItem(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.isPresent = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void borrowItem() {
        if (isPresent) {
            isPresent = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    public void returnItem() {
        isPresent = true;
        System.out.println(title + " has been returned.");
    }

    public abstract void displayDetails(); // Abstract method
}


//library items extended in Book and DVD classes

class Book extends LibraryItem {
    private int pageCount;

    //getter functions
    public Book(String title, String author, int id, int pageCount) {
        super(title, author, id);
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    @Override
    public void displayDetails() {
        System.out.println("Book: " + getTitle() + " by " + getAuthor() + ", Pages: " + pageCount);
    }
}

class DVD extends LibraryItem {
    private int duration;

    //getter functions
    public DVD(String title, String author, int id, int duration) {
        super(title, author, id);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public void displayDetails() {
        System.out.println("DVD: " + getTitle() + " by " + getAuthor() + ", Duration: " + duration + " minutes");
    }
}

class Library {
    private List<LibraryItem> items;

    public Library() {
        items = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void showLibraryItems() {
        for (LibraryItem item : items) {
            item.displayDetails();
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        
        Book book1 = new Book("Can love happen twice?", "Ravinder Singh", 1, 218);
        DVD dvd1 = new DVD("Interstellar", "Christopher Nolan", 2, 148);
        
        library.addItem(book1);
        library.addItem(dvd1);
        
        library.showLibraryItems();
        
        book1.borrowItem(); // book is borrowed
        book1.borrowItem(); // book is already borrowed for current reference
        book1.returnItem(); // book is returned
    }
}

