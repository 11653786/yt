package junit;

import com.caucho.hessian.client.HessianProxyFactory;
import com.yt.webservice.hessian.HessianService;
import org.springframework.data.redis.core.RedisTemplate;

import java.net.MalformedURLException;


/**
 * Created by user on 2015/8/13.
 */
public class Test {
    static RedisTemplate redisTemplate;
    public static void main(String[] args) {
        //hessian测试调用方法
        String url="http://localhost:8080/hessian/webservice/hessianService.hessian";
        HessianProxyFactory factory=new HessianProxyFactory();
        try {
            HessianService hs=(HessianService)factory.create(HessianService.class,url);
            System.out.println(hs);
            hs.hello("hello,world!");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
