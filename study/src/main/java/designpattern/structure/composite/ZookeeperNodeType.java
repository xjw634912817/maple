package designpattern.structure.composite;

/**
 * 节点类型
 */
public enum ZookeeperNodeType {
    PERSISTENT("持久化"), EPHEMERAL("临时");

    private String value;

    ZookeeperNodeType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
