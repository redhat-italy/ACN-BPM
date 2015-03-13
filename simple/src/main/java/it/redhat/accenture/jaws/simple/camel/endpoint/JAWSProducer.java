package it.redhat.accenture.jaws.simple.camel.endpoint;

import it.redhat.accenture.jaws.simple.domain.SimpleObject;
import it.redhat.accenture.jaws.simple.persistence.JAWSRepository;
import it.redhat.accenture.jaws.simple.persistence.MemoryJAWSRepository;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.impl.DefaultProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class JAWSProducer extends DefaultProducer {

  public static final String PROCESS_ID = "JAWS_PROCESS_ID";

  private static final Logger log = LoggerFactory.getLogger(JAWSProducer.class);
  private static final JAWSRepository<SimpleObject> repository = new MemoryJAWSRepository<>();

  private static Map<String, Processor> types = new HashMap<>();

  static {
    types.put("start", new JAWSStartProcessor(repository));
    types.put("complete", new JAWSCompleteProcessor(repository));
    types.put("error", new JAWSErrorProcessor(repository));
  }

  private final Processor type;

  public JAWSProducer(Endpoint endpoint, String type) {
    super(endpoint);
    log.debug("CREATE JAWS PRODUCER ENDPOINT TYPE [" + type + "]");
    if (!types.containsKey(type)) {
      throw new IllegalArgumentException("Type [" + type + "] is not valid");
    }
    this.type = types.get(type);
  }

  @Override
  public void process(Exchange exchange) throws Exception {
    type.process(exchange);
  }

}
