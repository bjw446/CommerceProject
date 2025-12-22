import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Category {

    Admin admin;
    Cart cart = new Cart();
    Scanner sc = new Scanner(System.in);


    public Category(Admin admin) {
        this.admin = admin;
    }


    public void electronics() {
        System.out.println("[ 전자제품 카테고리 ]");
        System.out.println("1. 전체 상품 보기");
        System.out.println("2. 가격대별 필터링 (100만원 이하)");
        System.out.println("3. 가격대별 필터링 (100만원 초과)");
        System.out.println("0. 뒤로가기");
        int filterChoice;

        int menu = 0;
        try {
            menu = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력 가능합니다.");
            sc.nextLine();
        }
        switch (menu) {
            case 1 :
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
                    }else if(cartChoice == 2){
                        return;
                    }else {
                        System.out.println("잘못된 입력입니다.");
                    }
                } else if(choice == 0) {
                    return;
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
                break;
            case 2 :
                List<Product> electronicFilter = admin.getElectronics().stream()
                        .filter(p -> p.getPrice() <= 1000000)
                        .collect(Collectors.toList());
                for(int i = 0; i < electronicFilter.size(); i++) {
                    Product filter = electronicFilter.get(i);
                    System.out.printf("%-1d. %-15s | %,9d원 | %-1s | %-1s%n", i + 1, filter.getName(), filter.getPrice(), filter.getExplain(), "재고 : " + filter.getStock() + "개");
                }
                System.out.println("0. 뒤로가기");
                filterChoice = sc.nextInt();
                sc.nextLine();
                if (filterChoice >= 1 && filterChoice <= electronicFilter.size()) {
                    Product select = electronicFilter.get(filterChoice - 1);
                    System.out.printf("%-1s %-10s | %,9d원 | %-1s | %-1s%n\n","선택한 상품 :", select.getName(), select.getPrice(), select.getExplain(), "재고 : " + select.getStock() + "개");
                    System.out.println("위 상품을 장바구니에 추가 하시겠습니까?");
                    System.out.println("1. 확인      2. 취소");
                    int cartChoice = sc.nextInt();
                    if(cartChoice == 1) {
                        cart.addCart(select);
                        sc.nextLine();
                    }else if(cartChoice == 2){
                        return;
                    }else {
                        System.out.println("잘못된 입력입니다.");
                    }
                }else if(filterChoice == 0) {
                    return;
                }else {
                    System.out.println("잘못된 입력입니다.");
                }
                break;
            case 3 :
                List<Product> electronicFilter2 = admin.getElectronics().stream()
                        .filter(p -> p.getPrice() > 1000000)
                        .collect(Collectors.toList());
                for(int i = 0; i < electronicFilter2.size(); i++) {
                    Product filter = electronicFilter2.get(i);
                    System.out.printf("%-1d. %-15s | %,9d원 | %-1s | %-1s%n", i + 1, filter.getName(), filter.getPrice(), filter.getExplain(), "재고 : " + filter.getStock() + "개");
                }
                System.out.println("0. 뒤로가기");
                filterChoice = sc.nextInt();
                sc.nextLine();
                if (filterChoice >= 1 && filterChoice <= electronicFilter2.size()) {
                    Product select = electronicFilter2.get(filterChoice - 1);
                    System.out.printf("%-1s %-10s | %,9d원 | %-1s | %-1s%n\n","선택한 상품 :", select.getName(), select.getPrice(), select.getExplain(), "재고 : " + select.getStock() + "개");
                    System.out.println("위 상품을 장바구니에 추가 하시겠습니까?");
                    System.out.println("1. 확인      2. 취소");
                    int cartChoice = sc.nextInt();
                    if(cartChoice == 1) {
                        cart.addCart(select);
                        sc.nextLine();
                    }else if(cartChoice == 2){
                        return;
                    }else {
                        System.out.println("잘못된 입력입니다.");
                    }
                }else if(filterChoice == 0) {
                    return;
                }else {
                    System.out.println("잘못된 입력입니다.");
                }
                break;
            case 0 :
                return;
            default :
                System.out.println("잘못된 입력입니다.");

        }

    }
    public void apparel() {
        System.out.println("[ 의류 카테고리 ]");
        System.out.println("1. 전체 상품 보기");
        System.out.println("2. 가격대별 필터링 (10만원 이하)");
        System.out.println("3. 가격대별 필터링 (10만원 초과)");
        System.out.println("0. 뒤로가기");
        int filterChoice;

        int menu = 0;
        try {
            menu = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력 가능합니다.");
            sc.nextLine();
        }
        switch (menu) {
            case 1 :
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
                    }else if(cartChoice == 2){
                        return;
                    }else {
                        System.out.println("잘못된 입력입니다.");
                    }
                } else if (choice == 0) {
                    return;
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
                break;
            case 2 :
                List<Product> apparelFilter = admin.getApparel().stream()
                        .filter(p -> p.getPrice() <= 100000)
                        .collect(Collectors.toList());
                for(int i = 0; i < apparelFilter.size(); i++) {
                    Product filter = apparelFilter.get(i);
                    System.out.printf("%-1d. %-23s | %,9d원 | %-1s | %-1s%n", i + 1, filter.getName(), filter.getPrice(), filter.getExplain(), "재고 : " + filter.getStock() + "개");
                }
                System.out.println("0. 뒤로가기");
                filterChoice = sc.nextInt();
                sc.nextLine();
                if (filterChoice >= 1 && filterChoice <= apparelFilter.size()) {
                    Product select = apparelFilter.get(filterChoice - 1);
                    System.out.printf("%-1s %-10s | %,9d원 | %-1s | %-1s%n\n","선택한 상품 :", select.getName(), select.getPrice(), select.getExplain(), "재고 : " + select.getStock() + "개");
                    System.out.println("위 상품을 장바구니에 추가 하시겠습니까?");
                    System.out.println("1. 확인      2. 취소");
                    int cartChoice = sc.nextInt();
                    if(cartChoice == 1) {
                        cart.addCart(select);
                        sc.nextLine();
                    }else if(cartChoice == 2){
                        return;
                    }else {
                        System.out.println("잘못된 입력입니다.");
                    }
                }else if(filterChoice == 0) {
                    return;
                }else {
                    System.out.println("잘못된 입력입니다.");
                }
                break;
            case 3 :
                List<Product> apparelFilter2 = admin.getApparel().stream()
                        .filter(p -> p.getPrice() > 100000)
                        .collect(Collectors.toList());
                for(int i = 0; i < apparelFilter2.size(); i++) {
                    Product filter = apparelFilter2.get(i);
                    System.out.printf("%-1d. %-23s | %,9d원 | %-1s | %-1s%n", i + 1, filter.getName(), filter.getPrice(), filter.getExplain(), "재고 : " + filter.getStock() + "개");
                }
                System.out.println("0. 뒤로가기");
                filterChoice = sc.nextInt();
                sc.nextLine();
                if (filterChoice >= 1 && filterChoice <= apparelFilter2.size()) {
                    Product select = apparelFilter2.get(filterChoice - 1);
                    System.out.printf("%-1s %-10s | %,9d원 | %-1s | %-1s%n\n","선택한 상품 :", select.getName(), select.getPrice(), select.getExplain(), "재고 : " + select.getStock() + "개");
                    System.out.println("위 상품을 장바구니에 추가 하시겠습니까?");
                    System.out.println("1. 확인      2. 취소");
                    int cartChoice = sc.nextInt();
                    if(cartChoice == 1) {
                        cart.addCart(select);
                        sc.nextLine();
                    }else if(cartChoice == 2){
                        return;
                    }else {
                        System.out.println("잘못된 입력입니다.");
                    }
                }else if(filterChoice == 0) {
                    return;
                }else {
                    System.out.println("잘못된 입력입니다.");
                }
                break;
            case 0 :
                return;
            default :
        }

    }
    public void food() {
        System.out.println("[ 식품 카테고리 ]");
        System.out.println("1. 전체 상품 보기");
        System.out.println("2. 가격대별 필터링 (5만원 이하)");
        System.out.println("3. 가격대별 필터링 (5만원 초과)");
        System.out.println("0. 뒤로가기");
        int filterChoice;

        int menu = 0;
        try {
            menu = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력 가능합니다.");
            sc.nextLine();
        }
        switch (menu) {
            case 1 :
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
                    }else if(cartChoice == 2){
                        return;
                    }else {
                        System.out.println("잘못된 입력입니다.");
                    }
                } else if (choice == 0) {
                    return;
                } else {
                    System.out.println("잘못된 입력입니다.");
                }
                break;
            case 2 :
                List<Product> foodFilter = admin.getFood().stream()
                        .filter(p -> p.getPrice() <= 50000)
                        .collect(Collectors.toList());
                for(int i = 0; i < foodFilter.size(); i++) {
                    Product filter = foodFilter.get(i);
                    System.out.printf("%-1d. %-28s | %,9d원 | %-1s | %-1s%n", i + 1, filter.getName(), filter.getPrice(), filter.getExplain(), "재고 : " + filter.getStock() + "개");
                }
                System.out.println("0. 뒤로가기");
                filterChoice = sc.nextInt();
                sc.nextLine();
                if (filterChoice >= 1 && filterChoice <= foodFilter.size()) {
                    Product select = foodFilter.get(filterChoice - 1);
                    System.out.printf("%-1s %-10s | %,9d원 | %-1s | %-1s%n\n","선택한 상품 :", select.getName(), select.getPrice(), select.getExplain(), "재고 : " + select.getStock() + "개");
                    System.out.println("위 상품을 장바구니에 추가 하시겠습니까?");
                    System.out.println("1. 확인      2. 취소");
                    int cartChoice = sc.nextInt();
                    if(cartChoice == 1) {
                        cart.addCart(select);
                        sc.nextLine();
                    }else if(cartChoice == 2){
                        return;
                    }else {
                        System.out.println("잘못된 입력입니다.");
                    }
                }else if(filterChoice == 0) {
                    return;
                }else {
                    System.out.println("잘못된 입력입니다.");
                }
                break;
            case 3 :
                List<Product> foodFilter2 = admin.getFood().stream()
                        .filter(p -> p.getPrice() > 50000)
                        .collect(Collectors.toList());
                for(int i = 0; i < foodFilter2.size(); i++) {
                    Product filter = foodFilter2.get(i);
                    System.out.printf("%-1d. %-28s | %,9d원 | %-1s | %-1s%n", i + 1, filter.getName(), filter.getPrice(), filter.getExplain(), "재고 : " + filter.getStock() + "개");
                }
                System.out.println("0. 뒤로가기");
                filterChoice = sc.nextInt();
                sc.nextLine();
                if (filterChoice >= 1 && filterChoice <= foodFilter2.size()) {
                    Product select = foodFilter2.get(filterChoice - 1);
                    System.out.printf("%-1s %-10s | %,9d원 | %-1s | %-1s%n\n","선택한 상품 :", select.getName(), select.getPrice(), select.getExplain(), "재고 : " + select.getStock() + "개");
                    System.out.println("위 상품을 장바구니에 추가 하시겠습니까?");
                    System.out.println("1. 확인      2. 취소");
                    int cartChoice = sc.nextInt();
                    if(cartChoice == 1) {
                        cart.addCart(select);
                        sc.nextLine();
                    }else if(cartChoice == 2){
                        return;
                    }else {
                        System.out.println("잘못된 입력입니다.");
                    }
                }else if(filterChoice == 0) {
                    return;
                }else {
                    System.out.println("잘못된 입력입니다.");
                }
                break;
            case 0 :
                return;
            default :
        }
    }
}
