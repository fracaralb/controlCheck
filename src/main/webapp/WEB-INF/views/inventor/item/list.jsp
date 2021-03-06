<%@ page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" uri="urn:jsptagdir:/WEB-INF/tags"%>

<acme:list>

		<acme:list-column code="inventor.item.list.label.name" path="name" width="10%"/>
		<acme:list-column code="inventor.item.list.label.retailprice" path="retailPrice" width="20%"/>
		<acme:list-column code="inventor.item.list.label.publish" path="published" width="10%"/>

</acme:list>
<jstl:choose>
	<jstl:when test="${command == 'list-component' }">
		<acme:button code="inventor.item.create-component" action="/inventor/item/create-component" />
	</jstl:when>
	<jstl:when test="${command == 'list-tool' }">
		<acme:button code="inventor.item.create" action="/inventor/item/create-tool" />
	</jstl:when>		
</jstl:choose>
