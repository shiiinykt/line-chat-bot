package com.chat.bot;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.linecorp.bot.client.LineBotAPIHeaders;
import com.linecorp.bot.client.LineBotClient;
import com.linecorp.bot.client.LineBotClientBuilder;
import com.linecorp.bot.model.callback.CallbackRequest;
import com.linecorp.bot.model.content.Content;
import com.linecorp.bot.model.content.TextContent;

public class ChatBot {
	private static Logger logger = LoggerFactory.getLogger(ChatBot.class);
	private static LineBotClient client = LineBotClientBuilder
             .create(System.getenv("CHANNEL_ID"), System.getenv("CHANNEL_SECRET"), System.getenv("CHANNEL_MID"))
             .build();
	 
	 public static void main(String[] args) {
		 	port(Integer.valueOf(System.getenv("PORT")));
		 
	        get("/hello", (req, res) -> "Chat-Bot");
		 	
	        post("/callback", (req, res) -> {
	        	String signature = req.headers(LineBotAPIHeaders.X_LINE_CHANNEL_SIGNATURE);
	        	client.readCallbackRequest(req.body());
	        	
	        	if (!client.validateSignature(req.body(), signature)) {
	        		logger.error("Request invalid!!");
	        	    return "NG";
	        	}
	        	
	        	CallbackRequest callbackRequest = client.readCallbackRequest(req.body());

	        	callbackRequest.getResult().stream().forEach(event -> {
	        		Content content = event.getContent();
	        		
		        	if (content instanceof TextContent) {
		        		TextContent text = (TextContent) content;
		        		try {
							client.sendText(text.getFrom(), text.getText());
							
						} catch (Exception e) {
							logger.error(e.getMessage());
							
						}
		        	}
	        	});    	
	        	
	        	return "OK";
	        });
	    }
}
