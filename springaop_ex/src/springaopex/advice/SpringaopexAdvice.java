package springaopex.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import springaopex.model.Springaopex;
import springaopex.service.SpringaopexService;

@Aspect
@Component
public class SpringaopexAdvice {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SpringaopexService springaopexService;
	
	@After("execution(public * springaopex.service.*Impl.insertSpringaopex(..))")
	public void before(JoinPoint joinPoint) throws Throwable {
		Springaopex obj = (Springaopex)joinPoint.getArgs()[0];
		String sql = " insert into log values(seq_log.nextval, seq_springaopex.currval, ?, ?,'INSERT', sysdate) ";
		jdbcTemplate.update(sql, obj.getSpass(), null);
	}
	
	@Around("exexcrion(public * springaopex.service.*Impl.updateSpringaopex(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		try {
			Object obj = joinPoint.getArgs()[0];
			String sql = " insert into log values(seq_log.nextval,?,?,?,'UPDATE', sysdate) "; 
			int sid = Integer.parseInt((String)obj);
			jdbcTemplate.update(sql, 
					((Springaopex)obj).getSid(),
					((Springaopex)obj).getSpass(),
					((Springaopex)obj).getSpass()
					);
			return joinPoint.proceed();
		}finally {
			
		}
	}
	
	@Before("execute(public * springaopex.service.*Impl.deleteSpringaopex(..))")
	public Object around2(JoinPoint joinPoint) throws Throwable {
		try {
			String sql = " insert into log values(seq_log.nextval,? ,? ,?,'DELETE', sysdate) ";
			Object obj = joinPoint.getArgs()[0];
			int sid = Integer.parseInt((String)obj);
			jdbcTemplate.update(sql, sid);
			return ((ProceedingJoinPoint) joinPoint).proceed();
		}finally {
			
		} 
		
	}
	
	
	
	
	
	
	
}
