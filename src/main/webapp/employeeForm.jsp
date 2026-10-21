<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${empty e ? 'Add Employee' : 'Update Employee'}</title>
    <!-- Links to the centralized project stylesheet -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/style.css">
</head>
<body>

    <!-- Reusing the centered card container architecture from directory layout -->
    <div class="table-container" style="max-width: 500px;">
        <h2>${empty e ? 'Add New Employee' : 'Edit Employee Details'}</h2>

        <form action="employee" method="post">
            <!-- Hidden field matching update/insert control flags -->
            <input type="hidden" name="id" value="${e.id}">

            <div class="form-group">
                <label>Full Name</label>
                <input type="text" name="name" value="${e.name}" required placeholder="Enter full name">
            </div>

            <div class="form-group">
                <label>Email Address</label>
                <input type="email" name="email" value="${e.email}" required placeholder="name@company.com">
            </div>

            <div class="form-group">
                <label>Department</label>
                <input type="text" name="dept" value="${e.department}" placeholder="e.g. Test Engineer">
            </div>
            
            <!-- Styled operation buttons aligning with directory aesthetic rules -->
            <div class="form-actions">
                <button type="submit" class="btn btn-edit">${empty e ? 'Submit' : 'Update'}</button>
                <a href="employee" class="btn" style="background-color: #757575; color: white;">Cancel</a>
            </div>
        </form>
    </div>

</body>
</html>
