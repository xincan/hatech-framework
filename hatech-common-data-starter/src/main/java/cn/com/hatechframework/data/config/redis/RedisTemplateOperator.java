package cn.com.hatechframework.data.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Copyright (C), 2019, 北京同创永益科技发展有限公司
 *
 * @program hatech-framework
 * @package cn.com.hatechframework.config.redis
 * @className RedisTemplateUtils
 * @description RedisTemplate 操作工具类
 * @author WangMingShuai
 * @create 2019/12/30 10:48
 * @version 1.0
 * <Author>                <Time>                  <Version>                   <Description>
 * WangMingShuai         2019/12/30 10:48             1.0                         RedisTemplate 操作工具类
 */
@Component
public class RedisTemplateOperator {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 实现命令 : KEYS pattern
     * 查找所有符合 pattern 模式的 key
     * ?     匹配单个字符
     * *     匹配0到多个字符
     * [a-c] 匹配a和c
     * [ac]  匹配a到c
     * [^a]  匹配除了a以外的字符
     *
     * @param pattern redis pattern 表达式
     * @return
     */
    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }


    /**
     * 实现命令 : DEL key1 [key2 ...]
     * 删除一个或多个key
     *
     * @param keys
     * @return
     */
    public Long del(String... keys) {
        Set<String> keySet = Stream.of(keys).collect(Collectors.toSet());
        return redisTemplate.delete(keySet);
    }


    /**
     * @description 判断key是都存在
     * @param key  key值
     * @author YeMeng
     * @date 2019/12/30 17:32
     * @return boolean
     */
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }


    /**
     * 实现命令 : TYPE key
     * 查看 key 的 value 的类型
     *
     * @param key
     * @return
     */
    public String type(String key) {
        return redisTemplate.type(key).code();
    }


    /**
     * 实现命令 : PERSIST key
     * 取消 key 的超时时间，持久化 key
     *
     * @param key
     * @return
     */
    public Boolean persist(String key) {
        return redisTemplate.persist(key);
    }


    /**
     * 实现命令 : TTL key
     * 返回给定 key 的剩余生存时间,key不存在返回 null
     * 单位: 秒
     *
     * @param key
     * @return
     */
    public Long ttl(String key) {
        return redisTemplate.getExpire(key);
    }

    /**
     * 实现命令 : PTTL key
     * 返回给定 key 的剩余生存时间,key不存在返回 null
     * 单位: 毫秒
     *
     * @param key
     * @return
     */
    public Long pTtl(String key) {
        return redisTemplate.getExpire(key, TimeUnit.MILLISECONDS);
    }

    /**
     * 实现命令 : EXPIRE key 秒
     * 设置key 的生存时间
     * 单位 : 秒
     *
     * @param key
     * @return
     */
    public Boolean expire(String key, int ttl) {
        return redisTemplate.expire(key, ttl, TimeUnit.SECONDS);
    }

    /**
     * 实现命令 : PEXPIRE key 毫秒
     * 设置key 的生存时间
     * 单位 : 毫秒
     *
     * @param key
     * @return
     */
    public Boolean pExpire(String key, Long ttl) {
        return redisTemplate.expire(key, ttl, TimeUnit.MILLISECONDS);
    }

    /**
     * 实现命令 : EXPIREAT key Unix时间戳(自1970年1月1日以来的秒数)
     * 设置key 的过期时间
     *
     * @param key
     * @param date
     * @return
     */
    public Boolean expireAt(String key, Date date) {
        return redisTemplate.expireAt(key, date);
    }


    /**
     * 实现命令 : RENAME key newkey
     * 重命名key，如果newKey已经存在，则newKey的原值被覆盖
     *
     * @param oldKey
     * @param newKey
     */
    public void rename(String oldKey, String newKey) {
        redisTemplate.rename(oldKey, newKey);
    }

    /**
     * 实现命令 : RENAMENX key newkey
     * 安全重命名key，newKey不存在时才重命名
     *
     * @param oldKey
     * @param newKey
     * @return
     */
    public Boolean renameNx(String oldKey, String newKey) {
        return redisTemplate.renameIfAbsent(oldKey, newKey);
    }

    /**
     * 实现命令 : SET key value
     * 添加一个持久化的 String 类型的键值对
     *
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 实现命令 : SET key value EX 秒、 setex  key value 秒
     * 添加一个 String 类型的键值对，并设置生存时间
     *
     * @param key
     * @param value
     * @param ttl   key 的生存时间，单位:秒
     */
    public void set(String key, Object value, int ttl) {
        redisTemplate.opsForValue().set(key, value, ttl, TimeUnit.SECONDS);
    }


    /**
     * 实现命令 : SET key value PX 毫秒 、 psetex key value 毫秒
     * 添加一个 String 类型的键值对，并设置生存时间
     *
     * @param key
     * @param value
     * @param ttl   key 的生存时间，单位:毫秒
     */
    public void set(String key, Object value, long ttl) {
        redisTemplate.opsForValue().set(key, value, ttl, TimeUnit.MILLISECONDS);
    }

    /**
     * 实现命令 : GETSET key value
     * 设置 key 的 value 并返回旧 value
     *
     * @param key
     * @param value
     */
    public Object getSet(String key, Object value) {
        return redisTemplate.opsForValue().getAndSet(key, value);
    }


    /**
     * 实现命令 : GET key
     * 获取一个key的value
     *
     * @param key
     * @return value
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
    /**
     * 实现命令 : INCRBY key 整数
     * 给 value 加 上一个整数,value 必须是整数
     *
     * @param key
     * @return
     */
    public Long inCrBy(String key, Long number) {
        return redisTemplate.opsForValue().increment(key, number);
    }

    /**
     * 实现命令 : INCRBYFLOAT key 数
     * 给 value 加上一个小数,value 必须是数
     *
     * @param key
     * @return
     */
    public Double inCrByFloat(String key, double number) {
        return redisTemplate.opsForValue().increment(key, number);
    }

}
