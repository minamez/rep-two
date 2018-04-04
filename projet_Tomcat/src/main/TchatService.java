package main;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path("/TchatService")
public class TchatService {

	// private static final ArrayList<MessageBean> mesArray = new ArrayList<>();

	// Retourner du Json
	@Path("/getMessage")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMessageBean() {
		Gson gson = new Gson();

		return Response.status(200).entity(gson.toJson(MessageBDD.mesArray)).build();
	}

	// // RETOURNER ET RECEVOIR DU JSON
	@POST
	@Path("/sendMessage")
	@Consumes(MediaType.APPLICATION_JSON)
	// @Produces(MediaType.APPLICATION_JSON)
	public Response sendMessage(String recu) {
		System.out.println(recu);
		Gson gson = new Gson();

		if (recu == null || recu.length() == 0) {
			return Response.status(200).entity(gson.toJson("Veuillez envoyer un message")).build();

		} else {
			MessageBean message = gson.fromJson(recu, MessageBean.class);
			MessageBDD.addMessage(message);
			return Response.status(200).build();
		}
	}
}
