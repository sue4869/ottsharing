package kr.flab.ottsharing.supports;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(AsyncExceptionHandler.class);

    @Override
    public void handleUncaughtException(Throwable exception, Method method, Object... params) {
        logger.error("==============>>>>>>>>>>>> ASYNC THREAD ERROR");
        logger.error("Exception Message :: {}", exception.getMessage());
        logger.error("Method Name :: " + method.getName());
        for (Object param : params) {
            logger.error("Parameter Value :: {}", param);
        }
        logger.error("==============>>>>>>>>>>>> ASYNC THREAD ERROR END");
    }
}


