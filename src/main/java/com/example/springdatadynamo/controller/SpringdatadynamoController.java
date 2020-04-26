package com.example.springdatadynamo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.springdatadynamo.domain.DynamoData;
import com.example.springdatadynamo.pojo.Filter;
import com.example.springdatadynamo.repository.DynamoRepository;


@RestController
@RequestMapping("/api")
public class SpringdatadynamoController {
	
	@Autowired
	private DynamoRepository dynamoRepository;
	
	@RequestMapping(value = "/findByPK/{PK}", method = RequestMethod.GET)
	public ResponseEntity<List<DynamoData>> findByPK(@PathVariable String PK){
		List<DynamoData> result = dynamoRepository.findByPK(PK);
		return new ResponseEntity(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findByGSI1PK/{GSI1PK}", method = RequestMethod.GET)
	public ResponseEntity<List<DynamoData>> findByGSI1PK(@PathVariable String GSI1PK){
		List<DynamoData> result = dynamoRepository.findByGSI1PK(GSI1PK);
		return new ResponseEntity(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findByGSI2PK/{GSI2PK}", method = RequestMethod.GET)
	public ResponseEntity<List<DynamoData>> findByGSI2PK(@PathVariable String GSI2PK){
		List<DynamoData> result = dynamoRepository.findByGSI2PK(GSI2PK);
		return new ResponseEntity(result,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/findByPKAndSK", method = RequestMethod.GET)
	public ResponseEntity<List<DynamoData>> findByPKAndSK(@RequestParam String PK, @RequestParam String SK){
		List<DynamoData> result = dynamoRepository.findByPKAndSK(PK, SK);
		return new ResponseEntity(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findByGSI1PKAndGSI1SK", method = RequestMethod.GET)
	public ResponseEntity<List<DynamoData>> findByGSI1PKAndGSI1SK(@RequestParam String GSI1PK, @RequestParam String GSI1SK){
		List<DynamoData> result = dynamoRepository.findByGSI1PKAndGSI1SK(GSI1PK, GSI1SK);
		return new ResponseEntity(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findByGSI2PKAndGSI2SK", method = RequestMethod.GET)
	public ResponseEntity<List<DynamoData>> findByGSI2PKAndGSI2SK(@RequestParam String GSI2PK, @RequestParam String GSI2SK){
		List<DynamoData> result = dynamoRepository.findByGSI2PKAndGSI2SK(GSI2PK, GSI2SK);
		return new ResponseEntity(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<DynamoData> save(@RequestBody DynamoData forkliftIQ){
		forkliftIQ = dynamoRepository.save(forkliftIQ);
		
		return new ResponseEntity(forkliftIQ,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteByPK/{PK}")
	public void deleteByPK(@PathVariable String PK){
		dynamoRepository.deleteByPK(PK);
	}
	
	@DeleteMapping(value="/deleteByGSI1PK/{GSI1PK}")
	public void deleteByGSI1PK(@PathVariable String GSI1PK){
		dynamoRepository.deleteByGSI1PK(GSI1PK);
	}
	
	@DeleteMapping(value="/deleteByPKAndSK")
	public void deleteByPKAndSK(@RequestParam String PK, @RequestParam String SK){
		dynamoRepository.deleteByPKAndSK(PK, SK);
	}
	
	@DeleteMapping(value="/deleteByGSI1PKAndGSI1SK")
	public void deleteByGSI1PKAndGSI1SK(@RequestParam String GSI1PK, @RequestParam String GSI1SK){
		dynamoRepository.deleteByGSI1PKAndGSI1SK(GSI1PK, GSI1SK);
	}
	
	@DeleteMapping(value="/deleteByGSI2PKAndGSI2SK")
	public void deleteByGSI2PKAndGSI2SK(@RequestParam String GSI2PK, @RequestParam String GSI2SK){
		dynamoRepository.deleteByGSI2PKAndGSI2SK(GSI2PK, GSI2SK);
	}
	
	@RequestMapping(value = "/queryByPKWithDynamicFilter", method = RequestMethod.GET)
	public ResponseEntity<List<DynamoData>> queryByPKWithDynamicFilter(@RequestParam String PK, @RequestBody List<Filter> filter){

		List<DynamoData> result = dynamoRepository.queryByPKWithDynamicFilter(PK,filter);
		return new ResponseEntity(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/queryByGSI1PKWithDynamicFilter", method = RequestMethod.GET)
	public ResponseEntity<List<DynamoData>> queryByGSI1PKWithDynamicFilter(@RequestParam String GSI1PK, @RequestBody List<Filter> filter){

		List<DynamoData> result = dynamoRepository.queryByGSI1PKWithDynamicFilter(GSI1PK,filter);
		return new ResponseEntity(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/queryByGSI2PKWithDynamicFilter", method = RequestMethod.GET)
	public ResponseEntity<List<DynamoData>> queryByGSI2PKWithDynamicFilter(@RequestParam String GSI2PK, @RequestBody List<Filter> filter){

		List<DynamoData> result = dynamoRepository.queryByGSI2PKWithDynamicFilter(GSI2PK,filter);
		return new ResponseEntity(result,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/queryByGSI2PKAndGSI2SKWithDynamicFilter", method = RequestMethod.GET)
	public ResponseEntity<List<DynamoData>> queryByGSI2PKAndGSI2SKWithDynamicFilter(@RequestParam String GSI2PK, @RequestParam String GSI2SK, @RequestBody List<Filter> filter){

		List<DynamoData> result = dynamoRepository.queryByGSI2PKAndGSI2SKWithDynamicFilter(GSI2PK,GSI2SK,filter);
		return new ResponseEntity(result,HttpStatus.OK);
	}
}
