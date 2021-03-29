package base.datatype;

public class CharacterTest {

    public static void main(String[] args) {
        System.out.println("start");
        Integer num = 0;
        for (char tmp = Character.MIN_VALUE; tmp <= 127 ; tmp++) {
            num++;
            System.out.println(num + " : " + tmp);
        }
        System.out.println("cache number: " + num);
        System.out.println("end");
    }
    
}
