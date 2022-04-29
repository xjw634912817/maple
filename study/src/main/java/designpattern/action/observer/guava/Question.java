package designpattern.action.observer.guava;

public class Question {
    private String username;
    private String content;

    public Question(String username, String content) {
        this.username = username;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Question{" +
                "username='" + username + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
