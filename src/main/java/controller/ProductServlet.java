package controller;

import model.Product;
import model.Review;
import service.implementService.BrandServiceImplement;
import service.implementService.CategoryServiceImplement;
import service.implementService.ReviewServiceImplement;
import service.interfaceService.IBrandService;
import service.interfaceService.ICategoryService;
import service.interfaceService.IProductService;
import service.implementService.ProductServiceImplement;
import service.interfaceService.IReviewService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/home")
public class ProductServlet extends HttpServlet {
    private final IProductService productService = new ProductServiceImplement();
    private final IReviewService reviewService = new ReviewServiceImplement();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request, response);
    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add-product":
            case "detail":
                findById(request,response);
                break;
            case "find":
                findByKeyword(request,response);
                break;
            case "laptop":
                laptopHome(request,response);
                break;
            case "smartphone":
                smartPhoneHome(request,response);
                break;
            case "tablet":
                tabletHome(request,response);
                break;
            default:
                allProductHome(request, response);
                break;
        }
    }


    private void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        List<Review> reviews = reviewService.findListReviewById(id);
        request.setAttribute("reviews",reviews);
        request.setAttribute("product", product);
        request.getRequestDispatcher("client/view/users.jsp").forward(request,response);
    }

    private void findByKeyword(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<Product> products = productService.findByKeyword(keyword);
        request.setAttribute("products", products);
        request.getRequestDispatcher("client/view/store.jsp").forward(request,response);
    }


    private void allProductHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productService.getAll();
        request.setAttribute("active1", "active");
        request.setAttribute("products", products);
        RequestDispatcher rd = request.getRequestDispatcher("client/view/index.jsp");
        rd.forward(request, response);
    }

    private void laptopHome(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        List<Product> products = productService.findByKeyword("Laptop");
        request.setAttribute("active2", "active");
        request.setAttribute("products", products);
        request.getRequestDispatcher("client/view/index.jsp").forward(request, response);
    }


    private void tabletHome(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        List<Product> products = productService.findByKeyword("Tablet");
        request.setAttribute("active3", "active");
        request.setAttribute("products", products);
        request.getRequestDispatcher("client/view/index.jsp").forward(request, response);
    }

    private void smartPhoneHome(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        List<Product> products = productService.findByKeyword("SmartPhone");
        request.setAttribute("active4", "active");
        request.setAttribute("products", products);
        request.getRequestDispatcher("client/view/index.jsp").forward(request, response);
    }
}
