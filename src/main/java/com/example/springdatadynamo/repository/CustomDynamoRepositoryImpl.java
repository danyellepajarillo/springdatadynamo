package com.example.springdatadynamo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.example.springdatadynamo.domain.DynamoData;
import com.example.springdatadynamo.pojo.Filter;

public class CustomDynamoRepositoryImpl implements CustomDynamoRepository{

	@Autowired
    DynamoDBMapper dynamoDBMapper;


	@Override
	public List<DynamoData> queryByGSI2PKAndGSI2SKWithDynamicFilter(String GSI2PK, String GSI2SK, List<Filter> filter) {
		
		DynamoData data = new DynamoData();	
		data.setGSI2PK(GSI2PK);
		
		Condition rangeKeyCondition = new Condition()
				.withComparisonOperator(ComparisonOperator.EQ)
				.withAttributeValueList(new AttributeValue().withS(GSI2SK));
		
		Map<String, Condition> filterMapCondition = new HashMap<String, Condition>();
		for(Filter f : filter) {
			Condition filterCondition = new Condition();
			if(f.getComparison().equals("BETWEEN")) {
				String[] value = f.getValue().split("#");
				List<AttributeValue> attributeValues = new ArrayList<AttributeValue>();
				attributeValues.add(new AttributeValue().withS(value[0]));
				attributeValues.add(new AttributeValue().withS(value[1]));
				filterCondition.withComparisonOperator(ComparisonOperator.BETWEEN);
				filterCondition.withAttributeValueList(attributeValues);
			} else if(f.getComparison().equals("NOT_NULL") || f.getComparison().equals("NULL")) {
				filterCondition.withComparisonOperator(ComparisonOperator.fromValue(f.getComparison()));
			}else {
				filterCondition.withComparisonOperator(ComparisonOperator.fromValue(f.getComparison()));
				filterCondition.withAttributeValueList(new AttributeValue().withS(f.getValue()));
			}

			filterMapCondition.put(f.getField(), filterCondition);
		}
		
		DynamoDBQueryExpression<DynamoData> queryExpression = new DynamoDBQueryExpression<DynamoData>()
				.withHashKeyValues(data)
				.withRangeKeyCondition("GSI-2-SK", rangeKeyCondition)
				.withQueryFilter(filterMapCondition);
		queryExpression.setConsistentRead(false);
				
		return dynamoDBMapper.query(DynamoData.class, queryExpression);
	}
	
	



	@Override
	public List<DynamoData> queryByGSI1PKWithDynamicFilter(String GSI1PK, List<Filter> filter) {
		DynamoData data = new DynamoData();	
		data.setGSI1PK(GSI1PK);
		
		Map<String, Condition> filterMapCondition = new HashMap<String, Condition>();
		for(Filter f : filter) {
			Condition filterCondition = new Condition();
			if(f.getComparison().equals("BETWEEN")) {
				String[] value = f.getValue().split("#");
				List<AttributeValue> attributeValues = new ArrayList<AttributeValue>();
				attributeValues.add(new AttributeValue().withS(value[0]));
				attributeValues.add(new AttributeValue().withS(value[1]));
				filterCondition.withComparisonOperator(ComparisonOperator.BETWEEN);
				filterCondition.withAttributeValueList(attributeValues);
			} else if(f.getComparison().equals("NOT_NULL") || f.getComparison().equals("NULL")) {
				filterCondition.withComparisonOperator(ComparisonOperator.fromValue(f.getComparison()));
			}else {
				filterCondition.withComparisonOperator(ComparisonOperator.fromValue(f.getComparison()));
				filterCondition.withAttributeValueList(new AttributeValue().withS(f.getValue()));
			}

			filterMapCondition.put(f.getField(), filterCondition);
		}
		
		DynamoDBQueryExpression<DynamoData> queryExpression = new DynamoDBQueryExpression<DynamoData>()
				.withHashKeyValues(data)
				.withQueryFilter(filterMapCondition);
		queryExpression.setConsistentRead(false);
				
		return dynamoDBMapper.query(DynamoData.class, queryExpression);
	}

	@Override
	public List<DynamoData> queryByPKWithDynamicFilter(String PK, List<Filter> filter) {
		DynamoData data = new DynamoData();	
		data.setPK(PK);
		
		Map<String, Condition> filterMapCondition = new HashMap<String, Condition>();
		for(Filter f : filter) {
			Condition filterCondition = new Condition();
			if(f.getComparison().equals("BETWEEN")) {
				String[] value = f.getValue().split("#");
				List<AttributeValue> attributeValues = new ArrayList<AttributeValue>();
				attributeValues.add(new AttributeValue().withS(value[0]));
				attributeValues.add(new AttributeValue().withS(value[1]));
				filterCondition.withComparisonOperator(ComparisonOperator.BETWEEN);
				filterCondition.withAttributeValueList(attributeValues);
			} else if(f.getComparison().equals("NOT_NULL") || f.getComparison().equals("NULL")) {
				filterCondition.withComparisonOperator(ComparisonOperator.fromValue(f.getComparison()));
			}else {
				filterCondition.withComparisonOperator(ComparisonOperator.fromValue(f.getComparison()));
				filterCondition.withAttributeValueList(new AttributeValue().withS(f.getValue()));
			}

			filterMapCondition.put(f.getField(), filterCondition);
		}
		
		DynamoDBQueryExpression<DynamoData> queryExpression = new DynamoDBQueryExpression<DynamoData>()
				.withHashKeyValues(data)
				.withQueryFilter(filterMapCondition);
		queryExpression.setConsistentRead(false);
				
		return dynamoDBMapper.query(DynamoData.class, queryExpression);
	}
	
	@Override
	public List<DynamoData> queryByGSI2PKWithDynamicFilter(String GSI2PK, List<Filter> filter) {
		DynamoData data = new DynamoData();	
		data.setGSI2PK(GSI2PK);
		
		Map<String, Condition> filterMapCondition = new HashMap<String, Condition>();
		for(Filter f : filter) {
			Condition filterCondition = new Condition();
			if(f.getComparison().equals("BETWEEN")) {
				String[] value = f.getValue().split("#");
				List<AttributeValue> attributeValues = new ArrayList<AttributeValue>();
				attributeValues.add(new AttributeValue().withS(value[0]));
				attributeValues.add(new AttributeValue().withS(value[1]));
				filterCondition.withComparisonOperator(ComparisonOperator.BETWEEN);
				filterCondition.withAttributeValueList(attributeValues);
			} else if(f.getComparison().equals("NOT_NULL") || f.getComparison().equals("NULL")) {
				filterCondition.withComparisonOperator(ComparisonOperator.fromValue(f.getComparison()));
			}else {
				filterCondition.withComparisonOperator(ComparisonOperator.fromValue(f.getComparison()));
				filterCondition.withAttributeValueList(new AttributeValue().withS(f.getValue()));
			}

			filterMapCondition.put(f.getField(), filterCondition);
		}
		
		DynamoDBQueryExpression<DynamoData> queryExpression = new DynamoDBQueryExpression<DynamoData>()
				.withHashKeyValues(data)
				.withQueryFilter(filterMapCondition);
		queryExpression.setConsistentRead(false);
				
		return dynamoDBMapper.query(DynamoData.class, queryExpression);
	}
}
