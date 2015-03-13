package it.redhat.accenture.jaws.simple.persistence;

public class Process<T> {

  private Status status = Status.STARTED;
  private T data;

  public Process(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public Status getStatus() {
    return status;
  }

  public boolean isCompleted() {
    return status.equals(Status.COMPLETED);
  }

  public boolean isStarted() {
    return status.equals(Status.STARTED);
  }

  public void complete() {
    status = Status.COMPLETED;
  }

  public void error() {
    status = Status.ERROR;
  }
}
