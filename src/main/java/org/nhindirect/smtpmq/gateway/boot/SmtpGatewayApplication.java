package org.nhindirect.smtpmq.gateway.boot;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.subethamail.smtp.server.SMTPServer;

@ComponentScan({"org.nhindirect.smtpmq.gateway"})
@SpringBootApplication
@EnableScheduling
public class SmtpGatewayApplication implements CommandLineRunner
{
	@Autowired
	protected ConnectionFactory connectionFactory; 

	@Autowired 
	protected SMTPServer smtpServer;
	
	public static void main(String[] args) 
	{
		new SpringApplicationBuilder(SmtpGatewayApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);		
    }	
	
	@Override
	public void run(String... args) throws Exception 
	{
	    smtpServer.start();
	}	
}
