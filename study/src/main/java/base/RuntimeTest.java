package base;

/**
 * @author maple
 * @date 2020/8/23
 */
public class RuntimeTest {

    public static void main(String[] args) {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        // -Xms10M -Xmx10M
        long maxMemory = Runtime.getRuntime().maxMemory();
        long totalMemory = Runtime.getRuntime().totalMemory();
        long freeMemory = Runtime.getRuntime().freeMemory();
        System.out.println(availableProcessors);
        System.out.println(maxMemory);
        System.out.println(totalMemory);
        System.out.println(freeMemory);
    }

}
