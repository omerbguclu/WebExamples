<%@page import="com.omerbguclu.jsp.FunUtils"%>
<html>
<body>
Let's some have fun: <%= com.omerbguclu.jsp.FunUtils.makeItLower("FUN FUN FUN") %>
<br/>
Let's some have fun too :<%= FunUtils.makeItLower("HEY YO WHATSUP") %>
</body>
</html>