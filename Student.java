import java.util.ArrayList;

class Student {
  private int id;
  private String name, address, birthDate, major;
  private ArrayList<Book> loans;

  public Student(int id, String name, String address, String birthDate, String major) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.birthDate = birthDate;
    this.major = major;
    this.loans = new ArrayList<>();
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public String getMajor() {
    return major;
  }

  public ArrayList<Book> getLoans() {
    return loans;
  }

  public String getInfo() {
    return "ID: " + id + "\nName: " + name + "\nAddress: " + address + "\nBirth Date: " + birthDate
        + "\nMajor: " + major + "\nLoans: " + loans.size();
  }

  public boolean loanBook(Book book) {
    if (loans.size() < 3 && !book.inLoan()) {
      loans.add(book);
      book.setLoaned(true);
      return true;
    } else {
      return false;
    }
  }

  public boolean returnBook(Book book) {
    if (loans.contains(book) && book.inLoan()) {
      loans.remove(book);
      book.setLoaned(false);
      return true;
    } else {
      return false;
    }
  }
}
