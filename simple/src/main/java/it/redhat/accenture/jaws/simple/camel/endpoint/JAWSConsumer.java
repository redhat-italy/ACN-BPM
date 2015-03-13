package it.redhat.accenture.jaws.simple.camel.endpoint;

import org.apache.camel.Consumer;
import org.apache.camel.Endpoint;

public class JAWSConsumer implements Consumer {

  private Endpoint endpoint;

  public JAWSConsumer(Endpoint endpoint) {
    this.endpoint = endpoint;
  }

  @Override
  public Endpoint getEndpoint() {
    return endpoint;
  }

  @Override
  public void start() throws Exception {
  }

  @Override
  public void stop() throws Exception {
  }
}
