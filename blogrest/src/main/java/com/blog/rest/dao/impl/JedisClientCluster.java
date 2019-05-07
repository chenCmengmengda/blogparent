package com.blog.rest.dao.impl;

import com.blog.rest.dao.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisCluster;

/**
 * Created by 陈_C on 2018/7/17.
 */
public class JedisClientCluster implements JedisClient {

    @Autowired
    private JedisCluster jedisCluster;

    /**
     * 获取值
     * @param key
     * @return
     */
    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

    /**
     * 设置键值对
     * @param key
     * @param value
     * @return
     */
    @Override
    public String set(String key, String value) {
        return jedisCluster.set(key, value);
    }

    /**
     *
     * @param hkey
     * @param key
     * @return
     */
    @Override
    public String hget(String hkey, String key) {
        return jedisCluster.hget(hkey, key);
    }

    /**
     * 设置散列
     * @param hkey
     * @param key
     * @param value
     * @return
     */
    @Override
    public long hset(String hkey, String key, String value) {
        return jedisCluster.hset(hkey, key, value);
    }

    /**
     * 值+1
     * @param key
     * @return
     */
    @Override
    public long incr(String key) {
        return jedisCluster.incr(key);
    }

    /**
     * 设置过期时间
     * @param key
     * @param second
     * @return
     */
    @Override
    public long expire(String key, int second) {
        return jedisCluster.expire(key, second);
    }

    /**
     * 查看剩余生存时间
     * @param key
     * @return
     */
    @Override
    public long ttl(String key) {
        return jedisCluster.ttl(key);
    }

    /**
     * 删除键
     * @param key
     * @return
     */
    @Override
    public long del(String key){
        return  jedisCluster.del(key);
    }

    /**
     * 删除一个或者多个键值对
     * @param hkey
     * @param key
     * @return
     */
    @Override
    public long hdel(String hkey, String key) {

        return jedisCluster.hdel(hkey,key);
    }


}
