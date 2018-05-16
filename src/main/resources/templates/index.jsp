<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>


<spring:form modelAttribute="cityFromServer" method="post" action="/addToBase">
    </p>
    <spring:input path="name" onkeypress="afgf"/>
    <br><br/>
    <spring:button>Add City</spring:button>
</spring:form>
</body>
</html>