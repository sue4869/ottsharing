package kr.flab.ottsharing.supports;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class CustomRejectedExceptionHandler implements RejectedExecutionHandler {

    private static final Logger logger = LoggerFactory.getLogger(CustomRejectedExceptionHandler.class);

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        logger.error("==============>>>>>>>>>>>> RejectedExecution ERROR");
        logger.error("RejectedException 발생 :: {}", executor);
        logger.error("==============>>>>>>>>>>>> RejectedExecution ERROR END");
    }
}
