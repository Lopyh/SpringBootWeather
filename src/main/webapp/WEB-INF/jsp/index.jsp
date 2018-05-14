<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%--@elvariable id="cityFromServer" type="weather"--%>
<spring:form modelAttribute="cityFromServer" method="post" action="/addToBase">
    <spring:input path="name"/>
    <br><br/>
    <spring:button>Add City</spring:button>
</spring:form>
</body>
</html>