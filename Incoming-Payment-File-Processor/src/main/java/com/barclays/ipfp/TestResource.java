package com.barclays.ipfp;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.ipfp.model.TransactionDetails;
import com.barclays.ipfp.service.TransactionDetailsService;
import com.sun.jmx.snmp.Timestamp;

@RestController
@RequestMapping(path="/app")
public class TestResource {
	@Autowired
	TransactionDetailsService detailsService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(TestResource.class);

	
	@GetMapping
	public ResponseEntity<TransactionDetails> saveAll() throws IOException{
		
		IncomingPaymentFileProcessorApplication app = new IncomingPaymentFileProcessorApplication();
		List<TransactionDetails> list = IncomingPaymentFileProcessorApplication.loadFile("C:\\Users\\10640143\\Desktop\\SpringBoot\\Incoming-Payment-File-Processor\\Files\\XL8_BWA_260712019_002.json");
		logger.info("**Number of Records** "+list.size()+" ***SART TIME: "+new Timestamp().toString());
		detailsService.saveAllTransactionDetails(list);
		logger.info("***END TIME: "+new Timestamp().toString());
		return new ResponseEntity<TransactionDetails>(HttpStatus.OK);
	}

}
