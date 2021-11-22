package com.machine.dragon.service.system.department.mapper.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class DragonDepartmentEntity {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 租户id
     */
    private Integer tenantId;

    /**
     * 部门Id。根部门此字段为1
     */
    private Long departmentId;

    /**
     * 父部门Id。根部门此字段为0
     */
    private Long parentId;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 在父部门中的次序值。sort值大的排序靠前
     */
    private Long sort;

    /**
     * 创建时间
     */
    private ZonedDateTime createTime;

    /**
     * 更新时间
     */
    private ZonedDateTime updateTime;

    /**
     * 是否已删除
     */
    private Boolean deleted;
}