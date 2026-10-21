<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Portal Home</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">
</head>
<body>

    <div class="table-container" style="max-width: 450px; text-align: center;">
        <h2 style="margin-bottom: 30px;">Employee Management System</h2>
        
        <p style="color: #666; margin-bottom: 25px;">Welcome to the management control panel. Select an administrative operation below:</p>
        
        <div style="display: flex; flex-direction: column; gap: 15px;">
            <a href="employee" class="btn btn-edit" style="padding: 12px; font-size: 15px;">
                 View All Employee
            </a>
            <a href="employee?action=create" class="btn" style="background-color: #4CAF50; color: white; padding: 12px; font-size: 15px;">
                 Add New Employee
            </a>
        </div>
    </div>

</body>
</html>
