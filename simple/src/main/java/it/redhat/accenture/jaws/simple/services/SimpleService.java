package it.redhat.accenture.jaws.simple.services;

import it.redhat.accenture.jaws.simple.domain.SimpleObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public interface SimpleService {

  @POST
  @Path("/simple")
  @Consumes(MediaType.APPLICATION_JSON)
  Response simple(SimpleObject object);
}
