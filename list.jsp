<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="panel panel-default">
    <div class="panel-heading">
        <h3 class="panel-title">Listado</h3>
    </div>
    <div class="panel-body">
        <c:forEach var="car" items="${list}">
            <button class="btn btn-primary" type="button">
                <c:out value="${car.license}" />
                <span class="badge badge-primary">
                    <p><c:out value="${car.brand}" /> </p>
                    <p><c:out value="${car.model}" /> </p>
                    <p> <c:out value="${car.color}" /> </p>
                </span>
            </button>
        </c:forEach>
    </div>
</div>
<c:set var = "list" scope = "request" value = ""></c:set>

