package service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import models.Employee;

@ApplicationPath("/rest")
public class Myclient extends Application {
	public static void main(String[] args) {
		ResteasyClient client = new ResteasyClientBuilder().build();
		ResteasyWebTarget add = client.target("http://localhost:8080/RestFul_Client/employee/add/");
		Employee emp = new Employee();
		emp.setId(123);
		emp.setName("santosh");
		emp.setSalary(1000);
		Response addResponse = add.request().post(Entity.entity(emp, MediaType.APPLICATION_XML));
		System.out.println("Response: " + addResponse.getStatus() + " " + addResponse.getLocation());
	}
}
