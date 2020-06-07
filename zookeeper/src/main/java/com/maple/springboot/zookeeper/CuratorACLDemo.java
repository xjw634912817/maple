package com.maple.springboot.zookeeper;

import com.google.common.collect.Lists;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.util.List;

public class CuratorACLDemo {

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .connectString("localhost:2181") // 地址
                .sessionTimeoutMs(5000) // 超时时间
//                .authorization("digest", "admin:admin".getBytes()) // 授权
                .retryPolicy(new ExponentialBackoffRetry(1000, 3)) // 重试策略
                .build();

        curatorFramework.start();
//        curatorFramework.setACL().withACL(ZooDefs.Ids.CREATOR_ALL_ACL).forPath("/temp"); // 设置权限
        createData(curatorFramework);
    }

    private static void createData(CuratorFramework curatorFramework) throws Exception {
        List<ACL> aclList = Lists.newArrayList();
        ACL acl = new ACL(ZooDefs.Perms.READ | ZooDefs.Perms.WRITE,
                new Id("digest", DigestAuthenticationProvider.generateDigest("admin:admin")));
        // new Id("ip", "127.0.0.1")
        aclList.add(acl);
        curatorFramework.create().withACL(aclList).forPath("/maple/auth", "up".getBytes());
    }
}
