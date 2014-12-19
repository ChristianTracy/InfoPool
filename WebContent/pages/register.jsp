<%@ taglib uri="/struts-tags" prefix="s" %>  
  
<s:form action="register">  
<s:textfield name="name" label="Name"></s:textfield>
<s:textfield name="username" label="UserName"></s:textfield>    
<s:password name="password" label="Password"></s:password>  
<s:textfield name="surname" label="Surname"></s:textfield>
<s:textfield name="email" label="Email"></s:textfield>  
<s:textfield name="telephone" label="Telephone"></s:textfield>

<s:submit value="register"></s:submit>  
  
</s:form>  

