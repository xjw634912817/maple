package designpattern.structure.decorator;

import com.google.common.collect.Lists;

import java.util.List;

public class BaseFunctionModule extends FunctionModule {
    @Override
    List<String> getFunctionModules() {
        return Lists.newArrayList("问答模块", "文章模块");
    }
}
