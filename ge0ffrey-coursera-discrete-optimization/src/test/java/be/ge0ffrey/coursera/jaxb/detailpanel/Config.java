package be.ge0ffrey.coursera.jaxb.detailpanel;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Config {

	@XmlElement(name = "step")
	private Step step;

	@XmlElement(name = "detailPanels")
	private List<DetailPanel> detailPanels;

}
