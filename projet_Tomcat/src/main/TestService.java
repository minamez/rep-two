package main;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/MonService")
public class TestService {
	@Path("/helloWorld")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		System.out.println("HellowWorld !!");
		return "HelloWorld";
	}
	// URL: http://localhost:8080/projet_Tomcat/rest/MonService/helloWorld

	// Retourner du Json
	@Path("/helloWorldJson")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEleve() {
		Eleve eleve = new Eleve("bob", "john", 12);
		Gson gson = new Gson();

		return Response.status(200).entity(gson.toJson(eleve)).build();
	}

	// lire un parametre GET
	/*
	 * http://localhost:8080/TestWS/rest/MonService/helloWorldJsonWithParam?name
	 * =toto
	 */
	@Path("/helloWorldJsonWithParam")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEleveWithParam(@QueryParam("name") String name) {
		Eleve eleve = new Eleve(name, "john", 12);
		Gson gson = new Gson();
		return Response.status(200).entity(gson.toJson(eleve)).build();
	}

	//
	// // RETOURNER ET RECEVOIR DU JSON
	@POST
	@Path("/helloWorldAllJson")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEleve(String recu) {
		System.out.println(recu);
		Gson gson = new Gson();

		if (recu == null || recu.length() == 0) {
			return Response.status(200).entity(gson.toJson("Veuillez envoyer un élève")).build();

		} else {
			Eleve eleve = gson.fromJson(recu, Eleve.class);
			eleve.setNote(eleve.getNote() + 1);
			return Response.status(200).entity(gson.toJson(eleve)).build();
		}

	}
}
