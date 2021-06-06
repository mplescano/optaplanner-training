package be.ge0ffrey.coursera.jaxb.detailpanel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;

@XmlAccessorType(XmlAccessType.FIELD)
public class DetailPanel {

	@XmlID
	@XmlAttribute(name = "id")
	private String _id;

	@XmlAttribute(name = "title")
	private String _title;

}