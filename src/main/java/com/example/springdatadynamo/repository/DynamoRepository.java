package com.example.springdatadynamo.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.springdatadynamo.domain.DynamoId;
import com.example.springdatadynamo.domain.DynamoData;


public interface DynamoRepository extends CrudRepository<DynamoData, DynamoId>, CustomDynamoRepository{
	

	List<DynamoData> findByPK(String PK);
	List<DynamoData> findByPKAndSK(String PK,String SK);
	List<DynamoData> findByGSI1PK(String GSI1PK);
	List<DynamoData> findByGSI1PKAndGSI1SK(String GSI1PK,String GSI1SK);
	List<DynamoData> findByGSI2PK(String GSI2PK);
	List<DynamoData> findByGSI2PKAndGSI2SK(String GSI2PK,String GSI2SK);
	
	void deleteByPK(String PK);
	void deleteByPKAndSK(String PK, String SK);
	void deleteByGSI1PK(String GSI1PK);
	void deleteByGSI1PKAndGSI1SK(String GSI1PK, String GSI1SK);
	void deleteByGSI2PK(String GSI1PK);
	void deleteByGSI2PKAndGSI2SK(String GSI2PK, String GSI2SK);

	
	
}
