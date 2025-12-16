import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        products.add(new Product("Galaxy S24", 1200000, "최신 안드로이드 스마트폰", 50));
        products.add(new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 50));
        products.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 50));
        products.add(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 50));

        System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");

        for(int i = 0; i < products.size(); i++){
            Product product = products.get(i);
            System.out.printf("%-1d. %-12s | %,9d원 | %-1s%n", i + 1, product.getName(), product.getPrice(), product.getExplain());
        }
        System.out.printf("%-1d. %-11s | %7s", 0, "종료", "프로그램 종료\n");

        int choice = sc.nextInt();
        if (choice == 0) {
            System.out.println("커머스 플랫폼을 종료합니다.");
        }
    }
}
