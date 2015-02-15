import java.io.IOException;

import com.sun.net.httpserver.HttpServer;



//指定URI 
@Path("/helloworld") 
public class HelloWorld { 
        //处理HTTP的GET请求 
        @GET 
        // 处理请求反馈的内容格式为"text/plain" 
        @Produces("text/plain") 
        public String getClichedMessage() { 
                return "Hello World!"; 
        } 

        public static void main(String[] args) throws IOException { 
                //创建RESTful WebService服务 
                HttpServer server = HttpServerFactory.create("http://192.168.14.117:9999/"); 
                //启动服务，这会导致新开一个线程 
                server.start(); 
                //输出服务的一些提示信息到控制台 
                System.out.println("RESTful WebService服务已经启动"); 
                System.out.println("服务访问地址: http://192.168.14.117:9999/helloworld"); 
        } 
}