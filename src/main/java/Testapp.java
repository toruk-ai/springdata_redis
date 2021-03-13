import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-redis.xml")
public class Testapp {

    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void setValue(){
        redisTemplate.boundValueOps("a").set("111");
    }
    @Test
    public void getValue(){
        String a = (String) redisTemplate.boundValueOps("a").get();
        System.out.println(a);
    }
    @Test
    public void delValue(){
        redisTemplate.delete("a");
    }
}
