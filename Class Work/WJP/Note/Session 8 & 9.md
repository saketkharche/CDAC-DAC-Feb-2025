**JSP & MVC - Detailed Notes (CDAC Advanced Java)**

---

**✅ 1. Introduction: Why JSP?**

- JSP (JavaServer Pages) allows developers to write HTML + dynamic Java code.
    
- Helps in separating the presentation layer (UI) from business logic (in servlets or DAO).
    
- More readable and maintainable than embedding HTML in servlets.
    

---

**✅ 2. MVC Architecture**

**MVC** stands for **Model-View-Controller**:

|Component|Responsibility|Technology Used|
|---|---|---|
|Model|Data management, business logic|POJO + DAO|
|View|UI, user-facing content|JSP|
|Controller|Handles client requests and routing|Servlet|

**Flow:**

1. Browser sends request to Servlet (Controller)
    
2. Servlet processes request, interacts with DAO (Model)
    
3. Servlet forwards response to JSP (View)
    

---

**✅ 3. MVC Design Pattern in Java Web Apps**

- Servlet receives input, validates it, and calls DAO.
    
- DAO talks to DB and returns data.
    
- Servlet puts data into `request` or `session` scope.
    
- JSP fetches and displays data using EL or JSTL.
    

---

**✅ 4. JSP Life Cycle**

|Phase|Description|
|---|---|
|Translation|JSP is converted to Servlet|
|Compilation|Servlet is compiled into a class|
|Loading|Class is loaded into container|
|Instantiation|Object is created|
|Initialization|`jspInit()` method is called|
|Request Handling|`_jspService()` method called for each request|
|Destruction|`jspDestroy()` method called when container stops|

---

**✅ 5. JSP Elements**

**a. Directives:**

```jsp
<%@ page import="java.util.*" %>
<%@ include file="header.jsp" %>
```

**b. Scriptlet:**

```jsp
<% int a = 10; out.print(a); %>
```

**c. Expression:**

```jsp
<%= "Hello " + name %>
```

**d. Declaration:**

```jsp
<%! int add(int x, int y) { return x + y; } %>
```

---

**✅ 6. Implicit Objects in JSP**

|Object|Type|Description|
|---|---|---|
|request|HttpServletRequest|Current request|
|response|HttpServletResponse|Used to create response|
|session|HttpSession|Session-level data|
|application|ServletContext|Application-wide storage|
|out|JspWriter|For printing to client|
|config|ServletConfig|Servlet config parameters|
|pageContext|PageContext|Provides access to all scopes|
|exception|Throwable|Used in error pages|

---

**✅ 7. Expression Language (EL)**

Simplifies JSP by avoiding Java code:

```jsp
${param.name}          // request.getParameter("name")
${sessionScope.user}   // session.getAttribute("user")
```

---

**✅ 8. Scope in JSP**

|Scope|Lifetime|Used For|
|---|---|---|
|page|Current page only|Temporary data|
|request|Single request|Data shared between servlets/JSP|
|session|Until browser closed or timeout|Login info, user session data|
|application|Entire application|Site-wide configuration|

---

**✅ 9. JSP Error Page Handling**

**Main JSP page:**

```jsp
<%@ page errorPage="error.jsp" %>
```

**Error Page:**

```jsp
<%@ page isErrorPage="true" %>
Error: <%= exception.getMessage() %>
```

---

**✅ 10. JSTL (JSP Standard Tag Library)**

JSTL helps replace Java code with easy-to-read tags.

**Import Taglib:**

```jsp
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```

**Common Tags:**

```jsp
<c:forEach var="item" items="${list}">
   ${item.name}
</c:forEach>

<c:if test="${user == null}">
   Please login
</c:if>
```

---

**✅ Lab Implementation Tasks**

**1. Library Management System**

- Use Servlet as Controller
    
- Fetch data using DAO
    
- Display via JSP using JSTL
    

**2. Air Ticket Reservation System**

- Step 1: Login Servlet (set session)
    
- Step 2: Flight Selection via JSP
    
- Step 3: Booking Confirmation JSP
    

**3. MVC Web Application**

- Model = POJO + DAO
    
- View = JSP with JSTL
    
- Controller = Servlet with RequestDispatcher
    

---

**✅ Summary Table**

|Component|Role|Technology Used|
|---|---|---|
|UI View|Display output|JSP + JSTL|
|Business Logic|DB queries, validations|DAO + POJO|
|Controller|Handle requests, forward|Servlet|
|Data Transfer|Attributes in scopes|request, session|
|Expression|Dynamic data in JSP|EL|

---

**End of Notes**