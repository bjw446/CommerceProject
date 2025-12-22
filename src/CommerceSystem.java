import java.util.InputMismatchException;
import java.util.Scanner;

public class CommerceSystem {

    Cart cart = new Cart(); // 장바구니 객체
    Admin admin = new Admin(cart); // 관리자 객체
    Category category = new Category(admin); // 카테고리 객체

    // 생성자 : 기본 상품 등록
    public CommerceSystem() {
        category.cart = this.cart; // 장바구니 연결
        // 상품 목록 초기화
        admin.apparelProducts();
        admin.electronicsProducts();
        admin.foodProducts();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);

        boolean menu = true;
        while(menu) {
            // 장바구니가 비어있을 때 메뉴
            if(cart.getCart().isEmpty()) {
                System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
                System.out.println("1. 전자제품");
                System.out.println("2. 의류");
                System.out.println("3. 식품");
                System.out.printf("%-1d. %-11s | %7s", 0, "종료", "프로그램 종료\n");
                System.out.println("6. 관리자 모드");


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
                    case 6 :
                        if(!admin.login()) {
                            break;
                        }
                        admin.adminMenu();
                        break;
                    case 0 :
                        System.out.println("커머스 플랫폼을 종료합니다.");
                        menu = false;
                        break;
                    default :
                        System.out.println("잘못된 메뉴 선택입니다. 다시 입력 해주세요.\n");
                }
                // 장바구니에 상품이 담겨 있을 때 메뉴
            }else {
                System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");
                System.out.println("1. 전자제품");
                System.out.println("2. 의류");
                System.out.println("3. 식품");
                System.out.printf("%-1d. %-11s | %7s", 0, "종료", "프로그램 종료\n");
                System.out.println("6. 관리자 모드");

                System.out.println("[ 주문 관리 ]");
                System.out.printf("%-1d. %-11s | %7s%n", 4, "장바구니 확인", "장바구니를 확인 후 주문합니다.");
                System.out.printf("%-1d. %-11s | %7s%n", 5, "주문 취소", "진행중인 주문을 취소합니다.");

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
                        case 4 :
                            cart.printCart();
                            cart.totalPrice();
                            cart.payment();
                            break;
                        case 5 :
                            cart.removeAll();
                            break;
                        case 6 :
                        if(!admin.login()) {
                            break;
                        }
                        admin.adminMenu();
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
        sc.close();
    }
}

