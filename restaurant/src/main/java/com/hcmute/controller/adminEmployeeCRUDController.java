package com.hcmute.controller;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcmute.dao.EmployeeDao;
import com.hcmute.model.EmployeeModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/admin-employee.html")
public class adminEmployeeCRUDController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 184984112754305267L;
	private EmployeeDao employeeDao;

    public void init() {
        employeeDao = new EmployeeDao();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
//                case "/insert":
//                    insertUser(request, response);
//                    break;
//                case "/delete":
//                    deleteUser(request, response);
//                    break;
//                case "/edit":
//                    showEditForm(request, response);
//                    break;
//                case "/update":
//                    updateUser(request, response);
//                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<EmployeeModel> listEmployee = employeeDao.selectAllEmployee();
        request.setAttribute("listUser", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee-form.jsp");
        dispatcher.forward(request, response);
    }

}
