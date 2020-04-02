<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>BattleShip - setup your ships</title>
</head>
<body>

<form action="/setup" method="post">
    <table>
        <c:forEach begin="1" end="10" var="row">
            <tr>
                <c:forEach items="A,B,C,D,E,F,G,H,I,J" var="col">
                    <td>
                        <c:set var="addr" value="${col}${row}"/>
                        <input type="checkbox" name="cells" value="${addr}" <c:if test="${sessionScope.player.ownField.getState(addr) == 'SHIP'}">checked</c:if>>
                    </td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
    <button type="submit">Start</button>
</form>

</body>
</html>
