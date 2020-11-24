package base;

import org.json.JSONObject;

public class SystemTest {

    static class Student {
        @Override
        protected void finalize() throws Throwable {
            System.out.println("被释放啦~~~");
        }
    }


    public static void main(String[] args) {
        System.out.println(System.getProperties());
        System.out.println("============= start create object =====");
        for (int i = 0; i < 5; i++) {
            new Student();
        }
        System.out.println("============= start call gc method =====");
        System.gc();
        System.out.println("============= end call gc method =====");
        
        byte[] source = new byte[]{1,2,3,4};
        byte[] target = new byte[3];
        
        // 浅拷贝
        System.arraycopy(source, 1, target, 0, 2);
        System.out.println(JSONObject.valueToString(target));
    }

}
