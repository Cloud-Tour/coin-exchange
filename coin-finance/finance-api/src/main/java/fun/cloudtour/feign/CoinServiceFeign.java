package fun.cloudtour.feign;

import fun.cloudtour.config.fegin.OAuth2FeignConfig;
import fun.cloudtour.dto.CoinDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "finance-service",contextId = "coinServiceFeign" ,configuration = OAuth2FeignConfig.class,path = "/coins")
public interface CoinServiceFeign {

    @GetMapping("/list")
    public List<CoinDto> findCoins(@RequestParam(name = "coinIds") List<Long> coinIds) ;
}
