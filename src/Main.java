import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        CommerceSystem commerceSystem = new CommerceSystem(products);

        products.add(new Product("Galaxy S24", 1200000, "최신 안드로이드 스마트폰", 50));
        products.add(new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 50));
        products.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 50));
        products.add(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 50));

        commerceSystem.start();
    }
}
