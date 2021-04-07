package servlet;

import core.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BasicServlet", urlPatterns = "/products")
public class BasicServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(BasicServlet.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("New GET request");
        String param = req.getParameter("count");
        if (param != null) {
            for (int i = 0; i < Integer.parseInt(param); i++) {
                resp.getWriter().printf(getProducts(i).toString());
            }
        } else {
            for (int i = 0; i < 10; i++) {
                resp.getWriter().printf(getProducts(i).toString());
            }
        }
    }

    private StringBuilder getProducts(int param){
        StringBuilder str = new StringBuilder();
        str.append("Product\n");
        str.append(new Product(String.valueOf(param+1),
                "product number " + (param + 1),
                String.valueOf((int) (Math.random() * 1000))).toString());
        str.append(System.lineSeparator());
        return str;
    }
}



