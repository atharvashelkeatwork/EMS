package com.github.atharvashelkeatwork.servlet;

import java.io.IOException;

import com.github.atharvashelkeatwork.dao.EmployeeDao;
import com.github.atharvashelkeatwork.entity.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/employee", initParams = @WebInitParam(name = "dept", value = "Tester"))
public class EmployeeServlet extends HttpServlet {
	
	private EmployeeDao dao = new EmployeeDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String action = req.getParameter("action");
	    
	    if (action != null && "create".equals(action)) {
	        req.getRequestDispatcher("employeeForm.jsp").forward(req, resp);
	        return;
	    } else if (action != null && "delete".equals(action)) {
	        String idStr = req.getParameter("id");
	        if (idStr != null && !idStr.isEmpty()) {
	            int id = Integer.parseInt(idStr);
	            dao.deleteUser(id);
	        }
	        resp.sendRedirect("allEmployee.jsp");
	        return;
	    } else if (action != null && "edit".equals(action)) {
	        String idStr = req.getParameter("id");
	        if (idStr != null && !idStr.isEmpty()) {
	            int id = Integer.parseInt(idStr);
	            Employee e = dao.findUser(id);
	            req.setAttribute("e", e);
	            req.getRequestDispatcher("employeeForm.jsp").forward(req, resp);
	            return;
	        }
	        resp.sendRedirect("allEmployee.jsp");
	        return;
	    } else {
	        resp.sendRedirect("allEmployee.jsp");
	        return;
	    }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");	
		String department = req.getParameter("dept");
		if(department == null || department.trim().isEmpty()) {
			department = getServletConfig().getInitParameter("dept");
		}
		Employee employee = new Employee(name, email, department);
		if (idStr != null && !idStr.trim().isEmpty()) {
			int id = Integer.parseInt(idStr);
			employee.setId(id);
			dao.updateEmployee(employee);
			req.getSession().setAttribute("lastUpdatedId", id);
			String safeName = name.replace(" ", "_");
		    Cookie cookie = new Cookie("lastUpdatedName", safeName);
		    cookie.setMaxAge(60 * 60 * 24);
		    resp.addCookie(cookie);
		} else {
			dao.saveEmployee(employee);
		}
		resp.sendRedirect("employee");
	}
}
