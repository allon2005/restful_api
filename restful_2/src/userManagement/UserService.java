package userManagement;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService {
	
   UserDao userDao = new UserDao();
   private static final String SUCCESS_RESULT="<result>success</result>";
   private static final String FAILURE_RESULT="<result>failure</result>";


   @GET
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   public List<User> getUsers(){
      return userDao.getAllUsers();
   }

   @GET
   @Path("/users/{userid}")
   @Produces(MediaType.APPLICATION_XML) // after getting the infor from server, ask the server to produce a XML file
   public User getUser(@PathParam("userid") int userid){ //@PathParam will bind the {userid} to the method
      return userDao.getUser(userid);
   }

   @PUT
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)  //produce this specific MediaType
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED) //respond to this specific MediaType
   /*The information sent to a resource and then passed back to the client is specified as a MIME media type in the headers of an HTTP request or response. 
    * You can specify which MIME media types of representations a resource can respond to or produce by using the javax.ws.rs.Consumes and javax.ws.rs.Produces annotations.

By default, a resource class can respond to and produce all MIME media types of representations specified in the HTTP request and response headers.
    * 
    */
   public String createUser(@FormParam("id") int id,
      @FormParam("name") String name, //since the request media type is "Application_form_URLENCODED", so, use "@FormParam"
      @FormParam("profession") String profession,
      @Context HttpServletResponse servletResponse) throws IOException{ //for PUT/POST, we need to pass "@Context....servletResponse" to the method
      User user = new User(id, name, profession);
      int result = userDao.addUser(user);
      if(result == 1){
         return SUCCESS_RESULT;
      }
      return FAILURE_RESULT;
   }

   @POST
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public String updateUser(@FormParam("id") int id,
      @FormParam("name") String name,
      @FormParam("profession") String profession,
      @Context HttpServletResponse servletResponse) throws IOException{
      User user = new User(id, name, profession);
      int result = userDao.updateUser(user);
      if(result == 1){
         return SUCCESS_RESULT;
      }
      return FAILURE_RESULT;
   }

   @DELETE
   @Path("/users/{userid}")
   @Produces(MediaType.APPLICATION_XML) //for DELETE, we still need to produce a specific mediaType????b
   public String deleteUser(@PathParam("userid") int userid){
      int result = userDao.deleteUser(userid);
      if(result == 1){
         return SUCCESS_RESULT;
      }
      return FAILURE_RESULT;
   }

   @OPTIONS
   @Path("/users")
   @Produces(MediaType.APPLICATION_XML)
   public String getSupportedOperations(){
      return "<operations>GET, PUT, POST, DELETE</operations>";
   }
}
