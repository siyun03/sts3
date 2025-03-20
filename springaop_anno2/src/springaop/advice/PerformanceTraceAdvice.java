package springaop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceTraceAdvice {
	
	@Pointcut("execution(public * springaop.service..*(..))")
	public void pointcut() {
		
	}
	
	@Around("pointcut()")
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {

		// 메소드 시작 시간
		long startTime = System.currentTimeMillis();
		
		// 타겟 메소드명
		String methodName = joinPoint.getSignature().toShortString();
		
		System.out.println(methodName + "메소드 수행시작~");
	
		try {
			// 타겟 메소드
			return joinPoint.proceed();

		} finally {
			
			// 메소드 종료시간
			long endTime = System.currentTimeMillis();
		
			System.out.println(methodName + "메소드 수행 종료 #!@");
			
			// 메소드 수행 시간
			long runTime = endTime - startTime;
			System.out.println(methodName + "수행시간은" + runTime + "밀리초 입니두");
			
		}
		
	}

}
