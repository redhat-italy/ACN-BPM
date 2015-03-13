package it.redhat.accenture.jaws.simple.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SimpleObject implements Externalizable{

  private String value;
  private String test;

  public SimpleObject() {
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getTest() {
    return test;
  }

  public void setTest(String test) {
    this.test = test;
  }

  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeUTF(value);
    out.writeUTF(test);
  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    value = in.readUTF();
    test = in.readUTF();
  }
}
