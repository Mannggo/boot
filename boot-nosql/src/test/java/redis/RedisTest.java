package redis;

import org.junit.Test;

/**
 * @author 谢仲东 2019/3/7 16:05
 */
public class RedisTest {

    @Test
    public void testLock() {
        String lockKey = "tryLock";
        String lockValue = "xzd";
        RedisLock.lock(lockKey, lockValue, 10);
        RedisLock.unlock(lockKey, lockValue);
    }
}
