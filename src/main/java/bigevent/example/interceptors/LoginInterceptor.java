package bigevent.example.interceptors;

import bigevent.example.pojo.Result;
import bigevent.example.utils.JwtUtil;
import bigevent.example.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 令牌验证
        String token = request.getHeader("Authorization");
        // 验证token
        try {
            // 从redis中获取相同的token
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            String redisToken = operations.get(token);
            if (redisToken == null) {
                // token已经失效
                throw new RuntimeException("token已经失效");
                // http响应状态码401
                // 验证失败，拦截
            }
            Map<String, Object> claims = JwtUtil.parseToken(token);
            // 把业务数据添加到ThreadLocal中
            ThreadLocalUtil.set(claims);

            // 验证通过，放行
            return true;
        } catch (Exception e) {
            // token验证失败
            // http响应状态码401
            response.setStatus(401);
            // 验证失败，拦截
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清除ThreadLocal中的数据
        ThreadLocalUtil.remove();
    }
}
