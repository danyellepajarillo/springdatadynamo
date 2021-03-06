package com.example.springdatadynamo.domain;

import org.springframework.data.annotation.Id;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;



@DynamoDBTable(tableName="Test")
public class DynamoData {
	
	@Id
	private DynamoId dynamoId;
	
	private String GSI1PK;
	private String GSI1SK;
	private String GSI2PK;
	private String GSI2SK;
	private String attribute1;
	private String attribute2;
	
	public DynamoData(String PK, String SK, String GSI1PK, String GSI1SK, String GSI2PK, String GSI2SK) {
		this.GSI1PK = GSI1PK;
		this.GSI1SK = GSI1SK;
		this.GSI2PK = GSI2PK;
		this.GSI2SK = GSI2SK;
		this.dynamoId = new DynamoId();
        this.dynamoId.setPK(PK);
        this.dynamoId.setSK(SK);
	}
	
	
	public DynamoData() {
		// Default constructor is required by AWS DynamoDB SDK
	}


	@DynamoDBAutoGeneratedKey
	@DynamoDBHashKey(attributeName = "PK")
	public String getPK() {
		return dynamoId != null ? dynamoId.getPK() : null;
	}

	public void setPK(String pK) {
		if (dynamoId == null) {
			dynamoId = new DynamoId();
		}
		dynamoId.setPK(pK);
	}

	@DynamoDBRangeKey(attributeName = "SK")
	public String getSK() {
		return dynamoId != null ? dynamoId.getSK() : null;
	}

	public void setSK(String sK) {
		if (dynamoId == null) {
			dynamoId = new DynamoId();
		}
		dynamoId.setSK(sK);
	}

	@DynamoDBAttribute()
	@DynamoDBIndexHashKey(attributeName = "GSI-1-PK", globalSecondaryIndexName = "GSI-1")
	public String getGSI1PK() {
		return GSI1PK;
	}
	
	public void setGSI1PK(String gSI1PK) {
		GSI1PK = gSI1PK;
	}

	@DynamoDBIndexRangeKey(attributeName = "GSI-1-SK", globalSecondaryIndexName = "GSI-1")
	public String getGSI1SK() {
		return GSI1SK;
	}

	public void setGSI1SK(String gSI1SK) {
		GSI1SK = gSI1SK;
	}
	
	@DynamoDBAttribute()
	@DynamoDBIndexHashKey(attributeName = "GSI-2-PK", globalSecondaryIndexName = "GSI-2")
	public String getGSI2PK() {
		return GSI2PK;
	}
	
	public void setGSI2PK(String gSI2PK) {
		GSI2PK = gSI2PK;
	}

	@DynamoDBIndexRangeKey(attributeName = "GSI-2-SK", globalSecondaryIndexName = "GSI-2")
	public String getGSI2SK() {
		return GSI2SK;
	}

	public void setGSI2SK(String gSI2SK) {
		GSI2SK = gSI2SK;
	}

	@DynamoDBAttribute( attributeName = "attribute1")
	public String getAttribute1() {
		return attribute1;
	}


	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	@DynamoDBAttribute( attributeName = "attribute2")
	public String getAttribute2() {
		return attribute2;
	}


	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}



}
