package fun.cloudtour.config.jetcache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.context.annotation.Configuration;

/**
 * @author cloudtour
 * @version 1.0
 * @description TODO
 * @date 2023/4/11 21:43
 */
@Configuration
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "fun.cloudtour.service.impl")
public class JetCacheConfig {


}

