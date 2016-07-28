package userManagement;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
/*
 * The @Path annotation¡¯s value is a relative URI path indicating where the Java class will be hosted: 
 * for example, /helloworld. You can also embed variables in the URIs to make a URI path template. 
 * For example, you could ask for the name of a user and pass it to the application as a variable in the URI: 
 * /helloworld/{username}.
 */
public class UserService {

   UserDao userDao = new UserDao();

   @GET
   /*The @GET annotation is a request method designator and corresponds to the similarly named HTTP method. 
    * The Java method annotated with this request method designator will process HTTP GET requests. 
    * The behavior of a resource is determined by the HTTP method to which the resource is responding.
    */
   @Path("/users") // together with the @Path at the class level, "UserService/users" will invoke this method!!!
   @Produces(MediaType.APPLICATION_XML)
   /* The @Produces annotation is used to specify the MIME media types of representations a resource can produce 
and send back to the client: for example, "text/plain".
    * 
    */
   public List<User> getUsers(){
      return userDao.getAllUsers();
   }	
}
