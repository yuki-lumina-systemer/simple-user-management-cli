import java.util.Random;
import java.util.Scanner;
public class User {
    private String username;
    private int age;
     final private int ID;
     private int Pin;
     private boolean PIN_ON = false;
    public User() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nお名前を入力してください:");
        if(sc.hasNext()) {
            this.username = sc.next();
        }
        System.out.print("\n年齢を入力してください:");
        if(sc.hasNextInt()) {
            this.age = sc.nextInt();
        }
        Random rand = new Random();
        this.ID = rand.nextInt(5) + 10000;
        System.out.print("\nパスワードを設定してください (4桁):");
        if(sc.hasNextInt()) {
            PIN_ON = true;
            while(PIN_ON) {
                this.Pin = sc.nextInt();
                if(Pin >= 1000 && Pin < 10000) {
                    PIN_ON = false;
                } else {
                    System.out.println("エラー: パスワードは4桁です");
                    System.out.print("再入力:");
                    PIN_ON = true;
                }
            }
        }
        System.out.println("お名前:" + this.username + " 年齢:" + this.age + " ID:" + this.ID);

    }
    public void show() {
        System.out.println("お名前:" + this.username + " 年齢:" + this.age + " ID:" + this.ID);
    }
    public void showList() {
         System.out.println("userList");
    }
    public int getID() {
         return this.ID;
    }
    public String getUsername() {
         return this.username;
    }
    public int getPin() {
         return this.Pin;
    }
    public void changePin(int Pin) {
        this.Pin = Pin;

    }
}
