package com.machine.dragon.service.system.rabbit.resource.invo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DragonRabbitReliableMessageUpdate4SubscribeInVO {

    private String id;
    private Integer nextTimeMillis;
    private String reason;
    private String description;

    /**
     * 添加失败堆栈信息
     */
    @JsonIgnore
    public void setException(Exception exception) {
        StringBuilder reason = new StringBuilder();
        String lineSeparator = System.lineSeparator();
        reason.append(exception.toString())
                .append(": ")
                .append(exception.getMessage())
                .append(lineSeparator);
        for (StackTraceElement elem : exception.getStackTrace()) {
            reason.append(elem)
                    .append(lineSeparator);
        }
        this.setReason(reason.toString());
    }
}