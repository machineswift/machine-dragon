package com.machine.dragon.service.oms.order.resource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("client/oms/order")
public class DragonOrderResourceImpl implements DragonOrderResource {

    @Override
    @GetMapping("detail")
    public String detail() {
        String order = "order";
        log.info(order);
        return order;
    }
}
