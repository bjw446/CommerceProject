import java.util.InputMismatchException;
import java.util.Scanner;

public class Category {

    Admin admin;
    Cart cart = new Cart();
    Scanner sc = new Scanner(System.in);

    public Category(Admin admin) {
        this.admin = admin;
    }


    public void electronics() {
        for(int i = 0; i < admin.getElectronics().size(); i++){
            Product product = admin.getElectronics().get(i);
            System.out.printf("%-1d. %-15s | %,9d원 | %-1s | %-1s%n", i + 1, product.getName(), product.getPrice(), product.getExplain(), "재고 : " + product.getStock() + "개");
        }
        System.out.printf("%-1d. %-11s%n", 0, "뒤로가기");

        int choice = 0;
        try {
            choice = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력 가능합니다.");
            sc.nextLine();
        }
        if(choice >= 1 && choice <= admin.getElectronics().size()) {
            Product select = admin.getElectronics().get(choice - 1);
            System.out.printf("%-1s %-10s | %,9d원 | %-1s | %-1s%n\n","선택한 상품 :", select.getName(), select.getPrice(), select.getExplain(), "재고 : " + select.getStock() + "개");
            System.out.printf("%-10s | %,9d원 | %-1s%n", select.getName(), select.getPrice(), select.getExplain());
            System.out.println("위 상품을 장바구니에 추가 하시겠습니까?");
            System.out.println("1. 확인      2. 취소");
            int cartChoice = sc.nextInt();
            if(cartChoice == 1) {
                cart.addCart(select);
                sc.nextLine();
            }else {
                System.out.println("잘못된 입력입니다.");
            }
        } else if(choice == 0) {
            return;
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
    public void apparel() {
        for(int i = 0; i < admin.getApparel().size(); i++){
            Product product = admin.getApparel().get(i);
            System.out.printf("%-1d. %-23s | %,9d원 | %-1s | %-1s%n", i + 1, product.getName(), product.getPrice(), product.getExplain(), "재고 : " + product.getStock() + "개");
        }
        System.out.printf("%-1d. %-11s%n", 0, "뒤로가기");

        int choice = 0;
        try {
            choice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력 가능합니다.");
            sc.nextLine();
        }
        if(choice >= 1 && choice <= admin.getApparel().size()){
            Product select = admin.getApparel().get(choice - 1);
            System.out.printf("%-1s %-10s | %,9d원 | %-1s | %-1s%n\n","선택한 상품 :", select.getName(), select.getPrice(), select.getExplain(), "재고 : " + select.getStock() + "개");
            System.out.printf("%-10s | %,9d원 | %-1s%n", select.getName(), select.getPrice(), select.getExplain());
            System.out.println("위 상품을 장바구니에 추가 하시겠습니까?");
            System.out.println("1. 확인      2. 취소");
            int cartChoice = sc.nextInt();
            if(cartChoice == 1) {
                cart.addCart(select);
                sc.nextLine();
            }else {
                System.out.println("잘못된 입력입니다.");
            }
        } else if (choice == 0) {
            return;
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
    public void food() {
        for(int i = 0; i < admin.getFood().size(); i++){
            Product product = admin.getFood().get(i);
            System.out.printf("%-1d. %-28s | %,9d원 | %-1s | %-1s%n", i + 1, product.getName(), product.getPrice(), product.getExplain(), "재고 : " + product.getStock() + "개");
        }
        System.out.printf("%-1d. %-11s%n", 0, "뒤로가기");

        int choice = 0;
        try {
            choice = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력 가능합니다.");
            sc.nextLine();
        }
        if(choice >= 1 && choice <= admin.getFood().size()){
            Product select = admin.getFood().get(choice - 1);
            System.out.printf("%-1s %-10s | %,9d원 | %-1s | %-1s%n\n","선택한 상품 :", select.getName(), select.getPrice(), select.getExplain(), "재고 : " + select.getStock() + "개");
            System.out.printf("%-10s | %,9d원 | %-1s%n", select.getName(), select.getPrice(), select.getExplain());
            System.out.println("위 상품을 장바구니에 추가 하시겠습니까?");
            System.out.println("1. 확인      2. 취소");
            int cartChoice = sc.nextInt();
            if(cartChoice == 1) {
                cart.addCart(select);
                sc.nextLine();
            }else {
                System.out.println("잘못된 입력입니다.");
            }
        } else if (choice == 0) {
            return;
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
}
