import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CommerceSystem {

    Category category = new Category();

    public void start() {
        Scanner sc = new Scanner(System.in);

        boolean menu = true;
        while(menu) {
            System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
            System.out.println("1. 전자제품");
            System.out.println("2. 의류");
            System.out.println("3. 식품");
            System.out.printf("%-1d. %-11s | %7s", 0, "종료", "프로그램 종료\n");

            int categoryMenu;
            try {
                categoryMenu = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력 가능합니다.");
                sc.nextLine();
                continue;
            }

            switch (categoryMenu) {
                case 1 :
                    category.electronics();
                    break;
                case 2 :
                    category.apparel();
                    break;
                case 3 :
                    category.food();
                    break;
                case 0 :
                    System.out.println("커머스 플랫폼을 종료합니다.");
                    menu = false;
                    break;
                default :
                    System.out.println("잘못된 메뉴 선택입니다. 다시 입력 해주세요.\n");

            }

        }
    }
}

