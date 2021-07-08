package com.tg.practice.spring.service;

import java.util.Locale;

public interface MessageFormatter {
	
	String format(String texto,Object[] objects,Locale locale);
}
