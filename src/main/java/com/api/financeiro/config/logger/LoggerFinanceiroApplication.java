package com.api.financeiro.config.logger;

import com.api.financeiro.FinanceiroApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggerFinanceiroApplication {

    public static Logger logger = LoggerFactory.getLogger(FinanceiroApplication.class);

}
