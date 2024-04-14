package leandro.PruebaJersey2;

import java.util.ArrayList;
import java.util.List;
 
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
 
@Path("users")
public class UsersService {
 
    private static List<User> usersList = new ArrayList<User>() {
        {
            add(new User(1, "Rosa", "Marfil"));
            add(new User(2, "Pepito", "Grillo"));
            add(new User(3, "Manuela", "Lago"));
        }
    };
 
    /**
     * URL: http://localhost:8080/{project-name}/api/users
     * @return Response list Users
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {
        return Response.ok(usersList).build();
    }
 
 
    /**
     * URL: http://localhost:8080/{project-name}/api/users/{id}
     * 
     * @param id Integer
     * @return Response
     */
    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") Integer id) {
        User found = null;
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getId() == id) {
                found = usersList.get(i);
            }
        }
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("User not found").build();
        } else {
            return Response.ok(found).build();
        }
    }
 
    /**
     * URL: http://localhost:8080/{project-name}/api/users
     * Parameters in
     * Postman: {"id": 5, "name":"Regi","username":"Regi132"}
     * 
     * @param User
     * @return Response list
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(User userRequest) {
 
        usersList.add(userRequest);
        //return Response.status(Status.CREATED).build();
        return Response.ok(usersList).build();
 
    }
 
    /**
     * URL: http://localhost:8080/{project-name/api/users/{id} 
     * Parameters in
     * Postman: {"name":"Regi"}
     * 
     * @param User
     * @return user modified
     */
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") Integer id, User userUpdate) {
        User found = null;
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getId() == id) {
                found = usersList.get(i);
            }
        }
 
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("User not found").build();
        } else {
            found.setName(userUpdate.getName());
            return Response.ok(found).build();
        }
    }
 
    /**
     * URL: http://localhost:8080/{project-name}/api/users/{id}
     * 
     * @param User
     * @return Response
     */
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") Integer id) {
        User found = null;
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getId() == id) {
                found = usersList.get(i);
                usersList.remove(found);
            }
        }
 
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("User not found").build();
        } else {
            return Response.ok(usersList).build();
        }
    }
 
}