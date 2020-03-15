package designpattern.chain;

public abstract class HandlerNode {
    protected HandlerNode next;

    public HandlerNode getNext() {
        return next;
    }

    public void setNext(HandlerNode next) {
        this.next = next;
    }

    abstract void handle();

    public static class HandlerNodeBuilder {

        private HandlerNode head;
        private HandlerNode tail;

        public HandlerNodeBuilder add(HandlerNode next) {
            if (this.head == null) {
                this.head = this.tail = next;
                return this;
            }
            this.tail.next = next;
            this.tail = next;
            return this;
        }

        public HandlerNode build() {
            return this.head;
        }

    }
}
