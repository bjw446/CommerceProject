import java.util.HashMap;
import java.util.InputMismatchException;
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
        try {
            choice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자만 입력 가능합니다.");
            sc.nextLine();
        }
        switch (choice) {
            case 1 :
                System.out.printf("%-15s %,8d원%n", "주문이 완료되었습니다! 총 금액 :", totalPrice());
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
                break;
            case 2 :
                return;
            default :
                System.out.println("잘못된 입력 입니다.");
        }
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
