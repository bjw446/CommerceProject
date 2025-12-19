import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Category {

    private List<Product> electronics = new ArrayList<>();
    private List<Product> apparel = new ArrayList<>();
    private List<Product> food = new ArrayList<>();
    Cart cart = new Cart();
    Scanner sc = new Scanner(System.in);

    public void electronicsProducts(){
        electronics.add(new Product("Galaxy S24", 1200000, "최신 안드로이드 스마트폰", 50));
        electronics.add(new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 50));
        electronics.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 50));
        electronics.add(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 50));
    }
    public void apparelProducts(){
        apparel.add(new Product("Long Padded Jacket", 110000, "한파에도 따듯한 롱패딩", 50));
        apparel.add(new Product("Overfit Balmacaan coat", 70000, "울 혼방으로 부드러운 롱 코트", 50));
        apparel.add(new Product("HalfZipUp Sweatshirt", 32000, "안감 기모 가을,겨울 맨투맨", 50));
        apparel.add(new Product("Woolen ZipUp", 40000, "따듯하고 부드러운 양털집업", 50));
    }
    public void foodProducts(){
        food.add(new Product("Instant Rice 210g", 31000, "햇반 210g 36개 대용량 묶음상품", 50));
        food.add(new Product("Spam 3Kg", 35000, "스팸 340g 7개 + 80g 8개 묶음상품", 50));
        food.add(new Product("DongWon Tuna 85g", 34000, "동원참치 85g 24개 묶음상품", 50));
        food.add(new Product("DaeCheon Tripe Seaweed 30g", 54000, "대천 곱창김 선물세트 30g 12개 묶음상품", 50));
    }

    public void electronics() {
        for(int i = 0; i < electronics.size(); i++){
            Product product = electronics.get(i);
            System.out.printf("%-1d. %-15s | %,9d원 | %-1s | %-1s%n", i + 1, product.getName(), product.getPrice(), product.getExplain(), "재고 : " + product.getStock() + "개");
        }
        System.out.printf("%-1d. %-11s%n", 0, "뒤로가기");

        int choice = 0;
        try {
            choice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력 가능합니다.");
            sc.nextLine();
        }
        switch (choice) {
            case 1, 2, 3, 4:
                Product select = electronics.get(choice - 1);
                System.out.printf("%-1s %-10s | %,9d원 | %-1s | %-1s%n\n","선택한 상품 :", select.getName(), select.getPrice(), select.getExplain(), "재고 : " + select.getStock() + "개");
                System.out.printf("%-10s | %,9d원 | %-1s%n", select.getName(), select.getPrice(), select.getExplain());
                System.out.println("위 상품을 장바구니에 추가 하시겠습니까?");
                System.out.println("1. 확인      2. 취소");
                int cartChoice = sc.nextInt();
                if(cartChoice == 1) {
                    cart.addProduct(select);
                }
                break;
            case 0 :
                return;
            default :
                System.out.println("잘못된 입력입니다.");
        }
    }
    public void apparel() {
        for(int i = 0; i < apparel.size(); i++){
            Product product = apparel.get(i);
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
        switch (choice) {
            case 1, 2, 3, 4:
                Product select = apparel.get(choice - 1);
                System.out.printf("%-1s %-10s | %,9d원 | %-1s | %-1s%n\n","선택한 상품 :", select.getName(), select.getPrice(), select.getExplain(), "재고 : " + select.getStock() + "개");
                System.out.printf("%-10s | %,9d원 | %-1s%n", select.getName(), select.getPrice(), select.getExplain());
                System.out.println("위 상품을 장바구니에 추가 하시겠습니까?");
                System.out.println("1. 확인      2. 취소");
                int cartChoice = sc.nextInt();
                if(cartChoice == 1) {
                    cart.addProduct(select);
                }
                break;
            case 0 :
                return;
            default :
                System.out.println("잘못된 입력입니다.");
        }
    }
    public void food() {
        for(int i = 0; i < food.size(); i++){
            Product product = food.get(i);
            System.out.printf("%-1d. %-28s | %,9d원 | %-1s | %-1s%n", i + 1, product.getName(), product.getPrice(), product.getExplain(), "재고 : " + product.getStock() + "개");
        }
        System.out.printf("%-1d. %-11s%n", 0, "뒤로가기");

        int choice = 0;
        try {
            choice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력 가능합니다.");
            sc.nextLine();
        }
        switch (choice) {
            case 1, 2, 3, 4:
                Product select = food.get(choice - 1);
                System.out.printf("%-1s %-10s | %,9d원 | %-1s | %-1s%n\n","선택한 상품 :", select.getName(), select.getPrice(), select.getExplain(), "재고 : " + select.getStock() + "개");
                System.out.printf("%-10s | %,9d원 | %-1s%n", select.getName(), select.getPrice(), select.getExplain());
                System.out.println("위 상품을 장바구니에 추가 하시겠습니까?");
                System.out.println("1. 확인      2. 취소");
                int cartChoice = sc.nextInt();
                if(cartChoice == 1) {
                    cart.addProduct(select);
                    return;
                }
                break;
            case 0 :
                return;
            default :
                System.out.println("잘못된 입력입니다.");
        }
    }
}
