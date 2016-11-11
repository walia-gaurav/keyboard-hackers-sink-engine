package rest;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Message;
import service.MessageService;

@Path("/messages")
public class MessageRoute {

	@Path("/add")
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response addMessage(@FormParam("deviceId") String deviceId, @FormParam("messageTime") String messageTime,
			@FormParam("appName") String appName, @FormParam("content") String content) {
		try {
			MessageService.addMessage(deviceId, new Date(Long.parseLong(messageTime)), appName, content);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().entity(e.toString()).build();
		}
		return Response.ok().build();
	}

	@GET
	@Path("/{deviceId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAll(@PathParam("deviceId") String deviceId) {
		return MessageService.getAllMessages(deviceId);
	}

	@GET
	@Path("/{deviceId}/{appName}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getAll(@PathParam("deviceId") String deviceId, @PathParam("appName") String appName) {
		return MessageService.getAllMessagesPerApplication(deviceId, appName);
	}

	@GET
	@Path("/distinctApps/{deviceId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getDistinctApps(@PathParam("deviceId") String deviceId) {
		return MessageService.getDistinctApplications(deviceId);
	}
}
