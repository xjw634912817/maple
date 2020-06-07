package com.maple.springboot.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class WatchDemo {

    public static void main(String[] args) throws Exception {
        // PathChildrenCache 针对子节点的创建、删除和更新触发事件
        // NodeCache 针对当前节点的变化触发事件
        // TreeCache 综合上述两种事件

        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .connectString("localhost:2181") // 地址
                .sessionTimeoutMs(5000) // 超时时间
                .retryPolicy(new ExponentialBackoffRetry(1000, 3)) // 重试策略
                .build();

        curatorFramework.start();
//        addListenerWithNode(curatorFramework);
        addListenerWithPathChildrenCache(curatorFramework);

        System.in.read();
    }

    // 配置中心，配置修改后通知所有应用
    private static void addListenerWithNode(CuratorFramework curatorFramework) throws Exception {
        NodeCache nodeCache = new NodeCache(curatorFramework, "/watch", false);
        NodeCacheListener listener = () -> {
            System.out.println("--------- receive node changed ---------");
            System.out.println(nodeCache.getCurrentData().getPath() + " : " + new String(nodeCache.getCurrentData().getData()));
        };
        nodeCache.getListenable().addListener(listener);
        nodeCache.start();
    }

    // 服务注册中心，针对服务做动态感知
    private static void addListenerWithPathChildrenCache(CuratorFramework curatorFramework) throws Exception {
        PathChildrenCache pathChildrenCache = new PathChildrenCache(curatorFramework, "/watch", true);
        PathChildrenCacheListener listener = (curatorFramework1, pathChildrenCacheEvent) -> {
            System.out.println("--------- receive path children changed ---------");
            System.out.println(pathChildrenCacheEvent.getType() + " : " + new String(pathChildrenCacheEvent.getData().getData()));
        };
        pathChildrenCache.getListenable().addListener(listener);
        pathChildrenCache.start(PathChildrenCache.StartMode.NORMAL);
    }
}
