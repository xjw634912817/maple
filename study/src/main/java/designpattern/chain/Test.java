package designpattern.chain;

public class Test {
    public static void main(String[] args) {
        // v1
        HandlerNode empty = new Empty();
        HandlerNode correct = new Correct();
        HandlerNode auth = new Auth();

        empty.setNext(correct);
        correct.setNext(auth);

        empty.handle();

        // v2
        HandlerNode.HandlerNodeBuilder handlerNodeBuilder = new HandlerNode.HandlerNodeBuilder();
        handlerNodeBuilder.add(new Empty())
                .add(new Correct())
                .add(new Auth());
        HandlerNode build = handlerNodeBuilder.build();
        build.handle();
    }
}
