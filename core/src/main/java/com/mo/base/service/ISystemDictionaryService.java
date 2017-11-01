package com.mo.base.service;

import com.mo.base.entity.SystemDictionary;
import com.mo.base.entity.SystemDictionaryItem;

import java.util.List;

/**
 * Created by Moonston on 2017/10/25.
 */
public interface ISystemDictionaryService {


    /**
     * 查询所有的数据字典明细
     */
    List<SystemDictionary> listAllDics();

    /**
     * 根据数据字典分类sn查询明细
     *
     * @param sn
     * @return
     */
    List<SystemDictionaryItem> listByParentSn(String sn);

    /**
     * 修改或者保存数据字典分类
     *
     * @param dictionary
     */
    void saveOrUpdateDic(SystemDictionary dictionary);


    /**
     * 修改或者保存数据字典明细
     *
     * @param item
     */
    void saveOrUpdateItem(SystemDictionaryItem item);

}
