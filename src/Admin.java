import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Admin {

    private List<Product> food = new ArrayList<>();
    private List<Product> apparel = new ArrayList<>();
    private List<Product> electronics = new ArrayList<>();
    private String id;
    private String password;
    Scanner sc = new Scanner(System.in);
    Cart cart;

    public Admin(Cart cart){
        this.id = "admin";
        this.password = "admin1234";
        this.cart = cart;
    }

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

    public boolean login() {
       for(int i = 0; i < 3; i++) {
           System.out.println("관리자 비밀번호를 입력해주세요.");
           String loginPassword = sc.next();
           if(loginPassword.equals(password)) {
               return true;
           } else {
               System.out.println("비밀번호를 잘못 입력하셨습니다.");
           }
       }
        System.out.println("비밀번호를 3회 잘못 입력하셨습니다. 메인 메뉴로 돌아갑니다.");
        return false;
    }

    public void adminMenu() {
        while(true) {
            System.out.println("[ 관리자 모드 ]");
            System.out.println("1. 상품 추가");
            System.out.println("2. 상품 수정");
            System.out.println("3. 상품 삭제");
            System.out.println("4. 전체 상품 현황");
            System.out.println("0. 메인으로 돌아가기");
            int choice = 0;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력 가능합니다.");
                sc.nextLine();
            }
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    editProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    printAllProucts();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
    public void addProduct() {
        String productName;
        int productPrice;
        String productExplain;
        int productStock;
        System.out.println("어느 카테고리에 상품을 추가하시겠습니까?");
        System.out.println("1. 전자제품");
        System.out.println("2. 의류");
        System.out.println("3. 식품");

        int choice = 0;
        int choice2;
        try {
            choice = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력 가능합니다.");
            sc.nextLine();
        }
        switch (choice) {
            case 1 :
                System.out.println("[ 전자제품 카테고리에 상품 추가 ]");
                System.out.print("상품명을 입력해주세요 : ");
                productName = sc.nextLine();
                System.out.print("가격을 입력해주세요 : ");
                productPrice = sc.nextInt();
                sc.nextLine();
                System.out.print("상품 설명을 입력해주세요 : ");
                productExplain = sc.nextLine();
                System.out.print("재고 수량을 입력해주세요 : ");
                productStock = sc.nextInt();
                sc.nextLine();

                System.out.printf("%-1s | %,1d원 | %-1s | %-1s%n",productName, productPrice, productExplain, "재고 : " + productStock + "개");
                System.out.println("위 정보로 상품을 추가 하시겠습니까?");
                System.out.println("1. 확인    2. 취소");
                choice2 = sc.nextInt();
                if(choice2 == 1) {
                    for (int i = 0; i < electronics.size(); i++) {
                        Product product = electronics.get(i);
                        if(productName.equals(product.getName())) {
                            System.out.println("동일한 이름의 상품이 이미 존재합니다.");
                            return;
                        }
                    }
                    for (int i = 0; i < apparel.size(); i++) {
                        Product product = apparel.get(i);
                        if(productName.equals(product.getName())) {
                            System.out.println("동일한 이름의 상품이 다른 카테고리에 존재합니다.");
                            return;
                        }
                    }
                    for (int i = 0; i < food.size(); i++) {
                        Product product = food.get(i);
                        if(productName.equals(product.getName())) {
                            System.out.println("동일한 이름의 상품이 다른 카테고리에 존재합니다.");
                            return;
                        }
                    }
                    electronics.add(new Product(productName, productPrice, productExplain, productStock));
                    System.out.println("상품이 성공적으로 추가되었습니다!");
                    break;
                } else if (choice2 == 2) {
                    return;
                }else {
                    System.out.println("잘못된 입력입니다.");
                    break;
                }
            case 2 :
                System.out.println("[ 의류 카테고리에 상품 추가 ]");
                System.out.print("상품명을 입력해주세요 : ");
                productName = sc.nextLine();
                System.out.print("가격을 입력해주세요 : ");
                productPrice = sc.nextInt();
                sc.nextLine();
                System.out.print("상품 설명을 입력해주세요 : ");
                productExplain = sc.nextLine();
                System.out.print("재고 수량을 입력해주세요 : ");
                productStock = sc.nextInt();
                sc.nextLine();

                System.out.printf("%-1s | %,1d원 | %-1s | %-1s%n",productName, productPrice, productExplain, "재고 : " + productStock + "개");
                System.out.println("위 정보로 상품을 추가 하시겠습니까?");
                System.out.println("1. 확인    2. 취소");
                choice2 = sc.nextInt();
                if(choice2 == 1) {
                    for (int i = 0; i < electronics.size(); i++) {
                        Product product = electronics.get(i);
                        if(productName.equals(product.getName())) {
                            System.out.println("동일한 이름의 상품이 다른 카테고리에 존재합니다.");
                            return;
                        }
                    }
                    for (int i = 0; i < apparel.size(); i++) {
                        Product product = apparel.get(i);
                        if(productName.equals(product.getName())) {
                            System.out.println("동일한 이름의 상품이 이미 존재합니다.");
                            return;
                        }
                    }
                    for (int i = 0; i < food.size(); i++) {
                        Product product = food.get(i);
                        if(productName.equals(product.getName())) {
                            System.out.println("동일한 이름의 상품이 다른 카테고리에 존재합니다.");
                            return;
                        }
                    }
                    apparel.add(new Product(productName, productPrice, productExplain, productStock));
                    System.out.println("상품이 성공적으로 추가되었습니다!");
                    break;
                } else if (choice2 == 2) {
                    return;
                }else {
                    System.out.println("잘못된 입력입니다.");
                    break;
                }
            case 3 :
                System.out.println("[ 식품 카테고리에 상품 추가 ]");
                System.out.print("상품명을 입력해주세요 : ");
                productName = sc.nextLine();
                System.out.print("가격을 입력해주세요 : ");
                productPrice = sc.nextInt();
                sc.nextLine();
                System.out.print("상품 설명을 입력해주세요 : ");
                productExplain = sc.nextLine();
                System.out.print("재고 수량을 입력해주세요 : ");
                productStock = sc.nextInt();
                sc.nextLine();

                System.out.printf("%-1s | %,1d원 | %-1s | %-1s%n",productName, productPrice, productExplain, "재고 : " + productStock + "개");
                System.out.println("위 정보로 상품을 추가 하시겠습니까?");
                System.out.println("1. 확인    2. 취소");
                choice2 = sc.nextInt();
                if(choice2 == 1) {
                    for (int i = 0; i < electronics.size(); i++) {
                        Product product = electronics.get(i);
                        if(productName.equals(product.getName())) {
                            System.out.println("동일한 이름의 상품이 다른 카테고리에 존재합니다.");
                            return;
                        }
                    }
                    for (int i = 0; i < apparel.size(); i++) {
                        Product product = apparel.get(i);
                        if(productName.equals(product.getName())) {
                            System.out.println("동일한 이름의 상품이 다른 카테고리에 존재합니다.");
                            return;
                        }
                    }
                    for (int i = 0; i < food.size(); i++) {
                        Product product = food.get(i);
                        if(productName.equals(product.getName())) {
                            System.out.println("동일한 이름의 상품이 이미 존재합니다.");
                            return;
                        }
                    }
                    food.add(new Product(productName, productPrice, productExplain, productStock));
                    System.out.println("상품이 성공적으로 추가되었습니다!");
                    break;
                } else if (choice2 == 2) {
                    return;
                }else {
                    System.out.println("잘못된 입력입니다.");
                    break;
                }
            default :
                System.out.println("잘못된 입력입니다.");
        }
    }

    public void editProduct() {
        while(true) {
            int choice = 0;
            System.out.print("수정할 상품명을 입력해주세요 : ");
            String productName = sc.nextLine();
            boolean equalsName = false;

            for (int i = 0; i < apparel.size(); i++) {
                Product product = apparel.get(i);
                if(productName.equals(product.getName())) {
                    System.out.printf("%-1s | %,1d원 | %-1s | %-1s%n%n", "현재 상품 정보 : " + product.getName(), product.getPrice(), product.getExplain(), "재고 : " + product.getStock() + "개");
                    equalsName = true;
                    System.out.println("수정할 항목을 선택해주세요 : ");
                    System.out.println("1. 가격");
                    System.out.println("2. 설명");
                    System.out.println("3. 재고 수량");
                    System.out.println("0. 뒤로가기");
                    try {
                        choice = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("숫자만 입력 가능합니다.");
                        sc.nextLine();
                    }
                    switch (choice) {
                        case 1:
                            int beforePrice = product.getPrice();
                            System.out.printf("%-1s %,1d원%n", "현재 가격 : ", beforePrice);
                            System.out.print("새로운 가격을 입력해주세요 : ");
                            int afterPrice = sc.nextInt();
                            sc.nextLine();
                            product.setPrice(afterPrice);
                            System.out.printf("%-1s %-1s %,1d원 %-1s %,1d원%-1s%n", product.getName(), "가격이", beforePrice, "->", afterPrice, "으로 수정되었습니다.");
                            break;
                        case 2 :
                            String beforeExplain = product.getExplain();
                            System.out.println("현재 설명 : " + product.getExplain());
                            System.out.print("새로운 설명을 입력해주세요 : ");
                            String afterExplain = sc.nextLine();
                            product.setExplain(afterExplain);
                            System.out.printf("%-1s %-1s %-1s %-1s %-1s%-1s%n", product.getName(), "설명이", beforeExplain, "->", afterExplain, "으로 수정되었습니다.");
                            break;
                        case 3 :
                            int beforeStock = product.getStock();
                            System.out.println("현재 재고 : " + product.getStock());
                            System.out.print("새로운 재고를 입력해주세요 : ");
                            int afterStock = sc.nextInt();
                            product.setStock(afterStock);
                            sc.nextLine();
                            System.out.printf("%-1s %-1s %,1d%-1s %,1d%-1s%n", product.getName(), "재고가", beforeStock, "개 ->", afterStock, "개로 수정되었습니다.");
                            break;
                        case 0 :
                            return;
                        default:
                            System.out.println("잘못된 입력입니다.");
                    }
                    return;
                }
            }
            for (int i = 0; i < food.size(); i++) {
                Product product = food.get(i);
                if(productName.equals(product.getName())) {
                    System.out.printf("%-1s | %,1d원 | %-1s | %-1s%n%n", "현재 상품 정보 : " + product.getName(), product.getPrice(), product.getExplain(), "재고 : " + product.getStock() + "개");
                    equalsName = true;
                    System.out.println("수정할 항목을 선택해주세요 : ");
                    System.out.println("1. 가격");
                    System.out.println("2. 설명");
                    System.out.println("3. 재고 수량");
                    System.out.println("0. 뒤로가기");
                    try {
                        choice = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("숫자만 입력 가능합니다.");
                        sc.nextLine();
                    }
                    switch (choice) {
                        case 1:
                            int beforePrice = product.getPrice();
                            System.out.printf("%-1s %,1d원%n", "현재 가격 : ", beforePrice);
                            System.out.print("새로운 가격을 입력해주세요 : ");
                            int afterPrice = sc.nextInt();
                            sc.nextLine();
                            product.setPrice(afterPrice);
                            System.out.printf("%-1s %-1s %,1d원 %-1s %,1d원%-1s%n", product.getName(), "가격이", beforePrice, "->", afterPrice, "으로 수정되었습니다.");
                            break;
                        case 2 :
                            String beforeExplain = product.getExplain();
                            System.out.println("현재 설명 : " + product.getExplain());
                            System.out.print("새로운 설명을 입력해주세요 : ");
                            String afterExplain = sc.nextLine();
                            product.setExplain(afterExplain);
                            System.out.printf("%-1s %-1s %-1s %-1s %-1s%-1s%n", product.getName(), "설명이", beforeExplain, "->", afterExplain, "으로 수정되었습니다.");
                            break;
                        case 3 :
                            int beforeStock = product.getStock();
                            System.out.println("현재 재고 : " + product.getStock());
                            System.out.print("새로운 재고를 입력해주세요 : ");
                            int afterStock = sc.nextInt();
                            product.setStock(afterStock);
                            sc.nextLine();
                            System.out.printf("%-1s %-1s %,1d%-1s %,1d%-1s%n", product.getName(), "재고가", beforeStock, "개 ->", afterStock, "개로 수정되었습니다.");
                            break;
                        case 0 :
                            return;
                        default:
                            System.out.println("잘못된 입력입니다.");
                    }
                    return;
                }
            }
            for (int i = 0; i < electronics.size(); i++) {
                Product product = electronics.get(i);
                if(productName.equals(product.getName())) {
                    System.out.printf("%-1s | %,1d원 | %-1s | %-1s%n%n", "현재 상품 정보 : " + product.getName(), product.getPrice(), product.getExplain(), "재고 : " + product.getStock() + "개");
                    equalsName = true;
                    System.out.println("수정할 항목을 선택해주세요 : ");
                    System.out.println("1. 가격");
                    System.out.println("2. 설명");
                    System.out.println("3. 재고 수량");
                    System.out.println("0. 뒤로가기");
                    try {
                        choice = sc.nextInt();
                        sc.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("숫자만 입력 가능합니다.");
                        sc.nextLine();
                    }
                    switch (choice) {
                        case 1:
                            int beforePrice = product.getPrice();
                            System.out.printf("%-1s %,1d원%n", "현재 가격 : ", beforePrice);
                            System.out.print("새로운 가격을 입력해주세요 : ");
                            int afterPrice = sc.nextInt();
                            sc.nextLine();
                            product.setPrice(afterPrice);
                            System.out.printf("%-1s %-1s %,1d원 %-1s %,1d원%-1s%n", product.getName(), "가격이", beforePrice, "->", afterPrice, "으로 수정되었습니다.");
                            break;
                        case 2 :
                            String beforeExplain = product.getExplain();
                            System.out.println("현재 설명 : " + product.getExplain());
                            System.out.print("새로운 설명을 입력해주세요 : ");
                            String afterExplain = sc.nextLine();
                            product.setExplain(afterExplain);
                            System.out.printf("%-1s %-1s %-1s %-1s %-1s%-1s%n", product.getName(), "설명이", beforeExplain, "->", afterExplain, "으로 수정되었습니다.");
                            break;
                        case 3 :
                            int beforeStock = product.getStock();
                            System.out.println("현재 재고 : " + product.getStock());
                            System.out.print("새로운 재고를 입력해주세요 : ");
                            int afterStock = sc.nextInt();
                            product.setStock(afterStock);
                            sc.nextLine();
                            System.out.printf("%-1s %-1s %,1d%-1s %,1d%-1s%n", product.getName(), "재고가", beforeStock, "개 ->", afterStock, "개로 수정되었습니다.");
                            break;
                        case 0 :
                            return;
                        default:
                            System.out.println("잘못된 입력입니다.");
                    }
                    return;
                }
            }
            if(!equalsName) {
                System.out.println("잘못된 상품명입니다.");
            }
        }
    }

    public void deleteProduct() {
        System.out.print("삭제할 상품명을 입력해주세요 : ");
        String productName = sc.nextLine();
        boolean equalsName = false;

        for (int i = 0; i < apparel.size(); i++) {
            Product product = apparel.get(i);
            if(productName.equals(product.getName())) {
                System.out.printf("%-1s | %,1d원 | %-1s | %-1s%n%n", "현재 상품 정보 : " + product.getName(), product.getPrice(), product.getExplain(), "재고 : " + product.getStock() + "개");
                equalsName = true;
                System.out.println("정말 위 상품을 삭제 하시겠습니까?");
                System.out.println("1. 확인    2. 취소");
                int choice = sc.nextInt();
                sc.nextLine();
                if(choice == 1) {
                    apparel.remove(product);
                    if(cart.getCart().containsKey(product.getName())){
                        cart.deleteCart(product);
                    }
                    System.out.println("상품이 성공적으로 삭제되었습니다");
                    return;
                } else if (choice == 2) {
                    return;
                }else {
                    System.out.println("잘못된 입력입니다.");
                    break;
                }
            }
        }
        for (int i = 0; i < food.size(); i++) {
            Product product = food.get(i);
            if(productName.equals(product.getName())) {
                System.out.printf("%-1s | %,1d원 | %-1s | %-1s%n%n", "현재 상품 정보 : " + product.getName(), product.getPrice(), product.getExplain(), "재고 : " + product.getStock() + "개");
                equalsName = true;
                System.out.println("정말 위 상품을 삭제 하시겠습니까?");
                System.out.println("1. 확인    2. 취소");
                int choice = sc.nextInt();
                sc.nextLine();
                if(choice == 1) {
                    food.remove(product);
                    if(cart.getCart().containsKey(product.getName())){
                        cart.deleteCart(product);
                    }
                    System.out.println("상품이 성공적으로 삭제되었습니다");
                    return;
                } else if (choice == 2) {
                    return;
                }else {
                    System.out.println("잘못된 입력입니다.");
                    break;
                }
            }
        }
        for (int i = 0; i < electronics.size(); i++) {
            Product product = electronics.get(i);
            if(productName.equals(product.getName())) {
                System.out.printf("%-1s | %,1d원 | %-1s | %-1s%n%n", "현재 상품 정보 : " + product.getName(), product.getPrice(), product.getExplain(), "재고 : " + product.getStock() + "개");
                equalsName = true;
                System.out.println("정말 위 상품을 삭제 하시겠습니까?");
                System.out.println("1. 확인    2. 취소");
                int choice = sc.nextInt();
                sc.nextLine();
                if(choice == 1) {
                    electronics.remove(product);
                    if(cart.getCart().containsKey(product.getName())){
                        cart.deleteCart(product);
                    }
                    System.out.println("상품이 성공적으로 삭제되었습니다");
                    return;
                } else if (choice == 2) {
                    return;
                }else {
                    System.out.println("잘못된 입력입니다.");
                    break;
                }
            }
        }
        if(!equalsName) {
            System.out.println("잘못된 상품명입니다.");
        }
    }

    public void printAllProucts(){
        System.out.println("[ 전체 상품 현황 ]");
        for (int i = 0; i < electronics.size(); i++) {
            Product product = electronics.get(i);
            System.out.printf("%-28s | %,9d원 | %-1s | %-1s%n", product.getName(), product.getPrice(), product.getExplain(), "재고 : " + product.getStock() + "개");
        }
        for (int i = 0; i < apparel.size(); i++) {
            Product product = apparel.get(i);
            System.out.printf("%-28s | %,9d원 | %-1s | %-1s%n", product.getName(), product.getPrice(), product.getExplain(), "재고 : " + product.getStock() + "개");
        }
        for (int i = 0; i < food.size(); i++) {
            Product product = food.get(i);
            System.out.printf("%-28s | %,9d원 | %-1s | %-1s%n", product.getName(), product.getPrice(), product.getExplain(), "재고 : " + product.getStock() + "개");
        }
    }

    public List<Product> getApparel() {
        return apparel;
    }
    public List<Product> getElectronics() {
        return electronics;
    }
    public List<Product> getFood() {
        return food;
    }
}
