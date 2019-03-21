package com.demo.admin.mapper;

import com.demo.admin.pojo.SysRoleAuth;

public interface SysRoleAuthMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleAuth record);

    int insertSelective(SysRoleAuth record);

    SysRoleAuth selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRoleAuth record);

    int updateByPrimaryKey(SysRoleAuth record);
}