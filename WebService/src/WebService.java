

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class WebService
 */
@WebServlet("/WebService")
public class WebService extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numStr = request.toString(); 
		
		System.out.println(numStr);
		Double num = Double.parseDouble(numStr);
		
		if (num < 0) {
			response.getOutputStream().write(
					"-1".getBytes("utf-8"));   // Response -1, which means error
		}
		
        System.out.println(fibonacci(6) + ":" + fibonacciNormal(6));  
        
        String sum = "";  
        for(int i = 1; i <= num; i++){  
            sum += fibonacci(i);  
            sum += " ";  
            
        }  
        System.out.println(sum);
		response.getOutputStream().write(sum.getBytes("utf-8"));

	}
	
	   // Implement Fibonacci through recursion  
	 public static int fibonacci(int n){  
	     if (1 == n ) {  
	         return 0;  
	     } else if(2 == n){  
	     	return 1;
	     }else{
	         return fibonacci(n - 1) + fibonacci(n - 2);  
	     }  
	 }  
	   
	 // Implement Fibonacci through iteration 
	 public static int fibonacciNormal(int n){  
	     if (1 == n ) {  
	         return 0;  
	     } else if(2 == n){  
	     	return 1;
	     }
	     int n1 = 0, n2 = 1, sn = 0;  
	     for(int i = 0; i < n - 2; i ++){  
	         sn = n1 + n2;  
	         n1 = n2;  
	         n2 = sn;  
	     }  
	     return sn;  
	 }

}
