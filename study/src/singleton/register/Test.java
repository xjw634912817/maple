package singleton.register;

public class Test {
    public static void main(String[] args) {
        EnumSingleton.getInstance().setCustomField("123123");
        Object customField = EnumSingleton.INSTANCE.getCustomField();
        System.out.println(customField);
        EnumSingleton.INSTANCE.test();
    }
}
