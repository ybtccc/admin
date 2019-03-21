package com.demo.admin.mapper;

import com.demo.admin.pojo.SysUserSession;

public interface SysUserSessionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUserSession record);

    int insertSelective(SysUserSession record);

    SysUserSession selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUserSession record);

    int updateByPrimaryKey(SysUserSession record);
}