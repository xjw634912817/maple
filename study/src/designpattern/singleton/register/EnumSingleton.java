package designpattern.singleton.register;

/**
 * 优点：线程安全
 * 缺点：有可能造成内存浪费
 */
public enum EnumSingleton {
    INSTANCE;

    private Object customField;

    public Object getCustomField() {
        return customField;
    }

    public void setCustomField(Object customField) {
        this.customField = customField;
    }

    public void test() {
        System.out.println("aaaa");
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}
