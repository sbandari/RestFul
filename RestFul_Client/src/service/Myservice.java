package service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import models.Employee;

@Path("/employee")

public class Myservice {
	private final static Map<Integer, Employee> emp = new HashMap<Integer, Employee>();

	@POST
	@Path("/add")
	@Consumes("application/xml")
	public Response createEmployee(Employee e) {
		if (emp.get(e.getId()) == null) {
			Response.status(400).entity("<h1>Bad Request</h1>").build();
		}
		e.setId(12);
		e.setName("sant");
		e.setSalary(100000);
		emp.put(e.getId(), e);
		return Response.status(200).entity("employee Sucessfull Buld with id :" + e.getId()).build();

	}

	@DELETE
	@Path("{id}/delete")
	public Response deleteEmployee(@PathParam("id") int id) {
		Employee e = new Employee();
		if (emp.get(e.getId()) == null) {
			Response.status(400).entity("<h1>Bad Request</h1>").build();
		}
		emp.remove(id);
		return Response.status(200).entity("employee Sucessfull DELETED with id :" + id).build();
	}

	@GET
	@Path("/{id}/get")
	public Response getEmployee(@PathParam("id") int id) {
		Employee e = new Employee();
		e.setId(id);
		return Response.status(200).entity("employee with id :" + e.getId() + " Name :" + emp.get(e.getId())).build();
	}

	@GET
	@Path("/getAll")
	@Produces("application/json")
	public Employee[] getAllEmployees() {
		Set<Integer> ids = emp.keySet();
		Employee[] e = new Employee[ids.size()];
		int i = 0;
		for (Integer id : ids) {
			e[i] = emp.get(id);
			i++;
		}
		return e;
	}
}
/*
 * for test
 * 
 * @GET
 * 
 * @Path("/test") public Response getEmployee() { return
 * Response.status(200).entity("This Just for Testing").build(); }
 */
