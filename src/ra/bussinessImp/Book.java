package ra.bussinessImp;

import ra.bussiness.IShop;
import ra.config.InputMethods;

import java.util.List;

public class Book implements IShop,Comparable<Book> {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private Author author;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private boolean bookStatus;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {

    }

    public void inputData(List<Author> authors) {
        System.out.println("Nhap Id");
        this.bookId = InputMethods.getInteger();
        System.out.println("Nhap Name");
        this.bookName = InputMethods.getString();
        System.out.println("Nhap page number");
        this.numberOfPages = InputMethods.getInteger();
        System.out.println("Nhap quantity");
        this.quantity = InputMethods.getInteger();

        // hien thi danh sach
        for (Author au: authors) {
            au.displayData();
        }
        // cho phep nhap
        while (true){
            boolean flag = false;
            System.out.println("Nhap author theo id");
            int authorId = InputMethods.getInteger();
            for (Author au: authors) {
                if(au.getAuthorId()==authorId){
                    this.author=au;
                    flag = true;
                    break;
                }
            }
            if (flag){
                break;
            }
            System.err.println("Id not found");
        }
        System.out.println("Nhap title");
        this.title = InputMethods.getString();
        System.out.println("Nhap gia nhap");
        this.importPrice = InputMethods.getFloat();
        System.out.println("Nhap trang thai");
        this.bookStatus = InputMethods.getBoolean();
        this.exportPrice = this.importPrice*RATE;
    }
    @Override
    public void displayData() {
        System.out.println("Id : "+bookId + "| BookName : "+bookName+" | Author :" +author.getAuthorName()
        +"\n Price : "+exportPrice +"| Quantity : "+quantity+ " | Status :" + (bookStatus?"Ban":"Khong Ban"));
    }

    @Override
    public int compareTo(Book o) {
        return Double.compare(this.exportPrice,o.getExportPrice());
    }
}
