import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cart {

    private Map<String, Product> cart = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void addCart(Product product) {
        if(product.getStock() <= 0) {
            System.out.println(product.getName() + " 상품의 재고가 부족합니다.");
            return;
        }

        if(cart.containsKey(product.getName())){
            Product overlap = cart.get(product.getName());
            overlap.setCount(overlap.getCount() + 1);
        } else {
            product.setCount(1);
            cart.put(product.getName(), product);
        }
        System.out.println(product.getName() + " 장바구니에 추가 되었습니다.");
    }
    public void deleteCart(Product product) {
        if(cart.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        }

        if(cart.containsKey(product.getName())) {
            Product overlap = cart.get(product.getName());
            int afterCount = overlap.getCount() - 1;

        if(afterCount <= 0) {
            cart.remove(product.getName());
        }else {
            overlap.setCount(afterCount);
        }
        System.out.println("장바구니에서 " + product.getName() +" 상품이 삭제 되었습니다.");
        } else {
            System.out.println(product.getName() + " 상품은 장바구니에 없습니다.");
        }
    }
    public void printCart() {
        if(cart.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
        }else {
            System.out.println("[ 장바구니 내역 ]");
            int i = 0;
            for(String name : cart.keySet()) {
                i++;
                Product product = cart.get(name);
                System.out.printf("%-1d. %-28s | %,9d원 | %-1s | %-1s%n", i, product.getName(), product.getTotalPrice(), product.getExplain(), "수량 : " + product.getCount()+ "개");
            }
        }
    }
    public int totalPrice() {
        int total = 0;
        for (Product product : cart.values()) {
            total = total + product.getTotalPrice();
        }
        return total;
    }
    public void payment() {
        System.out.printf("%-15s%n%,d원%n%n", "\n[ 총 주문 금액 ] ", totalPrice());
        System.out.println("1. 주문 확정      2. 메인으로 돌아가기");
        int choice = 0;
            choice = sc.nextInt();
            sc.nextLine();

        if (choice == 1) {
            gradePayment();
            int i = 0;
            for(String name : cart.keySet()) {
                i++;
                Product product = cart.get(name);
                int beforeStock = product.getStock();
                int afterStock = beforeStock - product.getCount();
                product.setStock(afterStock);
                System.out.printf("%-1d. %-30s %-1s %-1s %-1s%n", i, product.getName(), "재고가", beforeStock + "개 ->",afterStock + "개로 업데이트 되었습니다." );
            }
            removeAll();
        }else if(choice == 2) {
            return;
        }else {
            System.out.println("잘못된 입력 입니다.");
        }
    }

    public void gradePayment() {
        System.out.println("고객 등급을 입력해주세요.");
        System.out.printf("%-13s : %6s%n","1. BRONZE", "0% 할인");
        System.out.printf("%-13s : %6s%n","2. SILVER", "5% 할인");
        System.out.printf("%-13s : %6s%n","3. GOLD", "10% 할인");
        System.out.printf("%-13s : %6s%n","4. PLATINUM", "15% 할인");

        int choice = sc.nextInt();
        sc.nextLine();
        CustomerGrade gradeInt = CustomerGrade.fromInt(choice);
        gradeTotalPrice(gradeInt);
    }

    public double gradeTotalPrice(CustomerGrade customerGrade) {
        double gradeTotal = 0;
        switch (customerGrade) {
            case BRONZE:
                gradeTotal = totalPrice();
                System.out.println("주문이 완료되었습니다!");
                System.out.printf("%-1s %,8d원%n","할인 전 금액 :", totalPrice());
                System.out.printf("%-1s %,8d원%n", "BRONZE 등급 할인(0%) :", 0);
                System.out.printf("%-1s %,.0f원%n", "최종 결제 금액 :", gradeTotal);
                break;
            case SILVER:
                gradeTotal = totalPrice() - (totalPrice() * 0.05);
                System.out.println("주문이 완료되었습니다!");
                System.out.printf("%-1s %,8d원%n","할인 전 금액 :", totalPrice());
                System.out.printf("%-1s -%,.0f원%n", "SILVER 등급 할인(5%) :", totalPrice()*0.05);
                System.out.printf("%-1s %,.0f원%n", "최종 결제 금액 :", gradeTotal);
                break;
            case GOLD:
                gradeTotal = totalPrice() - (totalPrice() * 0.1);
                System.out.println("주문이 완료되었습니다!");
                System.out.printf("%-1s %,8d원%n","할인 전 금액 :", totalPrice());
                System.out.printf("%-1s -%,.0f원%n", "GOLD 등급 할인(10%) :", totalPrice()*0.1);
                System.out.printf("%-1s %,.0f원%n", "최종 결제 금액 :", gradeTotal);
                break;
            case PLATINUM:
                gradeTotal = totalPrice() - (totalPrice() * 0.15);
                System.out.println("주문이 완료되었습니다!");
                System.out.printf("%-1s %,8d원%n","할인 전 금액 :", totalPrice());
                System.out.printf("%-1s -%,.0f원%n", "PLATINUM 등급 할인(15%) :", totalPrice()*0.15);
                System.out.printf("%-1s %,.0f원%n", "최종 결제 금액 :", gradeTotal);
                break;
            default:
                System.out.println("잘못된 입력입니다.");
        }
        return gradeTotal;
    }

    public Map<String,Product> getCart() {
        return cart;
    }
    public void removeAll() {
        cart.clear();
    }

    public void setCart(Map<String, Product> cart) {
        this.cart = cart;
    }
}
