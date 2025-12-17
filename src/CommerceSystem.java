import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem {

    private List<Product> products;

    public CommerceSystem(List<Product> products) {
        this.products = products;
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");

            for(int i = 0; i < products.size(); i++){
                Product product = products.get(i);
                System.out.printf("%-1d. %-12s | %,9d원 | %-1s%n", i + 1, product.getName(), product.getPrice(), product.getExplain());
            }
            System.out.printf("%-1d. %-11s | %7s", 0, "종료", "프로그램 종료\n");
            int choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            }
        }
    }
}

