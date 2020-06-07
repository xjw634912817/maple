package com.maple.springboot.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class CuratorDemo {

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .connectString("localhost:2181") // 地址
                .sessionTimeoutMs(5000) // 超时时间
//                .namespace("/lock")  // 命名空间
                .retryPolicy(new ExponentialBackoffRetry(1000, 3)) // 重试策略
                .build();
        //namespace: 值得注意的是 session 会话含有隔离命名空间，即
        //客户端对 Zookeeper 上数据节点的任何操作都是相对/lock
        //目录进行的，这有利于实现不同的 Zookeeper 的业务之间的隔离

        // 重试策略
        // ExponentialBackoffRetry 衰减重试，基础1s，重试3次
        // RetryOneTime 重试一次
        // RetryNTimes 重试最大次数
        // RetryUntilElapsed 重试最大时间

        curatorFramework.start();
        createData(curatorFramework);
        // CRUD
        // curatorFramework.create();
        // curatorFramework.setData();
        // curatorFramework.delete();
        // curatorFramework.getData();
    }

    private static void createData(CuratorFramework curatorFramework) throws Exception {
        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath("/maple/program", "up".getBytes());
    }
}
