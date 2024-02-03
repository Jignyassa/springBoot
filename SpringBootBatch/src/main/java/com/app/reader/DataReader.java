package com.app.reader;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;
@Component
public class DataReader implements ItemReader<String> {
	String message[]= {"hi","hello","bye"};
	int index;

	@Override
	public String read() throws Exception,
	                            UnexpectedInputException, 
	                            ParseException, 
	                            NonTransientResourceException {
		if(index<message.length) {
			return message[index++];
		}else {
			index=0;
		}
		return null;
	}

}
