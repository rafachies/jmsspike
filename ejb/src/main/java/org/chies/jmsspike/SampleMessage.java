package org.chies.jmsspike;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sample")
@XmlAccessorType(XmlAccessType.FIELD)
public class SampleMessage implements Serializable{


	private static final long serialVersionUID = 3087917140302309229L;

	@XmlElement(name = "sequential")
	private Integer sequential;
	
	@XmlElement(name = "description")
	private String description;

	public Integer getSequential() {
		return sequential;
	}

	public void setSequential(Integer sequential) {
		this.sequential = sequential;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
