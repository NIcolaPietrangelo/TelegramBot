package com.stasbranger.telegrambot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

import com.stasbranger.telegrambot.service.TelegramSeviceImpl;

@SpringBootApplication
public class TelegramBotApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(TelegramBotApplication.class, args);
		
		ApiContextInitializer.init();
		TelegramBotsApi botApi = new TelegramBotsApi();
		
		try {
			botApi.registerBot(new TelegramSeviceImpl());
		} catch (TelegramApiRequestException e) {
			e.printStackTrace();
		}
	}
	

}
