package com.test.dev.login.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface loginDAO {
	public Map<String, Object> login(Map<String, Object> map);
}
