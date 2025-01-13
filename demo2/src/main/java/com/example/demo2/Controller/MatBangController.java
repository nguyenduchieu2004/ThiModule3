package com.example.demo2.Controller;

import com.example.demo2.Model.MatBang;
import com.example.demo2.Service.IMatbangService;
import com.example.demo2.Service.MatbangService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MatBangController", urlPatterns = "/Matbang")
public class MatBangController extends HttpServlet {
    private IMatbangService matbangService = new MatbangService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "delete":
                // Lấy id từ request
                int id = Integer.parseInt(req.getParameter("id"));
                matbangService.delete(id);
                resp.sendRedirect("/Matbang?message=delete");
                break;
            default:
                String message=req.getParameter("message");
                if(message != null) {
                    if (message.equals("delete")) {
                        req.setAttribute("message", "Xoá Thành Công!");
                    }
                }
                List<MatBang> matBangList = matbangService.getAll();
                req.setAttribute("mat_bang", matBangList);
                req.getRequestDispatcher("/WEB-INF/View/Matbang/List.jsp").forward(req, resp);
                break;
        }
    }
}