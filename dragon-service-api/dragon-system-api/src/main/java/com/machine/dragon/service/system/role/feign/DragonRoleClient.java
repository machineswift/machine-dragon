package com.machine.dragon.service.system.role.feign;

import com.machine.dragon.service.system.role.feign.outvo.DragonRoleDetailOutVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "dragon-system-service", path = "client/system/role")
public interface DragonRoleClient {

    @GetMapping("getByRoleId")
    DragonRoleDetailOutVO getByRoleId(@RequestParam(name = "roleId") Long roleId);
}
