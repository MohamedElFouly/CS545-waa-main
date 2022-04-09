package miu.edu.demo.aspect;

import miu.edu.demo.domain.Logger;
import miu.edu.demo.domain.User;
import miu.edu.demo.service.LoggerService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Aspect
public class LoggerAspect {

    @Autowired
    LoggerService loggerService;

    @Pointcut("@annotation(miu.edu.demo.aspect.annotation.ExecutionTime)")
    public void ExecutionTime(){

    }
    @Around("ExecutionTime()")
    public Object LogOperation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        Logger logger = new Logger();
        logger.setDate(new Date());
        logger.setTime(executionTime);
        logger.setPrinciple(User.getLoggedInUser());
        logger.setOperation(proceedingJoinPoint.getSignature().getName());
        loggerService.save(logger);
        return proceed;
    }
}
