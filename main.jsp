<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:scriptlet>
    //Los enlaces de la barra de men�, vuelven a llamar a index.jsp?menu="param"
    //pillo el par�metro y lo guardo como atributo de la request para utilizarlo
    //en las estructuras de control
    if (request.getParameter("menu") != null) {
        request.setAttribute("menu", request.getParameter("menu"));
    } 
</jsp:scriptlet>
<div class="panel panel-default">
    <div class="panel-heading">Caso de uso</div>
    <div class="panel-body" id="main">
        <!-- Si atrituto action no est� vacio es que he recargado la p�gina despu�s
        de realizar alguna operaci�n CRUD-->
        <c:if test="${not empty action}" >
            <jsp:include page="results.jsp" flush="true" />
        </c:if>
        <!-- Por el contrario si est� vacio he recargado la p�gina desde los items
        de men� o la he iniciado por primera vez-->
        <c:if test="${empty action}" >
            <c:if test="${not empty menu}" >
                <!-- Seg�n la opci�n de men� pulsada (revisar nav.html) -->
                <c:choose>
                    <c:when test="${menu.equals('Add')}">
                        <jsp:include page="html/addForm.html" flush="true" />
                    </c:when>
                    <c:when test="${menu.equals('Update')}">
                        <jsp:include page="html/updateForm.html" flush="true" />
                    </c:when>
                    <c:when test="${menu.equals('Delete')}">
                        <jsp:include page="html/deleteForm.html" flush="true" />
                    </c:when>
                    <c:otherwise>
                    </c:otherwise>
                </c:choose>
            </c:if> 
            <c:if test="${empty menu}" >
                <jsp:include page="html/addForm.html" flush="true" />
            </c:if>
        </c:if>
        <!-- Vacio los atritutos para que asegurarme de que funcionan correctamente
        las distintas recargas de la p�gina-->
        <c:set var = "action" scope = "request" value = ""></c:set>
        <c:set var = "menu" scope = "request" value = ""></c:set>
        </div>
    </div>
    <!-- Lista que se recarga continuamente con todos los coches del taller 
    la primera vez que entramos no hay objetos cargado por lo que la secci�n no
    aparece-->   
<c:if test="${not empty list}">
    <jsp:include page="list.jsp" flush="true" />
</c:if>
