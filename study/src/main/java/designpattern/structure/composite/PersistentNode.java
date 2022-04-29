package designpattern.structure.composite;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 持久化节点（可以有子节点）
 */
public class PersistentNode extends AbstractZookeeperNode {

    private List<AbstractZookeeperNode> children = Lists.newArrayList();

    public PersistentNode(String name, ZookeeperNodeType type, Integer level) {
        super(name, type.getValue(), level);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public Integer getLevel() {
        return this.level;
    }

    @Override
    public void show() {
        super.printLevelBlank();
        for (int i = 0; i < this.getLevel(); i++) {
            System.out.print("+");
        }
        System.out.println(this.getName() + "(" + this.getType() + ")");
        for (AbstractZookeeperNode children : children) {
            children.show();
        }
    }

    public void addChild(AbstractZookeeperNode node) {
        children.add(node);
    }

    public void batchAddChild(List<AbstractZookeeperNode> nodes) {
        children.addAll(nodes);
    }

}
