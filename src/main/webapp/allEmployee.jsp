
<%@page import="com.github.atharvashelkeatwork.entity.Employee"%>
<%@page import="com.github.atharvashelkeatwork.dao.EmployeeDao"%>
<%@ page import="java.util.List" %>

<%! private EmployeeDao dao = new EmployeeDao(); %>

<%
    List<Employee> allEmployee = dao.findAllUsers();
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">
</head>
<body>

    <!-- Centered Card Container -->
    <div class="table-container">
        <h2>Employee Directory</h2>
        
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Department</th>
                    <th>Edit Employee</th>
                    <th>Delete Employee</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (allEmployee != null) {
                        for (Employee e : allEmployee) {
                %>
                <tr>
                    <td><%= e.getId() %></td>
                    <td><%= e.getName() %></td>
                    <td><%= e.getEmail() %></td>
                    <td><%= e.getDepartment() %></td>
                    <!-- Styled links into sleek action buttons -->
                    <td><a class="btn btn-edit" href="employee?action=edit&id=<%= e.getId() %>">Edit</a></td>
                    <td><a class="btn btn-delete" href="employee?action=delete&id=<%= e.getId() %>">Delete</a></td>
                </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>
        <div style="margin-top: 20px; padding: 15px; text-align: center;">
        <p style="margin: 5px 0; color: #555;">
            <strong>Last Updated Employee ID:</strong> 
            ${sessionScope.lastUpdatedId != null ? sessionScope.lastUpdatedId : 'None'}
        </p>
        <p style="margin: 5px 0; color: #555;">
            <strong>Last Updated Employee Name:</strong> 
            ${cookie.lastUpdatedName.value != null ? cookie.lastUpdatedName.value.replace("_", " ") : 'None'}
        </p>
    </div>
    </div>
    
</body>
</html>
