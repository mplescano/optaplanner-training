package org.optaplanner.examples.common.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.examples.common.persistence.LongIdAdapter;

@SuppressWarnings("serial")
public abstract class AbstractJaxbPersistable implements Serializable {

    protected Long id;

    protected AbstractJaxbPersistable() {
    }

    protected AbstractJaxbPersistable(long id) {
        this.id = id;
    }

    @PlanningId
	@XmlAttribute
    @XmlJavaTypeAdapter(LongIdAdapter.class)
    @XmlID
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return getClass().getName().replaceAll(".*\\.", "") + "-" + id;
    }

}