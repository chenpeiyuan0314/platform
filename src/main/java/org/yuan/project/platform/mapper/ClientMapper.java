package org.yuan.project.platform.mapper;

import java.util.Map;

import org.yuan.project.platform.entity.Client;

public interface ClientMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);
    
    //------------------------------------------------------
    // 手动添加方法
    //------------------------------------------------------
    
    /**
     * 根据条件查询记录数
     * @param args
     * 		电话(phone),密码(password)
     * @return
     */
    int selectCount(Map<String,Object> args);
}