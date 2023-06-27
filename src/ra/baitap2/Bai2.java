package ra.baitap2;

import ra.config.InputMethods;

import java.util.Stack;

public class Bai2 {
    public static void main(String[] args) {
        Stack<String> urls = new Stack<>();
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập URL muốn truy cập\n" +
                    "2. Quay lại\n" +
                    "3. Thoát");
            System.out.println("Nhap vao lua chon cua ban");
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    // truy cap 1 dia chi web
                    System.out.println("Nhap vao tranng ban muon dieu huong");
                    String url = InputMethods.getString();
                    urls.push(url);
                    System.out.println("Ban dang o trang "+url);
                    break;
                case 2:
                    // quay lai trang truoc
                    if (urls.empty()){
                        System.err.println("khong the quay lai them nua");
                    }else {
                        urls.pop();
                        System.out.println("ban dang o " +urls.peek());
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("khong hop le");
            }
        }
    }
}
