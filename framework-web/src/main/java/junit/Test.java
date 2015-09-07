package junit;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * Created by user on 2015/8/13.
 */
public class Test {
    static RedisTemplate redisTemplate;
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        redisTemplate = context.getBean(RedisTemplate.class);
        redisTemplate.execute(new RedisCallback<Boolean>() {

            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(redisTemplate.getStringSerializer().serialize("kk"),
                        redisTemplate.getStringSerializer().serialize("na1231231me"));
                return true;
            }
        });
    }
}
