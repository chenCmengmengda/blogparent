package com.blog.mapper;

import com.blog.pojo.TbSysParameter;
import com.blog.pojo.TbSysParameterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbSysParameterMapper {
    long countByExample(TbSysParameterExample example);

    int deleteByExample(TbSysParameterExample example);

    int deleteByPrimaryKey(String cmsname);

    int insert(TbSysParameter record);

    int insertSelective(TbSysParameter record);

    List<TbSysParameter> selectByExample(TbSysParameterExample example);

    TbSysParameter selectByPrimaryKey(String cmsname);

    int updateByExampleSelective(@Param("record") TbSysParameter record, @Param("example") TbSysParameterExample example);

    int updateByExample(@Param("record") TbSysParameter record, @Param("example") TbSysParameterExample example);

    int updateByPrimaryKeySelective(TbSysParameter record);

    int updateByPrimaryKey(TbSysParameter record);
}