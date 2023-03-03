package com.m2i.biblioSpringBoot.adapter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

	/**
	 * xml --> java
	 */
	@Override
	public LocalDateTime unmarshal(String localDateTimeChaine) throws Exception {
		LocalDateTime localDateTime = LocalDateTime.parse(localDateTimeChaine, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		return localDateTime;
	}

	/**
	 * java->xml
	 */
	@Override
	public String marshal(LocalDateTime localDateTime) throws Exception {
		String localDateTimeChaine = localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
		return localDateTimeChaine;
	}

}
