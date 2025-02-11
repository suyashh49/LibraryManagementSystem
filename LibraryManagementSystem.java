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