package com.mo.base.service.serviceImpl;

import com.mo.base.entity.Iplog;
import com.mo.base.mapper.IplogMapper;
import com.mo.base.query.IplogQueryObject;
import com.mo.base.query.QueryPageResult;
import com.mo.base.service.IplogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Moonston on 2017/10/28.
 */
@SuppressWarnings("unchecked")
@Service
public class IplogServiceImpl implements IplogService{
    @Autowired
    private IplogMapper iplogMapper;
    @Override
    public QueryPageResult query(IplogQueryObject qo) {
        System.out.println("BeginDate:"+qo.getBeginDate()+"endDate:"+qo.getEndDate());
        int count = this.iplogMapper.queryForCount(qo);
        if (count>0){
            List<Iplog> list = this.iplogMapper.query(qo);
            return new QueryPageResult(list,count,qo.getCurrentPage(),qo.getPageSize());
        }
        return QueryPageResult.empty(qo.getPageSize());
    }
}
