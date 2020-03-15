package designpattern.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StrategyFactory {

    private static Map<String, IStrategy> map = new HashMap<>();

    static {
        map.put("ADD", new AddStrategy());
        map.put("DIVIDE", new DivideStrategy());
        map.put("MULTIPLY", new MultiplyStrategy());
        map.put("DEFAULT", new AddStrategy());
    }

    private StrategyFactory() {

    }

    public static IStrategy getStrategy(String key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return map.get("DEFAULT");
    }

    public static Set<String> getKeys() {
        return map.keySet();
    }

}
