package entity;

public class MyBook {
  private int isbn;
  private String title;
  private String author;
  private String publisher;
  private int year;
  private int totalPages;
  private Integer currentPages = 0;
  private boolean isArchived = false;
  private String activity;
  private boolean status;
    

  

  public MyBook(Integer isbn, String title, String author,String publisher, Integer year, Integer totalPages, boolean archives) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.year = year;
    this.totalPages = totalPages;
    this.isArchived = archives;
  }
  
  public MyBook(int isbn, String title, int totalPages){
    this.isbn = isbn;
    this.title = title;
    this.totalPages = totalPages;
  }
  
  public MyBook(int isbn, String title, boolean status){
    this.isbn = isbn;
    this.title = title;
    this.status = status;
  }

    public MyBook() {
      
    }

  public int getIsbn() {
    return isbn;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getPublisher() {
    return publisher;
  }

  public int getYear() {
    return year;
  }

  public int getTotalPages() {
    return totalPages;
  }

  public int getCurrentPages() {
    return currentPages;
  }

  public void setCurrentPages(int currentPages) {
    this.currentPages = currentPages;
  }

  public boolean isArchived() {
    return isArchived;
  }

  public void setArchived(boolean archived) {
    this.isArchived = archived;
  }

  public String getActivity() {
            return activity;
        }
        
    public void setActivity(String activity) {
        this.activity = activity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}