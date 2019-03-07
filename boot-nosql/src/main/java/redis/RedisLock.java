package redis;

import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

/**
 * @author 谢仲东 2019/3/7 15:47
 */
public class RedisLock {

    private static final String HOST = "192.168.0.201";

    private static final int PORT = 7002;

    private static final String PASSPORT = "123456";

    /**
     * 加锁
     * @param lockKey key
     * @param lockValue value
     * @param expireSecond 锁超时时间
     * @return
     */
    public static boolean lock(String lockKey, String lockValue, int expireSecond) {
        Jedis jedis = new Jedis(HOST, PORT);
        jedis.auth(PASSPORT);
        long resp = jedis.setnx(lockKey, lockValue);
        if (resp == 1) jedis.expire(lockKey, expireSecond);
        return resp == 1;
    }


    /**
     *
     * @param lockKey key
     * @param lockValue value
     * @param expireSecond 锁超时时间
     * @param lockTime 尝试加锁次数
     * @param sleepSecond 每次尝试之间休眠时间
     * @return
     */
    public static boolean lock(String lockKey, String lockValue, int expireSecond, int lockTime, long sleepSecond) {
        Jedis jedis = new Jedis(HOST, PORT);
        jedis.auth(PASSPORT);
        do {
            long resp = jedis.setnx(lockKey, lockValue);
            if (resp == 1) {
                jedis.expire(lockKey, expireSecond);
                return true;
            }
            lockTime--;
            try {
                TimeUnit.SECONDS.sleep(sleepSecond);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (lockTime == 0);
        return false;
    }


    /**
     * 释放锁
     * @param lockKey key
     * @param lockValue value
     */
    public static void unlock(String lockKey, String lockValue) {
        Jedis jedis = new Jedis(HOST, PORT);
        jedis.auth(PASSPORT);
        if (lockValue.equals(jedis.get(lockKey))) {
            jedis.del(lockKey);
        }
    }
}
