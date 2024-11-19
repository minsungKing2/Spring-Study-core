package hello.core.singleton;

//Ctrl + Shift + T : Test 만드는 명령어
public class StatefulService {

//    private int price; //상태를 유지하는 필드 10000 -> 20000
    //상태 -> 무상태로 변경해야함
    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price; //여기가 문제!
        return price;
    }
//    public int getPrice() {
//        return price;
//    }
}
