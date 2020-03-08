package composite;

/**
 * 临时节点（不能有子节点）
 */
public class EphemeralNode extends AbstractZookeeperNode {

    public EphemeralNode(String name, ZookeeperNodeType type, Integer level) {
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
            System.out.print("-");
        }
        System.out.println(this.getName() + "(" + this.getType() + ")");
    }

}
