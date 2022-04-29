package designpattern.structure.composite;

/**
 * 抽象节点
 */
public abstract class AbstractZookeeperNode {
    protected String name;
    protected String type;
    protected Integer level;

    public AbstractZookeeperNode(String name, String type, Integer level) {
        this.name = name;
        this.type = type;
        this.level = level;
    }

    public abstract String getName();

    public abstract String getType();

    public abstract Integer getLevel();

    public abstract void show();

    /**
     * 打印层级结构前的空格
     */
    protected void printLevelBlank() {
        for (int i = 0; i < this.getLevel(); i++) {
            System.out.print("  ");
        }
    }
}
