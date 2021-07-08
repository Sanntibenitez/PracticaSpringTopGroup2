package com.tg.practice.spring.dao.impl;

import java.util.Locale;

import org.springframework.context.MessageSource;

import com.tg.practice.spring.service.MessageFormatter;

public class LanguageFormatter implements MessageFormatter {

	private MessageSource messageSource;

	public String format(String texto, Object[] objects, Locale locale) {
		return messageSource.getMessage(texto, objects, locale);
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource _messageSource) {
		this.messageSource = _messageSource;
	}

}
