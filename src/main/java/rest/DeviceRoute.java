package rest;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Device;
import service.DeviceService;

@Path("/devices")
public class DeviceRoute {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Device> getAllDevices() {
		return DeviceService.getAll();
	}

	@PUT
	@Path("/add")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response addDevice(@FormParam("deviceId") String deviceId,
			@FormParam("installDate") String installationDate) {
		try {
			DeviceService.addDevice(new Device(deviceId, new Date(Long.parseLong(installationDate))));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().entity(e.toString()).build();
		}
		return Response.ok().build();
	}

	@POST
	@Path("/remove")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response removeDevice(@FormParam("deviceId") String deviceId, @FormParam("deleteDate") String deleteDate) {
		try {
			DeviceService.removeDevice(deviceId, new Date(Long.parseLong(deleteDate)));
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().entity(e.getMessage()).build();
		}
		return Response.ok().build();
	}

}