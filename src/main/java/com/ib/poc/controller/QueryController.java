package com.ib.poc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ib.poc.exception.PlatformException;
import com.ib.poc.model.Response;
import com.ib.poc.model.SummaryRes;
import com.ib.poc.repository.MessageRepository;
import com.ib.poc.utils.Constants;
import com.ib.poc.utils.ResponseData;


@RestController
public class QueryController {

	@Autowired
	private MessageRepository messageRepo;

	@GetMapping("/search")
	public ResponseEntity<ResponseData> uploadFileController(@RequestParam(value = "query", required=false) String query)
			throws PlatformException, IOException {
		if (ObjectUtils.isEmpty(query)) {
			return new ResponseEntity<ResponseData>(
					new ResponseData<String>("Required Query Parameter", Constants.FAILED, HttpStatus.BAD_REQUEST),
					HttpStatus.BAD_REQUEST);
		}
		
		Response response = prepareResponse(query);
		
		return new ResponseEntity<ResponseData>(
				new ResponseData<Response>(response, Constants.SUCCESS, HttpStatus.OK), HttpStatus.OK);

	}
	
	private Response prepareResponse(String query) {
			Response response = new Response();
		
			
			
		query = "%"+query+"%";
		List<Long> objs = messageRepo.findTruth(query);
		long totalCount = objs.get(0) + objs.get(1);
		response.setTotalMatches(totalCount);
		
		SummaryRes truth = new SummaryRes();
		truth.setSpam(objs.get(0));
		truth.setNotSpam(objs.get(1));
		response.setTruth(truth);
		
		
		
		objs = messageRepo.findCube(query);
		SummaryRes cube = new SummaryRes();
		cube.setSpam(objs.get(0));
		cube.setNotSpam(objs.get(1));
		response.setCube(cube);
		
		
		
		List<Object[]> objArr = messageRepo.findGoogle(query);
		SummaryRes google = new SummaryRes();
		google.setSpam((long)(objArr.get(0)[0]));
		google.setNotSpam((long)(objArr.get(1)[0]));
		double spam = ((double)(objArr.get(0)[2])) + ((double)(objArr.get(1)[2]));
		double notSpam = ((double)(objArr.get(0)[1])) + ((double)(objArr.get(1)[1]));
		google.setAvgNotSpamScore(notSpam);
		google.setAvgSpamScore(spam);
		response.setGoogle(google);
		
		
		objArr = messageRepo.findIbm(query);
		SummaryRes ibm = new SummaryRes();
		ibm.setSpam((long)(objArr.get(0)[0]));
		ibm.setNotSpam((long)(objArr.get(1)[0]));
		spam = ((double)(objArr.get(0)[2])) + ((double)(objArr.get(1)[2]));
		notSpam = ((double)(objArr.get(0)[1])) + ((double)(objArr.get(1)[1]));
		ibm.setAvgNotSpamScore(notSpam);
		ibm.setAvgSpamScore(spam);
		response.setIbm(ibm);
		
		return response;
		
	}

}

