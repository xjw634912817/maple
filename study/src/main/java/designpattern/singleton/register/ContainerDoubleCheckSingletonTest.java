package designpattern.singleton.register;

public class ContainerDoubleCheckSingletonTest implements Runnable {

    private static final ContainerDoubleCheckSingletonTest instance1 = new ContainerDoubleCheckSingletonTest();
    private static final ContainerDoubleCheckSingletonTest instance2 = new ContainerDoubleCheckSingletonTest();

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        try {
            System.out.println("线程：" + Thread.currentThread().getName() + ContainerDoubleCheckSingleton.getInstance("designpattern.singleton.register.A"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}