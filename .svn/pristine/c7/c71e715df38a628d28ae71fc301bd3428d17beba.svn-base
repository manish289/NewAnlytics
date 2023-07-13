package com.isource.connection.crm;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.core.type.TypeReference;

@Lazy
public interface DbContextserviceCrm {
	
	 <T> List<T> SPToList(String sp, Object[] paramsArray,TypeReference<List<T>> typeRef);
	 <T>T SPToFirst(String sp, Object[] paramsArray, TypeReference<T> typeRef);
	 int SPExecute(String sp, Object[] paramsArray);
	 Map<String, Object> SPExecuteWithOutParam(String sp, Object[] paramsArray);
	
}
