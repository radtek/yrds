package com.yrds.iris.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kivi.framework.constant.GlobalErrorConst;
import com.kivi.framework.dto.BaseResDTO;
import com.kivi.framework.exception.AppException;
import com.kivi.framework.exception.DaoException;
import com.kivi.framework.exception.ToolBoxException;

@ControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
     * 处理所有不可知的异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    BaseResDTO handleException(Exception e){
    	log.error(e.getMessage(), e);

        BaseResDTO response = new BaseResDTO();
        response.setRespCode( GlobalErrorConst.E_UNDEFINED);
        return response;
    }

    /**
     * 处理所有业务异常的异常
     * @param e
     * @return
     */
    @ExceptionHandler(AppException.class)
    @ResponseBody
    BaseResDTO handleException(AppException e){
    	log.error(e.getMessage(), e);

        BaseResDTO response = new BaseResDTO();
        response.setException( e );
        return response;
    }
    
    /**
     * 处理所有数据库异常的异常
     * @param e
     * @return
     */
    @ExceptionHandler(DaoException.class)
    @ResponseBody
    BaseResDTO handleException(DaoException e){
    	log.error(e.getMessage(), e);

        BaseResDTO response = new BaseResDTO();
        response.setRespCode( GlobalErrorConst.E_DB_ERROR );
        return response;
    }
    
    /**
     * 处理所有工具类异常的异常
     * @param e
     * @return
     */
    @ExceptionHandler(ToolBoxException.class)
    @ResponseBody
    BaseResDTO handleException(ToolBoxException e){
    	log.error(e.getMessage(), e);

        BaseResDTO response = new BaseResDTO();
        response.setRespCode( GlobalErrorConst.E_UNDEFINED );
        return response;
    }
    
}
