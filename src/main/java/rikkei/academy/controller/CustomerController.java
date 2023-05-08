    package rikkei.academy.controller;

    import rikkei.academy.model.Customer;
    import rikkei.academy.service.CustomerService;
    import rikkei.academy.service.ICustomerService;

    import java.io.*;
    import java.util.List;
    import javax.servlet.RequestDispatcher;
    import javax.servlet.ServletException;
    import javax.servlet.http.*;
    import javax.servlet.annotation.*;

    @WebServlet(value = "/customer")
    public class CustomerController extends HttpServlet {
        private ICustomerService customerService = new CustomerService();


        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            System.out.println("--> Call doGet");
            String action = request.getParameter("action");
            System.out.println("action -->" + action);
            if(action==null){
                action = "";
            }
            switch (action){
                case "create":
                    showFromCreate(request,response);
                    break;
                case "detail":
                    showCustomerDetailById(request,response);
                    break;
                case "edit":
                    showFormEdit(request,response);
                    break;
                case "delete":
                    deleteCustomer(request,response);
                    break;
                default:
                    showListCustomer(request,response);
            }
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println("--> Call doPost");
            String action = request.getParameter("action");
            System.out.println("action -->" + action);
            if(action==null){
                action = "";
            }
            switch (action){
                case "create":
                    actionCreate(request,response);
                    break;
                case "edit":
                    editCustomer(request,response);
                    break;
            }

        }
        public void showListCustomer(HttpServletRequest request, HttpServletResponse response){
            List<Customer> customerList = customerService.findAll();
            request.setAttribute("customerList", customerList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/list.jsp");

            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public void showFromCreate(HttpServletRequest request, HttpServletResponse response) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/create.jsp");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public void actionCreate(HttpServletRequest request, HttpServletResponse response) {
            int id = customerService.findAll().get(customerService.findAll().size()-1).getId()+1;
            String name = request.getParameter("name");
            System.out.println("name -->" +name);
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            Customer newCustomer = new Customer(id,name,email,address);
            customerService.save(newCustomer);
            request.setAttribute("validate","create success");
            showListCustomer(request,response);
        }
        public void showCustomerDetailById(HttpServletRequest request, HttpServletResponse response) {
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("id -->" + id);
            Customer customer = customerService.findById(id);
            request.setAttribute("customerDetail",customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/detail.jsp");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        public void showFormEdit (HttpServletRequest request, HttpServletResponse response){
            int id = Integer.parseInt(request.getParameter("id"));
            System.out.println("id -->" + id);
            Customer customer = customerService.findById(id);
            request.setAttribute("editCustomer",customer);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/customer/edit.jsp");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public void editCustomer (HttpServletRequest request, HttpServletResponse response){
            int id = Integer.parseInt(request.getParameter("id"));
//            Customer customer = customerService.findById(id);
            String editName = request.getParameter("editName");
            String editEmail = request.getParameter("editEmail");
            String editAddress = request.getParameter("editAddress");
            Customer editCustomer = new Customer(id, editName,editEmail,editAddress);
            customerService.save(editCustomer);
            showListCustomer(request,response);
        }

            public void deleteCustomer (HttpServletRequest request, HttpServletResponse response){
            int id = Integer.parseInt(request.getParameter("id"));
            customerService.deleteById(id);
            showListCustomer(request,response);
        }
    }