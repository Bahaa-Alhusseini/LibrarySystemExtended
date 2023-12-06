import java.util.ArrayList;
import java.util.Scanner;

class LibrarySystem {
  private ArrayList<Book> books;
  private ArrayList<Author> authors;
  private ArrayList<Student> students;

  public LibrarySystem() {
    books = new ArrayList<>();
    authors = new ArrayList<>();
    students = new ArrayList<>();
  }

  public void addBook(Book book) {
    books.add(book);
  }

  public void addAuthor(Author author) {
    authors.add(author);
  }

  public void addStudent(Student student) {
    students.add(student);
  }

  public Book searchByTitle(String title) {
    for (Book book : books) {
      if (book.getTitle().equals(title)) {
        return book;
      }
    }
    return null;
  }

  public Book searchByNo(int no) {
    for (Book book : books) {
      if (book.getNo() == no) {
        return book;
      }
    }
    return null;
  }

  public ArrayList<Book> searchByAuthor(String name) {
    ArrayList<Book> result = new ArrayList<>();
    for (Book book : books) {
      if (book.getAuthor().equals(name)) {
        result.add(book);
      }
    }
    return result;
  }

  public void checkLoans() {
    for (Student student : students) {
      System.out.println(student.getName() + " has loaned " + student.getLoans().size() + " books:");
      for (Book book : student.getLoans()) {
        System.out.println(book.getTitle());
      }
      System.out.println();
    }
  }

  public void displayMenu() {
    System.out.println("Library Registration System Menu:");
    System.out.println("1. Search for a book by title");
    System.out.println("2. Search for a book by no");
    System.out.println("3. Search for a book by author name");
    System.out.println("4. Loan a book");
    System.out.println("5. Return a book");
    System.out.println("6. Check the books loans");
    System.out.println("7. Exit the system");
  }

  public void run() {
    Scanner input = new Scanner(System.in);
    boolean exit = false;
    while (!exit) {
      displayMenu();
      int choice = input.nextInt();
      input.nextLine();
      switch (choice) {
        case 1:
          System.out.println("Enter the title of the book you want to search:");
          String title = input.nextLine();
          Book bookByTitle = searchByTitle(title);
          if (bookByTitle != null) {
            System.out.println("The book you are looking for is:");
            System.out.println(bookByTitle.getInfo());
            System.out.println("The book is " + (bookByTitle.inLoan() ? "not available" : "available") + " for loan.");
          } else {
            System.out.println("Sorry, there is no book with that title in the library.");
          }
          break;
        case 2:
          System.out.println("Enter the no of the book you want to search:");
          int no = input.nextInt();
          input.nextLine();
          Book bookByNo = searchByNo(no);
          if (bookByNo != null) {
            System.out.println("The book you are looking for is:");
            System.out.println(bookByNo.getInfo());
            System.out.println("The book is " + (bookByNo.inLoan() ? "not available" : "available") + " for loan.");
          } else {
            System.out.println("Sorry, there is no book with that no in the library.");
          }
          break;
        case 3:
          System.out.println("Enter the name of the author you want to search:");
          String name = input.nextLine();
          ArrayList<Book> booksByAuthor = searchByAuthor(name);
          if (!booksByAuthor.isEmpty()) {
            System.out.println("The books by this author are:");
            for (Book book : booksByAuthor) {
              System.out.println(book.getInfo());
              System.out.println("The book is " + (book.inLoan() ? "not available" : "available") + " for loan.");
              System.out.println();
            }
          } else {
            System.out.println("Sorry, there are no books by this author in the library.");
          }
          break;
        case 4:
          System.out.println("Enter your student ID:");
          int studentId = input.nextInt();
          input.nextLine();
          Student student = null;
          for (Student s : students) {
            if (s.getId() == studentId) {
              student = s;
              break;
            }
          }
          if (student != null) {
            System.out.println("Enter the no of the book you want to loan:");
            int bookNo = input.nextInt();
            input.nextLine();
            Book book = searchByNo(bookNo);
            if (book != null) {
              if (student.loanBook(book)) {
                System.out.println("You have successfully loaned the book " + book.getTitle() + ".");
                System.out.println("You have to return it within 5 days.");
              } else {
                System.out.println("Sorry, you cannot loan this book.");
                System.out.println(
                    "You may have reached the maximum limit of 3 books or the book may be already loaned by someone else.");
              }
            } else {
              System.out.println("Sorry, there is no book with that no in the library.");
            }
          } else {
            System.out.println("Sorry, there is no student with that ID in the library.");
          }
          break;
        case 5:
          System.out.println("Enter your student ID:");
          studentId = input.nextInt();
          input.nextLine();
          student = null;
          for (Student s : students) {
            if (s.getId() == studentId) {
              student = s;
              break;
            }
          }
          if (student != null) {
            System.out.println("Enter the no of the book you want to return:");
            int bookNo = input.nextInt();
            input.nextLine();
            Book book = searchByNo(bookNo);
            if (book != null) {
              if (student.returnBook(book)) {
                System.out.println("You have successfully returned the book " + book.getTitle() + ".");
              } else {
                System.out.println("Sorry, you cannot return this book.");
                System.out.println("You may have not loaned this book or the book may not belong to the library.");
              }
            } else {
              System.out.println("Sorry, there is no book with that no in the library.");
            }
          } else {
            System.out.println("Sorry, there is no student with that ID in the library.");
          }
          break;
        case 6:
          checkLoans();
          break;
        case 7:
          System.out.println("Exiting");
          exit = true;
          break;
        default:
          System.out.println("Please enter a valid option from the menu.");
          break;
      }
    }
    input.close();
  }
}
