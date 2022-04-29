package designpattern.structure.composite;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.UUID;

/**
 * 测试类
 */
public class Test {

    public static void main(String[] args) {
        PersistentNode root = new PersistentNode("root", ZookeeperNodeType.PERSISTENT, 0);

        EphemeralNode maple = new EphemeralNode("maple", ZookeeperNodeType.EPHEMERAL, 1);
        PersistentNode lock = new PersistentNode("lock", ZookeeperNodeType.PERSISTENT, 1);
        PersistentNode service = new PersistentNode("services", ZookeeperNodeType.PERSISTENT, 1);
        root.batchAddChild(Lists.newArrayList(maple, lock, service));

        lock.batchAddChild(randomNode(2, 3));
        service.batchAddChild(randomNode(2, 4));

        root.show();
    }

    /**
     * 随机创建 n 个 level 级别的临时节点
     */
    private static List<AbstractZookeeperNode> randomNode(Integer level, Integer number) {
        List<AbstractZookeeperNode> nodes = Lists.newArrayListWithExpectedSize(number);
        for (int i = 0; i < number; i++) {
            nodes.add(new EphemeralNode(UUID.randomUUID().toString(), ZookeeperNodeType.EPHEMERAL, level));
        }
        return nodes;
    }

}
