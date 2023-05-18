package fun.cloudtour.feign;

import fun.cloudtour.config.fegin.OAuth2FeignConfig;
import fun.cloudtour.domain.DepthItemVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "match-service", contextId = "orderBooksFeignClient", configuration = OAuth2FeignConfig.class)
public interface OrderBooksFeignClient {


    /**
     * 远程调用深度数据
     * @param symbol
     * @return
     */
    @GetMapping("/match/depth")
    Map<String, List<DepthItemVo>> getDepth(@RequestParam(required = true) String symbol) ;
}

