package rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Device;
import service.DeviceService;

@Path("/devices")
public class DeviceRoute {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Device> getIt() {
		return DeviceService.getAll();
	}
}