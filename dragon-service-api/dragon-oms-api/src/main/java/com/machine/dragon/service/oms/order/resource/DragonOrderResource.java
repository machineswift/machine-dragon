package com.machine.dragon.service.oms.order.resource;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "dragon-oms-service", path = "client/oms/order")
public interface DragonOrderResource {

    @GetMapping("detail")
    String detail();

}
