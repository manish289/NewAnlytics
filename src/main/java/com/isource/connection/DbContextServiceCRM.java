package com.isource.connection;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.isource.connection.crm.DbContextserviceCrm;
import com.isource.utility.CommonUtility;
import com.isource.utility.GenericConverter;

@Component
@Lazy
public class DbContextServiceCRM implements DbContextserviceCrm {

	@Autowired
	@Qualifier("jdbcTemplateCRM")
	private JdbcTemplate jdbcTemplateCRM;

	@SuppressWarnings("unused")
	private Logger logger = null;

	public DbContextServiceCRM() {
		logger = Logger.getLogger(DbContextServiceCRM.class);
	}

	@Override
	public <T> List<T> SPToList(String sp, Object[] paramsArray, TypeReference<List<T>> typeRef) {
		try {
			List<T> t = null;
			Object resultSetString = new SimpleJdbcCall(jdbcTemplateCRM).withProcedureName(sp).execute(paramsArray)
					.get("#result-set-1");
			t = (List<T>) CommonUtility.toObject(GenericConverter.convertData(resultSetString), typeRef);
			return t;
		} catch (Exception e) {
			throw e;
		}
	}
		
	@Override
	public <T> T SPToFirst(String sp, Object[] paramsArray, TypeReference<T> typeRef) {
		try {
			T t = null;
			@SuppressWarnings("unchecked")
			List<Object> resultSetString = (List<Object>) new SimpleJdbcCall(jdbcTemplateCRM).withProcedureName(sp)
					.execute(paramsArray).get("#result-set-1");
			t = (T) CommonUtility.toObject(GenericConverter.convertData(resultSetString.get(0)), typeRef);
			return t;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int SPExecute(String sp, Object[] paramsArray) {
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplateCRM).withProcedureName(sp);
			simpleJdbcCall.execute(paramsArray).get("returnParameter");
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * @param - 1 = sp : StoredProcedure Name
	 * @param - 2 = paramsArray : StoredProcedure's Parameter
	 * @param - 3 = use output parameter name
	 * @return output parameter value when successful execution
	 * @return 0 for exception
	 */
	public Map<String, Object> SPExecuteWithOutParam(String sp, Object[] paramsArray) {
		try {
			SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplateCRM).withProcedureName(sp);
			return simpleJdbcCall.execute(paramsArray);// .get(OutParam);
		} catch (Exception e) {
			throw e;
		}
	}
}
