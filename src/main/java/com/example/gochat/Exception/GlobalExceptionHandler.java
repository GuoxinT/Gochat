package com.example.gochat.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public jsonResult myExceptionHandler(HttpServletResponse req, MyException e) {
        logger.error("出现业务异常: ", e);
        return jsonResult.error(e);
    }

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public jsonResult exceptionHandler(HttpServletResponse req, NullPointerException e) {
        logger.error("出现空指针异常: ", e);
        return jsonResult.error(ExceptionEnum.ILLEGAL_NULL);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public jsonResult exceptionHandler(HttpServletResponse req, Exception e) {
        logger.error("未知异常: ", e);
        return jsonResult.error(ExceptionEnum.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = MaxUploadSizeExceededException.class)
    @ResponseBody
    public jsonResult handleMaxUploadSizeExceeded(MaxUploadSizeExceededException e) {
        logger.error("上传文件过大: ", e);
        return jsonResult.error(ExceptionEnum.EXPECTATION_FAILED);
    }
}
