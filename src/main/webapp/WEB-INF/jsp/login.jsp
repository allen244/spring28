<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
<form method="POST">

    <font color="red">${errorMessage}</font>
    Name : <input name="name" type="text"/>

    Password : <input type="password" name="password"/>
    <input type="submit"/>
</form>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
        src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
<script>
    $('#targetDate').datepicker({
        format: 'dd/mm/yyyy'
    });
</script>

</body>
</html>