package com.example.springdatadynamo.repository;

import java.util.List;
import com.example.springdatadynamo.domain.DynamoData;
import com.example.springdatadynamo.pojo.Filter;


public interface CustomDynamoRepository {

	List<DynamoData> queryByPKWithDynamicFilter(String PK, List<Filter> filter);
	List<DynamoData> queryByGSI1PKWithDynamicFilter(String GSI1PK, List<Filter> filter);
	List<DynamoData> queryByGSI2PKWithDynamicFilter(String GSI2PK, List<Filter> filter);
	List<DynamoData> queryByGSI2PKAndGSI2SKWithDynamicFilter(String GSI2PK, String GSI2SK, List<Filter> filter);
}
