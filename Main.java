import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Author author = createAuthor(scanner);

        System.out.println();

        Book book = createBook(scanner, author);

        LibrarySystem ls = new LibrarySystem();

        ls.addAuthor(author);
        ls.addBook(book);

        ls.run();

        scanner.close();
    }

    private static Author createAuthor(Scanner scanner) {
        System.out.print("Author ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Author name: ");
        String name = scanner.nextLine();
        System.out.print("Author address: ");
        String address = scanner.nextLine();
        System.out.print("Author birth date: ");
        String birthDate = scanner.nextLine();

        return new Author(id, name, address, birthDate);
    }

    private static Book createBook(Scanner scanner, Author author) {
        System.out.print("Book title: ");
        String title = scanner.nextLine();
        System.out.print("Book genre: ");
        String genre = scanner.nextLine();
        System.out.print("Book version: ");
        int version = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Book date: ");
        String date = scanner.nextLine();

        return new Book(title, author.getName(), 1, genre, version, date);
    }
}
