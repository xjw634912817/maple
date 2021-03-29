package base.datatype;

public class IntegerTest {

    public static void main(String[] args) {
        Integer a = 1;
        add(a);
        System.out.println(a);

        a = 128;
        add(a);
        System.out.println(a);

        a = 777;
        add(a);
        System.out.println(a);

        String b = "123";
        add(b);
        System.out.println(b);

        // 自动装箱 valueOf()
        // 缓冲池IntegerCache默认 -128 到 127
        // -XX:AutoBoxCacheMax=130 设置缓冲池最大值
        // -Djava.lang.Integer.IntegerCache.high=130 设置缓冲池最大值
        Integer i1 = 1;
        Integer i2 = 1;
        System.out.println(i1 == i2);
        System.out.println(i1.equals(i2));

        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3 == i4);
        System.out.println(i3.equals(i4));

        Integer i5 = 127;
        Integer i6 = 127;
        System.out.println(i5 == i6);
        System.out.println(i5.equals(i6));
    }

    private static void add(String b) {
        b = b + "append";
    }

    private static void add(Integer a) {
        a = a + 1;
    }


}
