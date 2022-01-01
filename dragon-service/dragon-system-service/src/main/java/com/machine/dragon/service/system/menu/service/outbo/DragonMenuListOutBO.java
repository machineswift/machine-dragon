package com.machine.dragon.service.system.menu.service.outbo;

import lombok.Data;

@Data
public class DragonMenuListOutBO {

    /**
     * 菜单Id
     */
    private Long menuId;

    /**
     * 父菜单Id。顶级菜单此字段为0
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
     * 在父菜单中的次序值。sort值大的排序靠前
     */
    private Long sort;

    /**
     * 是否打开新页面
     */
    private Boolean opened;
}