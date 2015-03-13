package it.redhat.accenture.jaws.simple.camel.endpoint;

import org.apache.camel.Component;
import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultEndpoint;

public class JAWSEndpoint extends DefaultEndpoint {

  private final String type;

  public JAWSEndpoint(Component component, String uri, String type) {
    super(uri, component);
    this.type = type;
  }

  @Override
  public boolean isSingleton() {
    return true;
  }

  @Override
  public Producer createProducer() throws Exception {
    return new JAWSProducer(this, type);
  }

  @Override
  public Consumer createConsumer(Processor processor) throws Exception {
    return new JAWSConsumer(this);
  }
}
