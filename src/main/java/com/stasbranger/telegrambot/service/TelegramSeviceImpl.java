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
			String name = update.getMessage().getFrom().getFirstName() +" "+ update.getMessage().getFrom().getLastName();
			text = "Ciao, "+ name;
			
			long chat_ID = update.getMessage().getChatId();
			SendMessage sender = new SendMessage(chat_ID,text);
			
			try 
			{
				execute(sender);
			} catch (TelegramApiException e) 
			{
				e.printStackTrace();
			}
			
			String txtlog = update.getMessage().getText();
			System.out.println(name +" "+ txtlog);
			
			
		}
    }
	
	
	
	
	
	
    public String getBotUsername()   {return "Prova_testbot";}

	@Override
	public String getBotToken()   {return "704077882:AAF_93WcyyIPkw0pu1-cVVT_M-fCbnFzBjA";}

}
