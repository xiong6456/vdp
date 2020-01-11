package java;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class RedisTest {
    // 单实例连接redis
    @Test
    public void testJedisSingle() {

        Jedis jedis = new Jedis("39.96.199.150", 6379);
        jedis.set("name", "bar");
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();

    }
}
