package it.redhat.accenture.jaws.simple.camel.component;

import it.redhat.accenture.jaws.simple.camel.endpoint.JAWSEndpoint;
import org.apache.camel.*;
import org.apache.camel.impl.DefaultComponent;

import java.util.Map;

public class JAWSCamelComponent extends DefaultComponent {

  @Override
  protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
    return new JAWSEndpoint(this, uri, remaining);
  }


}
