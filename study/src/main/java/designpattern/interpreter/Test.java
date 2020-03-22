package designpattern.interpreter;

public class Test {
    public static void main(String[] args) {
        System.out.println(new Calculate("2 + 3 + 4").calculate());
        System.out.println(new Calculate("2 * 3 * ( 4 + 1 )").calculate());
        System.out.println(new Calculate("2 + 3 * 4 + 2 * 3 + 5").calculate());
        System.out.println(new Calculate("( 1 + 2 + 3 ) * 2").calculate());
        System.out.println(new Calculate("2 * ( 1 + 2 + 3 )").calculate());
        System.out.println(new Calculate("2 * ( ( 1 + 2 ) * 3 )").calculate());
    }
}
