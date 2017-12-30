package net.tine2k.eureka_consul_adapter.controller;

import com.netflix.config.ConfigurationManager;
import lombok.RequiredArgsConstructor;
import net.tine2k.eureka_consul_adapter.model.Agent;
import net.tine2k.eureka_consul_adapter.model.Config;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class AgentController {

    @GetMapping(value = "/v1/agent/self", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Agent getNodes() {
        String dataCenter = ConfigurationManager.getConfigInstance().getString("archaius.deployment.datacenter");
        return Agent.builder().config(Config.builder()
                .dataCenter(dataCenter).build())
                .build();
    }
}
