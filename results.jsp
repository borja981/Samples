<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${success eq 'false'}" >
    <p>Error</p>
    <c:choose>
        <c:when test="${action.equals('Add')}" >             
            <p>Error al dar de alta el coche con matrícula ${car.license} al taller</p>
        </c:when>
        <c:when test="${action.equals('Find')}" >            
            <p>El coche matrícula ${lookFor} no se encuentra en el taller</p>
        </c:when>
        <c:when test="${action.equals('Update')}" >             
            <p>Error al actualizar los datos del coche con matrícula ${car.license}</p>
        </c:when>
        <c:when test="${action.equals('Delete')}" >          
            <p>Error al dar de baja el coche con matrícula ${car.license} en el taller</p>
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>
</c:if>  

<c:if test="${success eq 'true' }" >
    <h2>El coche: </h2>  
    <h3>Matrícula: ${car.license}</h3>
    <ul> 
        <li>Marca: ${car.brand}</li>
        <li>Modelo: ${car.model}</li>
        <li>Color: ${car.color}</li>
    </ul>
    <c:choose>
        <c:when test="${action.equals('Add')}" >           
            <p>Ha sido añadido correctamente al taller</p>
        </c:when>
        <c:when test="${action.equals('Find')}" >           
            <p>Se encuentra en el taller</p>
        </c:when>
        <c:when test="${action.equals('Update')}" >           
            <p>Ha sido actualizado correctamente</p>
        </c:when>
        <c:when test="${action.equals('Delete')}" >           
            <p>Ha sido borrado correctamente</p>
        </c:when>
        <c:otherwise>
        </c:otherwise>
    </c:choose>
    <c:if test="${action.equals('Update')}" >        
        <p>Datos anteriores</p>
        <ul>
            <li>Marca: ${old.brand}</li>
            <li>Modelo: ${old.model}</li>
            <li>Color: ${old.color}</li>
        </ul>
    </c:if>
</c:if>
<c:set var = "success" scope = "request" value = ""></c:set>