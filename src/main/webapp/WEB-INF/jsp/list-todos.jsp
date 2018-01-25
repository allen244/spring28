<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
<div class="container">
    <table class="table table-striped">
        <caption>Your todos are</caption>
        <thead>
        <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is it Done?</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.desc}</td>
                <td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyyy"></fmt:formatDate></td>
                <td>${todo.done}</td>
                <td><a type="button" href="/${todo.id}/update-todo" class="btn-warning">Update</a></td>
                <td><a type="button" href="/${todo.id}/delete-todo" class="btn-warning">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div><a class="button" href="/add-todos">Add a Todo</a></div>


<%@ include file="common/footer.jsp" %>