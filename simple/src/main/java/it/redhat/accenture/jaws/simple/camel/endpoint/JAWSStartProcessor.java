package it.redhat.accenture.jaws.simple.camel.endpoint;

import it.redhat.accenture.jaws.simple.domain.SimpleObject;
import it.redhat.accenture.jaws.simple.persistence.JAWSRepository;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JAWSStartProcessor implements Processor {

  private static final Logger log = LoggerFactory.getLogger(JAWSStartProcessor.class);

  private final JAWSRepository<SimpleObject> repository;

  public JAWSStartProcessor(JAWSRepository<SimpleObject> repository) {
    this.repository = repository;
  }

  @Override
  public void process(Exchange exchange) throws Exception {
    SimpleObject simpleObject = exchange.getIn().getBody(SimpleObject.class);
    Integer id = repository.start(simpleObject);
    log.info("START NEW JAWS PROCESS [" + id + "]");
    exchange.getIn().setHeader(JAWSProducer.PROCESS_ID, id);
  }
}
