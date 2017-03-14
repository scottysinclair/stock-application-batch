package com.acme.spring.hibernate.batch.integration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.acme.spring.hibernate.batch.integration.service.StockServiceInt;
import com.acme.spring.hibernate.domain.Stock;
import com.acme.spring.hibernate.service.StockService;

public class Application {


	public static void main(String args[]) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/stock-application-int-batch.xml");
		StockService stockService = ctx.getBean(StockService.class);
		StockServiceInt stockServiceInt = ctx.getBean(StockServiceInt.class);

		runIntegration(stockService, stockServiceInt);
	}

	private static void runIntegration(StockService stockService, StockServiceInt stockServiceInt) {
		for (Stock stock: stockService.getAll()) {
			stockServiceInt.integrate(stock);
		}
	}
}
