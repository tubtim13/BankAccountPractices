/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import JPA.Models.Account;
import JPA.Models.Controllers.AccountJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author Asus
 */
public class LoginServlet extends HttpServlet {
    @Resource
    UserTransaction utx;

    @PersistenceUnit(unitName = "BankAccountPracticesPU")
    EntityManagerFactory emf;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && username.trim().length() > 0
                && password != null && password.trim().length() > 0) {
            AccountJpaController accJpa = new AccountJpaController(utx, emf);
            Account account = accJpa.findAccount(Integer.valueOf(username));

            if (account != null) {
                
                if (account.getPin() == Integer.valueOf(password)) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("account", account);
                    getServletContext().getRequestDispatcher("/MyAccountServlet").forward(request, response);

                } else {
                    System.out.println("password is fault, plsss enter your coorect password !!");
                    getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
                }
            } else {
                System.out.println("username is not correct !!");
            getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
            }

        } else {
            System.out.println("username and password is null, plsss enter youe username and password !!");
            getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
