import java.util.Optional;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("--- ユーザーメニュー ---");
            System.out.println("1: アカウント作成");
            System.out.println("2: 情報確認");
            System.out.println("3: User一覧");
            System.out.println("4: アカウントPin変更");
            System.out.println("5: 初期化");
            System.out.print("入力:");
            String command = sc.next();
            switch(command) {
                case "1":
                    User a = new User();
                    userService.add(a);
                    break;
                case "2":
                    System.out.print("\nあなたのIDを入力してください:");
                    int id = sc.nextInt();
                    Optional<User> userOpt = userService.findByID(id);
                    if(userOpt.isPresent()) {
                        User target = userOpt.get();
                        System.out.println("ユーザーが見つかりました:" + target.getUsername());
                        System.out.print("PINを入力してください:");
                        boolean pin_ok = true;
                        while(pin_ok) {
                            int inputPin = sc.nextInt();
                            if(target.getPin() == inputPin) {
                                pin_ok = false;
                                System.out.println("---認証成功---");
                                target.show();
                            } else {
                                System.out.println("Pinが違います");
                                System.out.print("PINを入力してください:");
                            }
                        }
                    } else {
                            System.out.println("そのIDは見つかりませんでした");
                        }
                        break;
                case "3":
                    System.out.println("User一覧");
                    for(User u : userService.findAll()) {
                        System.out.println("ID:" + u.getID() + " 名前:" + u.getUsername());
                    }
                    break;
                case "4":
                    System.out.println("---ユーザーPin変更---");
                    System.out.print("IDを入力してください:");
                    int id2 = sc.nextInt();
                    Optional<User> userOpt2 = userService.findByID(id2);

                    if (userOpt2.isPresent()) {
                        User target2 = userOpt2.get();
                        boolean isAuth = false;
                        while (!isAuth) {
                            System.out.print("現在のPINを入力してください:");
                            int inputPin = sc.nextInt();
                            if (target2.getPin() == inputPin) {
                                isAuth = true;
                                System.out.println("---認証成功---");
                            } else {
                                System.out.println("Pinが違います");
                            }
                        }
                        System.out.print("新しいPINを入力してください:");
                        boolean isnew = true;
                        while(isnew) {
                            int newPin = sc.nextInt();
                            if(newPin >= 1000 && newPin < 10000) {
                                target2.changePin(newPin);
                                isnew = false;
                                System.out.println("変更完了");
                                break;
                            } else {
                                System.out.println("PINは4桁です");
                                System.out.print("再入力:");
                            }
                        }
                    } else {
                        System.out.println("そのIDは見つかりませんでした");
                    }
                    break;
                case "5":
                    for(int i = 0; i < 100; i++) {
                        System.out.println("  ");
                    }
                    break;
                default:
                    System.out.println("無効な操作です");
            }
        }
    }
}