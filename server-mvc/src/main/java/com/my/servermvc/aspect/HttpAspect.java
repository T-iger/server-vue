package com.my.servermvc.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 切面
 * @Author: lh
 * @Date 2020/9/5
 * @Version: 1.0
 **/
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = Logger.getLogger(HttpAspect.class);

    /**
     * 切点，进入controller
     */
    @Pointcut("execution(* com.my.servermvc.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url : "+ request.getRequestURI());
        //method
        logger.info("method : "+ request.getMethod());
        //ip
        logger.info("ip : "+request.getRemoteAddr());
        //类方法
        logger.info("class_method : "+joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        logger.info("args : "+ joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter(){
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn( Object result){
        logger.info("Result : "+result.toString());
    }
}
