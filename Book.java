import java.util.ArrayList;

class Book implements Display {
  private String title;
  private String author;
  private int no;
  private String genre;
  private int version;
  private String date;
  private boolean loaned;

  public Book(String title, String author, int no, String genre, int version, String date) {
    this.title = title;
    this.author = author;
    this.no = no;
    this.genre = genre;
    this.version = version;
    this.date = date;
    this.loaned = false;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public int getNo() {
    return no;
  }

  public String getGenre() {
    return genre;
  }

  public int getVersion() {
    return version;
  }

  public String getDate() {
    return date;
  }

  public void setLoaned(boolean loaned) {
    this.loaned = loaned;
  }

  public String getInfo() {
    return "Title: " + title + "\nAuthor: " + author + "\nNo: " + no + "\nGenre: " + genre + "\nVersion: " + version
        + "\nDate: " + date;
  }

  public boolean inLoan() {
    return loaned;
  }
}
