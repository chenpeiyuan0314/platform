package org.yuan.project.platform.mapper;

import java.util.List;
import java.util.Map;

import org.yuan.project.platform.entity.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);
    
    //------------------------------------------------------
    // 手动添加方法
    //------------------------------------------------------
    
    /**
     * 根据条件查询记录总数
     * @param args
     * 		标识(id)
     * @return
     */
    int selectSize(Map<String,Object> args);
    
    /**
     * 根据条件查询记录列表
     * @param args
     * @return
     */
    List<Product> selectList(Map<String,Object> args);
}