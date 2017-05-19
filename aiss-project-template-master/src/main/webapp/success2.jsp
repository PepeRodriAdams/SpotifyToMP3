<%@include file="includes/header.jsp"%>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Search results</title>
</head>
<body>


<fieldset id="spotify">
<legend>Búsqueda de álbumes para: <c:out value="${param.searchQuery}"/></legend>

<c:forEach items="${requestScope.albums}" var="album">
	<c:out value="${album.name}"/><br/>
</c:forEach>
</fieldset>

<%@include file="includes/footer.jsp"%>
