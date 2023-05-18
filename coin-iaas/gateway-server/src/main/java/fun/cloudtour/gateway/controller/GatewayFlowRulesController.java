package fun.cloudtour.gateway.controller;

import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author cloudtour
 * @version 1.0
 * @description TODO
 * @date 2023/4/10 21:21
 */
@RestController
public class GatewayFlowRulesController {
    @GetMapping("/gw/flow/reles")
    public Set<GatewayFlowRule> getGatewayFlowRules(){
        return GatewayRuleManager.getRules() ;
    }

    @GetMapping("/gw/api/groups")
    public Set<ApiDefinition> getApiGroupRules(){
        return GatewayApiDefinitionManager.getApiDefinitions();
    }
}
