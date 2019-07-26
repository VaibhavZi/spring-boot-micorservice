package com.barclays.ipfp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.sun.jmx.snmp.Timestamp;
import com.barclays.ipfp.model.TransactionDetails;
import com.barclays.ipfp.repo.TransactionDetailsRepo;
import com.barclays.ipfp.service.FileReadingService;
import com.barclays.ipfp.service.TransactionDetailsService;
import com.barclays.ipfp.service.impl.TransactionDetailsServiceImpl;

@SpringBootApplication
public class IncomingPaymentFileProcessorApplication {
	
	private static final Logger log = LoggerFactory.getLogger(IncomingPaymentFileProcessorApplication.class);

	private static FileReadingService getfileReadingServiceInstance() {
		return new FileReadingService();
	}

	public static void main(String[] args) {
		ApplicationContext run = SpringApplication.run(IncomingPaymentFileProcessorApplication.class, args);
		/*for (String name: run.getBeanDefinitionNames()) {
            System.out.println(name);
            log.debug(name);
        }*/
		
		//readIncomingFiles();
		try {
			List<TransactionDetails> list = loadFile("C:\\Users\\10640143\\Desktop\\SpringBoot\\Incoming-Payment-File-Processor\\Files\\XL8_BWA_260712019_002.json");
			/*IncomingPaymentFileProcessorApplication app = new IncomingPaymentFileProcessorApplication();
			app.saveTransactionToDb(list);*/
		} catch (IOException e) {
			log.error(e.getMessage().toString());
			e.printStackTrace();
		}
	}

	void saveTransactionToDb(List<TransactionDetails> list) {
		for(TransactionDetails details : list) {
			TransactionDetailsService service = new TransactionDetailsServiceImpl();
			service.saveTransactionDetails(details);
		}
	}

	private static void readIncomingFiles() {
		getfileReadingServiceInstance().checkFilesInDir();
		
	}
	
	static List<TransactionDetails> loadFile(String filePath) throws IOException{
		List<TransactionDetails> listOfTransactions= new ArrayList<TransactionDetails>();
		int numberOfRecordsinFile=0;
		try(JsonReader jsonReader = new JsonReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))){
			GsonBuilder builder = new GsonBuilder();
			builder.setDateFormat("YYYYDDMMHHMMSSS");
			Gson gson = builder.create();
			
			jsonReader.beginArray();
			log.info("**READ START**"+new Timestamp().toString());
			while(jsonReader.hasNext()) {
				TransactionDetails payment = gson.fromJson(jsonReader, TransactionDetails.class);
				listOfTransactions.add(payment);
				numberOfRecordsinFile++;
			}
			log.info("**READ END**"+new Timestamp().toString());
		}
		log.info("**Total Transactions in**: "+filePath +"::"+numberOfRecordsinFile);
		return listOfTransactions;
	}

}
