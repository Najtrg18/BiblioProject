<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<fmt:setLocale value="en_US" />
<fmt:setBundle basename="messages" />

<nav>
	<ul>
		<li><a href="accueil" title="retour Accueil"><fmt:message
					key="menu.accueil"></fmt:message> </a></li>
		<li><a href="contact" title="nous contacter">Contact</a></li>
		<li><a href="admin" title="accueil administrateur"><fmt:message
					key="menu.administrateur"></fmt:message></a></li>
		
	</ul>
</nav>