package com.mo.base.mapper;

import com.mo.base.entity.SystemDictionaryItem;

import java.util.List;

/**
 * Created by Moonston on 2017/10/25.
 */
public interface SystemDictionaryItemMapper {
    int insert(SystemDictionaryItem record);

    SystemDictionaryItem selectByPrimaryKey(Long id);

    int updateByPrimaryKey(SystemDictionaryItem record);

    /**
     * 根据数据字典分类sn查询明细
     * @param sn
     * @return
     */
    List<SystemDictionaryItem> listByParentSn(String sn);
}
