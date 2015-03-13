package it.redhat.accenture.jaws.simple.persistence;

public interface JAWSRepository<T> {

  Integer start(T object);

  void complete(Integer processId);

  void error(Integer processId);
}
