package ar.edu.unlp.info.infopool.aspects;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import ar.edu.unlp.info.infopool.services.MailService;


@Aspect
public class MaiLToAdminAspect {
	
	@After("execution(* ar.edu.unlp.info.infopool.actions.TravelerAction.newComplaint())")
	public void logBefore(JoinPoint joinPoint) {
		
    	WebApplicationContext context = WebApplicationContextUtils
				.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
       	MailService mm = (MailService) context.getBean("mailService");
           mm.sendMail("christianetracy@gmail.com",
       		   "christianetracy@hotmail.com",
       		   "Nueva denuncia", 
       		   "Tiene una denuncia nueva.");
    
 
		System.out.println("logBefore() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	
}