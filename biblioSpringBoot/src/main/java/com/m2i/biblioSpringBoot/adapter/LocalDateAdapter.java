package com.m2i.biblioSpringBoot.adapter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	/**
	 * xml --> java
	 */
	@Override
	public LocalDate unmarshal(String localDateChaine) throws Exception {
		LocalDate localDate = LocalDate.parse(localDateChaine, DateTimeFormatter.ISO_DATE);
		return localDate;
	}

	/**
	 * java->xml
	 */
	@Override
	public String marshal(LocalDate localDate) throws Exception {
		String localDateChaine = localDate.format(DateTimeFormatter.ISO_DATE);
		return localDateChaine;
	}

}
