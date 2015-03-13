package it.redhat.accenture.jaws.simple.camel.endpoint;

import it.redhat.accenture.jaws.simple.domain.SimpleObject;
import it.redhat.accenture.jaws.simple.persistence.JAWSRepository;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JAWSErrorProcessor implements Processor {

  private static final Logger log = LoggerFactory.getLogger(JAWSErrorProcessor.class);
  private final JAWSRepository<SimpleObject> repository;

  public JAWSErrorProcessor(JAWSRepository<SimpleObject> repository) {
    this.repository = repository;
  }

  @Override
  public void process(Exchange exchange) throws Exception {
    Object id = exchange.getIn().getHeader(JAWSProducer.PROCESS_ID);
    log.info("ERROR JAWS PROCESS ID [" + id + "]");
    if (id instanceof Integer) {
      repository.error((Integer) id);
    } else {
      throw new RuntimeException("Process ID not found in headers");
    }
  }
}
