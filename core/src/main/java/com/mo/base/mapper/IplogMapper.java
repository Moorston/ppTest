package com.mo.base.mapper;

import com.mo.base.entity.Iplog;
import com.mo.base.query.IplogQueryObject;
import com.mo.base.query.QueryPageResult;

import java.util.List;

public interface IplogMapper {

    int insert(Iplog record);
    int queryForCount(IplogQueryObject queryObject);
    List<Iplog> query(IplogQueryObject queryObject);

}