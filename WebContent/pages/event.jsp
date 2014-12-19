<%@ taglib uri="/struts-tags" prefix="s"%>

<s:form action="event">
	<s:date name="date" format="yyyy/MM/dd"></s:date>
	<s:textfield name="description" label="Description"></s:textfield>
	<s:textfield name="location" label="Location"></s:textfield>
	<s:textfield name="name" label="Name"></s:textfield>
	<s:submit value="register"></s:submit>
</s:form>


