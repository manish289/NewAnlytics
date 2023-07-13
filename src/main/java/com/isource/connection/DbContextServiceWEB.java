package com.isource.connection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.isource.connection.web.DbContextServiceWeb;
import com.isource.utility.CommonUtility;
import com.isource.utility.GenericConverter;

@Component
@Lazy
public class DbContextServiceWEB implements DbContextServiceWeb {

	@Autowired
	@Qualifier("jdbcTemplateWEB")   // by using this annotation can avoid ambiguity when Spring finds multiple beans of the same type.
	private JdbcTemplate jdbcTemplateWEB;

	/**
	 * @param - 1 = sp : StoredProcedure Name
	 * @param - 2 = paramsArray : StoredProcedure's Parameter
	 * @param - 3 = typeRef : Model / DTO  class object
	 * @return List of appropriate Model / DTO class 
	 */
	@SuppressWarnings("unchecked")  //it will access what we want to do that java generics will restricts.
	@Override
	public <T> List<T> SPToList(String sp, Object[] paramsArray, TypeReference<T> typeRef) {
		try {
			List<T> t = null;
			
			Object resultSetString = new SimpleJdbcCall(jdbcTemplateWEB)
									.withProcedureName(sp)
									.execute(paramsArray)
									.get("#result-set-1");
			t = (List<T>) CommonUtility.toObject(
						GenericConverter.convertData(resultSetString), 
						typeRef
						);
			return t;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @param - 1 = sp : StoredProcedure Name
	 * @param - 2 = paramsArray : StoredProcedure's Parameter
	 * @param - 3 = typeRef : Model / DTO  class object
	 * @return first [one] record of appropriate Model / DTO class 
	 */
	@Override
	public <T> T SPToFirst(String sp, Object[] paramsArray, TypeReference<T> typeRef) {
		try {
			T t = null;
			@SuppressWarnings("unchecked")
			List<Object> resultSetString = (List<Object>) new SimpleJdbcCall(jdbcTemplateWEB)
											.withProcedureName(sp)
											.execute(paramsArray)
											.get("#result-set-1");
			t = (T) CommonUtility.toObject(
					GenericConverter.convertData(resultSetString.get(0)), 
					typeRef
					);
			return t;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @param - 1 = sp : StoredProcedure Name
	 * @param - 2 = paramsArray : StoredProcedure's Parameter
	 * @return 1 for successful execution
	 * @return 0 for exception
	 */
	@Override
	public int SPExecute(String sp, Object[] paramsArray) {
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplateWEB)
											.withProcedureName(sp);
			simpleJdbcCall.execute(paramsArray).get("returnParameter");
			return 1;
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * @param - 1 = sp : StoredProcedure Name
	 * @param - 2 = paramsArray : StoredProcedure's Parameter
	 * @param - 3 = use output parameter name
	 * @return output parameter value when successful execution
	 * @return 0 for exception
	 */
	public Object SPExecuteWithOutParam(String sp, Object[] paramsArray,String OutParam) {
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplateWEB)
											.withProcedureName(sp);
			return simpleJdbcCall.execute(paramsArray).get(OutParam);
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * @param - 1 = query : to call function
	 * @param - 2 = paramsArray : function's Parameter
	 * @param - 3 = typeRef : Model / DTO.class object
	 * @return List of appropriate Model / DTO class 
	 */

	public <T> List<T> QueryToListWithParam(String query, Object[] paramsArray, Class<T> typeRef) {
		try {
			return (List<T>) jdbcTemplateWEB.query(query, 
					         BeanPropertyRowMapper.newInstance(typeRef), // beanPropertyRowMapper is used to take each row data and fetch in list so that we can get all data 
					         paramsArray);                                //  beanPropertyRowPower use for  mapping rows of a ResultSet on a per-row basis.
		}     
		
		catch (Exception e) {
			throw e;
		}
	}

	
	
//  Its all about BeanPropertyRowMapper =If User class property names and USER database table column names are exactly same, 
//we can use BeanPropertyRowMapper to get results instead of creating a mapper class for model class,
	// automatically populates each column value of a single row to corresponding bean property.
	
	
	/**
	 * @param - 1 = query : to call function
	 * @param - 2 = typeRef : Model / DTO.class object
	 * @return List of appropriate Model / DTO class 
	 */
	
	public <T> List<T> QueryToList(String query, Class<T> typeRef) {
		try {
			return (List<T>) jdbcTemplateWEB.query(query, 
							 BeanPropertyRowMapper.newInstance(typeRef));
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @param - 1 = query : to call function
	 * @param - 2 = typeRef : Model / DTO.class object
	 * @return first [one] record of appropriate Model / DTO class
	 */
	public <T> T QueryToFirst(String query, Class<T> typeRef) {
		try {
			T resultSetString = jdbcTemplateWEB.queryForObject(query, 
								BeanPropertyRowMapper.newInstance(typeRef));
			return resultSetString;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * @param - 1 = query : to call function
	 * @param - 2 = paramsArray : function's Parameter
	 * @param - 3 = typeRef : Model / DTO.class object
	 * @return first [one] record of appropriate Model / DTO class
	 */
	public <T> T QueryToFirstWithParam(String query, Object[] paramsArray, Class<T> typeRef) {
		try {
			T resultSetString = jdbcTemplateWEB.queryForObject(query, 
								BeanPropertyRowMapper.newInstance(typeRef),
								paramsArray);
			return resultSetString;
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	
	//Practise Method
//	public <T> T QueryToFirstWithParam(String query, Object[] paramArray, Class<T> TypeRef)
//	{
//		try {
//			
//			T resultsetString=jdbcTemplateWEB.queryForObject(query, BeanPropertyRowMapper.newInstance(TypeRef), paramArray);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		return null;
//		
//	}
//	
	
	
	/**
	 * use this method for insert
	 * return 1 for success
	 * return 0 for failure
	 */
	@SuppressWarnings("deprecation")
	public int QueryToFirstWithInt(String query, Object[] paramsArray) {
		int result = 0;
		try {    
			//When you run queryForObject() with no parameters, JdbcTemplate creates Statement, executes query and returns single row or single column value as result.
			result = (int) jdbcTemplateWEB.queryForObject(query, paramsArray, Integer.class);
		}catch(Exception ex) {
			ex.printStackTrace();
		}				
		return result;
	}
}
