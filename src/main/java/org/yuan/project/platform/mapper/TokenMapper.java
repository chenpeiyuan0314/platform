package org.yuan.project.platform.mapper;

import java.util.Map;

import org.yuan.project.platform.entity.Token;

public interface TokenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Token record);

    int insertSelective(Token record);

    Token selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Token record);

    int updateByPrimaryKey(Token record);
    
    //------------------------------------------------------
    // 手动添加方法
    //------------------------------------------------------
    
    /**
     * 根据条件查询单条记录
     * @param args
     * 		令牌编码(code),过期时间(date)
     * @return
     */
    Token selectSole(Map<String,Object> args);
}