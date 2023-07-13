package com.isource.connection.web;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;

@Component
@Lazy
public interface DbContextServiceWeb {

	 <T> List<T> SPToList(String sp, Object[] paramsArray,TypeReference<T> typeRef);
	 <T>T SPToFirst(String sp, Object[] paramsArray, TypeReference<T> typeRef);
	 int SPExecute(String sp, Object[] paramsArray); 
	 Object SPExecuteWithOutParam(String sp, Object[] paramsArray,String OutParam);
	 
	 <T> List<T> QueryToListWithParam(String query, Object[] paramsArray, Class<T> typeRef);
	 
	 <T> List<T> QueryToList(String query, Class<T> typeRef);
	 <T> T QueryToFirst(String query,Class<T> typeRef);
	 <T> T QueryToFirstWithParam(String query, Object[] paramsArray,Class<T> typeRef);
	 int QueryToFirstWithInt(String query, Object[] paramsArray);
}
