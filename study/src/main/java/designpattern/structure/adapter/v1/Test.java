package designpattern.structure.adapter.v1;

public class Test {
    public static void main(String[] args) {
        PassportForThirdAdapt adapt = new PassportForThirdAdapt();
        adapt.login("maple", "1231");
        adapt.loginForQQ("asdasdsadsad");
    }
}
