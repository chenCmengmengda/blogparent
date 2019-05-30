package com.blog.service.impl;

import com.blog.common.pojo.Result;
import com.blog.mapper.TbSysParameterMapper;
import com.blog.pojo.TbSysParameter;
import com.blog.pojo.TbSysParameterExample;
import com.blog.service.SysParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysParameterServiceImpl implements SysParameterService {

    @Autowired
    TbSysParameterMapper sysParameterMapper;

    /**
     * 获取系统参数
     * @return
     */
    @Override
    public Result getSysParameter() {
        TbSysParameterExample example=new TbSysParameterExample();
        List<TbSysParameter> list=sysParameterMapper.selectByExample(example);
        if(list.size()>0){
            return Result.ok(list.get(0));
        }
        return Result.ok();
    }

    @Override
    public Result editSysParameter(TbSysParameter sysParameter) {

        TbSysParameterExample example=new TbSysParameterExample();
        List<TbSysParameter> list=sysParameterMapper.selectByExample(example);
        if(list.size()>0) {//如果有数据，删除
            sysParameterMapper.deleteByExample(example);//删除原参数
        }
        sysParameterMapper.insert(sysParameter);
        list=sysParameterMapper.selectByExample(example);
        return Result.ok(list.get(0));
    }


}
