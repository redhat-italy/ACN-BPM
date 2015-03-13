package it.redhat.accenture.jaws.simple.support;

import org.apache.camel.Exchange;

import javax.ws.rs.core.Response;

public class ReponseWrapper {

  public Response buildOk(Object o) {
    if(o instanceof Exchange) {
      return Response.ok().build();
    }
    return Response.ok().entity(o).build();
  }
}
