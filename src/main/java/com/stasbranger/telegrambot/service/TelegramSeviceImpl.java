package com.stasbranger.telegrambot.service;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramSeviceImpl extends TelegramLongPollingBot  implements TelegramService 
{
	String text;

	@Override
	public void onUpdateReceived(Update update) 
	{	
		if (update.hasMessage() && update.getMessage().hasText())
		{
			text = "blabla";
			
			long chat_ID = update.getMessage().getChatId();
			SendMessage sender = new SendMessage(chat_ID,text);
			
			try 
			{
				execute(sender);
			} catch (TelegramApiException e) 
			{
				e.printStackTrace();
			}
		}
    }
	
	
	
	
	
	
    public String getBotUsername()   {return "Prova_testbot";}

	@Override
	public String getBotToken()   {return "704077882:AAF_93WcyyIPkw0pu1-cVVT_M-fCbnFzBjA";}

}
