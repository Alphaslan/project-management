package com.jrp.pma.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ApplicationLoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.jrp.pma.controllers..*) ||" +
            "within(com.jrp.pma.dao..*)")
    public void definePackagePointcuts() {

    }

//    @After("definePackagePointcuts()")
//    public void setLogger(JoinPoint jp) {
//        logger.debug("\n*** After Method Execution ***\n {} \n {} with arguments[s] => {} \n_________________________",
//                jp.getSignature().getDeclaringTypeName(),
//                jp.getSignature().getName(),
//                Arrays.toString(jp.getArgs()));
//    }

    @Around("definePackagePointcuts()")
    public Object aroundLogger(ProceedingJoinPoint pjp) throws Throwable {
        logger.debug("\n_________________________\n*** Before Method Execution ***\n {} \n {} with arguments[s] => {} ",
                pjp.getSignature().getDeclaringTypeName(),
                pjp.getSignature().getName(),
                Arrays.toString(pjp.getArgs()));

        Object o = pjp.proceed();

        logger.debug("\n*** After Method Execution ***\n {} \n {} with arguments[s] => {} \n_________________________",
                pjp.getSignature().getDeclaringTypeName(),
                pjp.getSignature().getName(),
                Arrays.toString(pjp.getArgs()));
        return o;
    }


}
