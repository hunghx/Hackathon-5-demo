package ra.run;

import ra.bussinessImp.Author;
import ra.bussinessImp.Book;
import ra.config.InputMethods;

import java.util.*;

public class BookManagement {
    static List<Author> authors = new ArrayList<>();
    static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập số tác giả và nhập thông tin các tác giả [10 điểm]\n" +
                    "2. Nhập số sách và nhập thông tin các sách [20 điểm]\n" +
                    "3. Sắp xếp sách theo giá xuất sách tăng dần (Comparable/Comparator) [10 điểm]\n" +
                    "4. Tìm kiếm sách theo tên tác giả sách [05 điểm]\n" +
                    "5. Thoát [05 điểm]");
            System.out.println("Nhap vao lua chon cua ban");
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    addNewAuthor();
                    break;
                case 2:
                    addNewBook();
                    break;
                case 3:
//                    books.sort(Comparator.comparingDouble(Book::getExportPrice));
                    Collections.sort(books);
                    break;
                case 4:
                    searchBookByAuthorName();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.err.println("khong hop le, thu lai");
            }
        }
    }

    public static void addNewAuthor() {
        System.out.println("Nhap so luong can them moi");
        int so = InputMethods.getInteger();
        for (int i = 0; i < so; i++) {
            System.out.println("Nhap thong tin cho tac gia thu " + (i + 1));
            Author author = new Author();
            author.inputData();
            authors.add(author);
        }
    }

    public static void addNewBook() {
        if (authors.isEmpty()){
            System.err.println("khong co tac gia ,vui long them tac gia truoc ");
            return;
        }
            System.out.println("Nhap so luong can them moi");
        int so = InputMethods.getInteger();
        for (int i = 0; i < so; i++) {
            System.out.println("Nhap thong tin cho sach thu " + (i + 1));
            Book book = new Book();
            book.inputData(authors);
            books.add(book);
        }
    }
    public static void searchBookByAuthorName(){
//        List<Book> listSearch = new ArrayList<>();
        boolean check =  false;
        System.out.println("Nhap vao ten tac gia can tim");
        String authorName = InputMethods.getString();
        for (Book b: books) {
            if(b.getAuthor().getAuthorName().toLowerCase().contains(authorName.toLowerCase())){
                b.displayData();
                check= true;
            }
        }
        if (!check){
            System.err.println("Khong tim thay sach thoa man");
        }
    }
}
