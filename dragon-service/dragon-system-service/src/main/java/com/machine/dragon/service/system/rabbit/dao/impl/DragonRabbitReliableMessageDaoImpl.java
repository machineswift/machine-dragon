package com.machine.dragon.service.system.rabbit.dao.impl;

import com.machine.dragon.common.tool.jackson.DragonJsonUtil;
import com.machine.dragon.service.system.rabbit.dao.DragonRabbitReliableMessageDao;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageInitInDTO;
import com.machine.dragon.service.system.rabbit.dao.indto.DragonRabbitReliableMessageUpdate4SubscribeInDTO;
import com.machine.dragon.service.system.rabbit.dao.outdto.DragonRabbitReliableMessageOutDTO;
import com.machine.dragon.service.system.rabbit.mapper.DragonRabbitReliableMessageMapper;
import com.machine.dragon.service.system.rabbit.mapper.entity.DragonRabbitReliableMessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DragonRabbitReliableMessageDaoImpl implements DragonRabbitReliableMessageDao {

    @Autowired
    private DragonRabbitReliableMessageMapper dragonRabbitReliableMessageMapper;

    @Override
    public String insert(DragonRabbitReliableMessageInitInDTO inDto) {
        DragonRabbitReliableMessageEntity entity = DragonJsonUtil.copy(inDto, DragonRabbitReliableMessageEntity.class);
        //todo 处理租户信息
        entity.setTenantId(1);
        dragonRabbitReliableMessageMapper.insert(entity);
        return entity.getId();
    }

    @Override
    public int deleteById(String id) {
        return dragonRabbitReliableMessageMapper.deleteById(id);
    }

    @Override
    public void deadById(String id) {
        dragonRabbitReliableMessageMapper.deadById(id);
    }

    @Override
    public void update4Subscribe(DragonRabbitReliableMessageUpdate4SubscribeInDTO inDto) {
        dragonRabbitReliableMessageMapper.update4Subscribe(inDto);
    }

    @Override
    public int update4ResendMessage(String id,
                                    Long updateTime,
                                    Integer nextTimeMillis) {
        return dragonRabbitReliableMessageMapper.update4ResendMessage(id, updateTime, nextTimeMillis);
    }

    @Override
    public DragonRabbitReliableMessageOutDTO getById(String id) {
        DragonRabbitReliableMessageEntity entity = dragonRabbitReliableMessageMapper.selectById(id);
        if (null == entity) {
            return null;
        }
        return DragonJsonUtil.copy(entity, DragonRabbitReliableMessageOutDTO.class);
    }

    @Override
    public String getIdByMessageKey(String messageKey) {
        return dragonRabbitReliableMessageMapper.getIdByMessageKey(messageKey);
    }

    @Override
    public List<DragonRabbitReliableMessageOutDTO> listByCurrentTimeMillis(Long currentTimeMillis) {
        List<DragonRabbitReliableMessageEntity> entityList = dragonRabbitReliableMessageMapper.selectByCurrentTimeMillis(currentTimeMillis);
        if (CollectionUtils.isEmpty(entityList)) {
            return Collections.EMPTY_LIST;
        }
        return entityList.stream().map(a -> DragonJsonUtil.copy(a, DragonRabbitReliableMessageOutDTO.class)).collect(Collectors.toList());
    }

}
