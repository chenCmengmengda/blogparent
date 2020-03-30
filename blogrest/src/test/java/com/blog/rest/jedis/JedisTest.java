package com.blog.rest.jedis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 陈_C on 2018/7/17.
 */
public class JedisTest {

    @Test
    public void testJedisSingle() {
        //创建一个jedis的对象。
        Jedis jedis = new Jedis("192.168.204.129", 6379);
        //调用jedis对象的方法，方法名称和redis的命令一致。
        jedis.set("key1", "jedis test");
        String string = jedis.get("key1");
        System.out.println(string);
        //关闭jedis。
        jedis.close();
    }

    /**
     * 使用连接池
     */
    @Test
    public void testJedisPool() {
        //创建jedis连接池
        JedisPool pool = new JedisPool("192.168.204.129", 6379);
        //从连接池中获得Jedis对象
        Jedis jedis = pool.getResource();
        String string = jedis.get("key1");
        System.out.println(string);
        //关闭jedis对象
        jedis.close();
        pool.close();
    }

    /**
     * 集群测试
     */
    @Test
    public void testJedisCluster() throws IOException {
        HashSet<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.204.129", 7001));
        nodes.add(new HostAndPort("192.168.204.129", 7002));
        nodes.add(new HostAndPort("192.168.204.129", 7003));
        nodes.add(new HostAndPort("192.168.204.129", 7004));
        nodes.add(new HostAndPort("192.168.204.129", 7005));
        nodes.add(new HostAndPort("192.168.204.129", 7006));

        JedisCluster cluster = new JedisCluster(nodes);

        cluster.set("key1", "1000");
        String string = cluster.get("key1");
        System.out.println(string);

        cluster.close();
    }

    /**
     * 集群整合测试
     */
    @Test
    public void testSpringJedisCluster() throws IOException {
    /*    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        JedisCluster jedisCluster =  (JedisCluster) applicationContext.getBean("redisClient");

        String string = jedisCluster.get("qwe");
        System.out.println(string);
        jedisCluster.close();
*/
    /*
        int a = 0;
        JedisPoolConfig i2 = new JedisPoolConfig();
        i2.setMaxTotal(30);
        i2.setMinIdle(5);
        i2.setMaxIdle(10);
        i2.setMaxWaitMillis(10000);
        i2.setTestOnBorrow(true);
        i2.setTestOnReturn(true);
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("119.29.130.199", 7001));
        nodes.add(new HostAndPort("119.29.130.199", 7002));
        nodes.add(new HostAndPort("119.29.130.199", 7003));
        nodes.add(new HostAndPort("119.29.130.199", 7004));
        nodes.add(new HostAndPort("119.29.130.199", 7005));
        nodes.add(new HostAndPort("119.29.130.199", 7006));
        JedisCluster jedis = new JedisCluster(nodes, 6000, 6000, 3, "chencblog_redis",i2);


        System.out.println(jedis.get("qwe"));

        jedis.close();
*/
    }


}
