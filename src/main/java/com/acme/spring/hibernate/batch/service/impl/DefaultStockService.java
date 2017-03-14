/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.acme.spring.hibernate.batch.service.impl;

import com.acme.spring.hibernate.batch.domain.StockInt;
import com.acme.spring.hibernate.batch.repository.StockIntRepository;
import com.acme.spring.hibernate.batch.service.StockIntService;
import com.acme.spring.hibernate.domain.Stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * <p>A default implementation of {@link com.acme.spring.hibernate.batch.service.StockIntService}, it simply delegates all
 * operations to underlying {@link com.acme.spring.hibernate.batch.repository.StockIntRepository}.</p>
 *
 * @author <a href="mailto:jmnarloch@gmail.com">Jakub Narloch</a>
 */
@Service
@Transactional
public class DefaultStockService implements StockIntService {

    /**
     * <p>Represents the instance of {@link com.acme.spring.hibernate.batch.repository.StockIntRepository} </p>
     */
    @Autowired
    private StockIntRepository stockRepository;

	@Override
	public StockInt integrate(Stock stock) {

		StockInt stockInt = new StockInt();
		stockInt.setName( stock.getName() );
		stockInt.setSymbol( stock.getSymbol() );
		stockInt.setValue( stock.getValue() );
		stockInt.setDate( stock.getDate() );


		stockRepository.save(stockInt);

		return stockInt;
	}



}
