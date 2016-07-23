package org.yuan.project.platform.mapper;

import org.yuan.project.platform.entity.Genre;

public interface GenreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Genre record);

    int insertSelective(Genre record);

    Genre selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Genre record);

    int updateByPrimaryKey(Genre record);
}