package controller.user;

import dao.AccountDao;
import model.acc_model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
    AccountDao dao = new AccountDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String username = req.getParameter("username");
       String password = req.getParameter("password");
       String confirm = req.getParameter("confirm");
       acc_model account = new acc_model(username,password,"user");
       System.out.println(account.toString());
       String msg = null;
       if(confirm.trim().equals(password.trim()) ){
           account = new acc_model(username,password,"user");
           System.out.println(account.toString());
           Boolean result = dao.insert(account);
           if(result){
               msg = "Đăng ký tài khoản thành công";

           }
           else{
               msg = "Vui lòng thử lại";
           }

       }
       else{
           msg = "Mật khẩu trong trùng khớp";
       }
        req.setAttribute("msg",msg);
        req.getRequestDispatcher("/views/login.jsp").forward(req,resp);
    }
}
