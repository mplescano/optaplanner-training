package be.ge0ffrey.coursera.jaxb.detailpanel;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;

@XmlAccessorType(XmlAccessType.FIELD)
public class Step {

	@XmlID
	@XmlAttribute(name = "id")
	private String _id;

	@XmlAttribute(name = "title")
	private String _title;

	@XmlIDREF
	@XmlElement(name = "detailPanelReference", type = DetailPanel.class)
	private List<DetailPanel> _detailPanels; // Doesn't seem to work

}