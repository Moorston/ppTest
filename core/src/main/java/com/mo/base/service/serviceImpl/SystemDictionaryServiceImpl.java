package com.mo.base.service.serviceImpl;

import com.mo.base.entity.SystemDictionary;
import com.mo.base.entity.SystemDictionaryItem;
import com.mo.base.service.ISystemDictionaryService;

import java.util.List;

/**
 * Created by Moonston on 2017/10/25.
 */
public class SystemDictionaryServiceImpl implements ISystemDictionaryService {

    @Override
    public List<SystemDictionary> listAllDics() {
        return null;
    }

    @Override
    public List<SystemDictionaryItem> listByParentSn(String sn) {
        return null;
    }

    @Override
    public void saveOrUpdateDic(SystemDictionary dictionary) {

    }

    @Override
    public void saveOrUpdateItem(SystemDictionaryItem item) {

    }
}
