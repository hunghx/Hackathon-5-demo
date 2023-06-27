package ra.bussinessImp;

import ra.bussiness.IShop;
import ra.config.InputMethods;

public class Author implements IShop {
    private int authorId;
    private String authorName;
    private   boolean sex;
    private  int year;

    public Author() {
    }

    public Author(int authorId, String authorName, boolean sex, int year) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.sex = sex;
        this.year = year;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void inputData() {
        System.out.println("Nhap ID");
        this.authorId = InputMethods.getInteger();
        System.out.println("Nhap name");
        this.authorName = InputMethods.getString();
        System.out.println("Nhap sex");
        this.sex = InputMethods.getBoolean();
        System.out.println("Nhap age");
        this.year = InputMethods.getInteger();
    }

    @Override
    public void displayData() {
        System.out.println("ID : "+authorId +" | Name : "+authorName);
    }
}
