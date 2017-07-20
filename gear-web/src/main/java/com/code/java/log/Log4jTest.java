package com.code.java.log;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

/**
 * Created by 刘长申 on 2017/7/13.
 */
public class Log4jTest {
    public static void main(String[] arg){
//        Properties prop =  new  Properties();
        InputStream in = Object. class .getResourceAsStream( "/config/log4j.properties" );
        BasicConfigurator.configure();
//        Logger logger  =
//        try  {
//            prop.load(in);
//            logger.debug("参数:{}"+ prop.getProperty("log4j.rootLogger"));
//        }  catch  (IOException e) {
//            e.printStackTrace();
//        }
//
//        logger.debug( " debug " );
//        logger.error( " error " );

        String name = "hzh";
        Logger logger = LoggerFactory.getLogger(Log4jTest.class);
        logger.debug("Hello World");
        logger.info("hello {}", name);
        logger.error("error log");
    }
}
