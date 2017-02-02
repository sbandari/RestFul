package services;

import static javax.ws.rs.core.Response.status;

import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/users")
public class Myservice {
   /* @GET
    @Path("/{param}")
    //http://localhost:8080/rest/users/helloworld
    public Response getMsg(@PathParam("param") String msg) {
        String output = "Restful  Say:" + msg;

        return status(200).entity(output).build();
    }*/

    //http://localhost:8080/rest/users
  @GET
    public Response getUser() {
        return status(200).entity("Get User is called with Param: ").build();
    }
    @POST
    @Path("/add")
    public Response addUser(
            @FormParam("name") String name,
            @FormParam("age") int age) {

        return Response.status(200)
                .entity("addUser is called, name : " + name + ", age : " + age)
                .build();

    }


  /*  //http://localhost:8080/rest/users/vip/santosh
    @GET
    @Path("/vip/{param}")
    public Response getUserVIP(@PathParam("param") String param) {

        return status(200).entity("GET VIP is called" + param).build();

    }

    //http://localhost:8080/rest/users/123

    @Path("{id:\\d+}")//support digit only
    public Response getID(@PathParam("id") int id) {
        return Response.status(200).entity("getUserById is called, id : " + id).build();
    }

    //http://localhost:8080/rest/users/username/santosh

    @GET
    @Path("/username/{username : [a-zA-Z][a-zA-Z_0-9]*}")
    public Response getUserByUserName(@PathParam("username") String username) {

        return Response.status(200)
                .entity("getUserByUserName is called, username : " + username).build();

    }

    //http://localhost:8080/rest/users/books/123
    @GET
    @Path("/books/{isbn : \\d+}")
    public Response getUserBookByISBN(@PathParam("isbn") String isbn) {

        return Response.status(200)
                .entity("getUserBookByISBN is called, isbn : " + isbn).build();

    }

    //http://localhost:8080/rest/users/2016/12/11
    @GET
    @Path("{year}/{month}/{day}")
    public Response getUserHistory(
            @PathParam("year") int year,
            @PathParam("month") int month,
            @PathParam("day") int day) {

        String date = year + "/" + month + "/" + day;

        return Response.status(200)
                .entity("getUserHistory is called, year/month/day : " + date)
                .build();

    }
    //using QueryParameter annotation
    //http://localhost:8080/rest/users/query?from=100&to=200&orderBy=age&orderBy=name%E2%80%9D
    @GET
    @Path("/query")
    public Response getUsers(
            @QueryParam("from") int from,
            @QueryParam("to") int to,
            @QueryParam("orderBy") List<String> orderBy) {

        return Response
                .status(200)
                .entity("getUsers is called, from : " + from + ", to : " + to
                        + ", orderBy" + orderBy.toString()).build();

    }
   // http://localhost:8080/rest/users/query?id=123&from=100&to=200&orderBy=age&orderBy=name%E2%80%9D
    @GET
    @Path("/query")
    public Response getUsers(@Context UriInfo info) {
String id=info.getQueryParameters().getFirst("id");
        String from = info.getQueryParameters().getFirst("from");
        String to = info.getQueryParameters().getFirst("to");
        List<String> orderBy = info.getQueryParameters().get("orderBy");

        return Response
                .status(200)
                .entity("getUsers is called,id: "+id+" from : " + from + ", to : " + to
                        + ", orderBy" + orderBy.toString()).build();

    }
    //for Matrix Parameters using pathSegement
    @GET
    @Path("/{year}")
    public Response getBooks(@PathParam("year") PathSegment yea) {
        String author=yea.getMatrixParameters().getFirst("author");
        String country=yea.getMatrixParameters().getFirst("country");
        String year=yea.getPath();
        return Response
                .status(200)
                .entity("getBooks is called, year : " + year
                        + ", author : " + author + ", country : " + country)
                .build();

    }*/

}