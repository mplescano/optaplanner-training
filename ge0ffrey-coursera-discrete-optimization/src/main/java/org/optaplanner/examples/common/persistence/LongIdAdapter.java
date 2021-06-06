package org.optaplanner.examples.common.persistence;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LongIdAdapter extends XmlAdapter<String, Long> {

	@Override
	public String marshal(Long v) throws Exception {
		return Long.toString(v.longValue());
	}

	@Override
	public Long unmarshal(String v) throws Exception {
		return Long.valueOf(v);
	}

}
