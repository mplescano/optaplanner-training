package org.optaplanner.persistence.jaxb.impl.domain.solution;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import org.xml.sax.SAXException;

import com.sun.xml.bind.IDResolver;

public class IDResolverExtension extends IDResolver {
	
	private static final Object DEFAULT = new Object();

	private final Map<KeyAndClass, Object> mStore = new HashMap<KeyAndClass, Object>();

	@Override
	public void bind(String id, Object obj) throws SAXException {
		assert id != null;
		assert obj != null;
		Class<? extends Object> clazz = obj.getClass();
		assert clazz != null;
		final KeyAndClass key = new KeyAndClass(clazz, id);
		final Object currValue = mStore.get(key);
		if (currValue != null && currValue != DEFAULT) {
			final String message = MessageFormat.format("duplicated key ''{0}'' => ''{1}'' - old: ''{2}''", key, obj,
					currValue);
			throw new AssertionError(message);
		}
		mStore.put(key, obj);
	}

	@Override
	public Callable<?> resolve(String id, Class targetType) throws SAXException {
		assert targetType != null;
		assert id != null;
		final KeyAndClass key = new KeyAndClass(targetType, id);
		return () -> mStore.getOrDefault(key, DEFAULT);
	}

	public static final class CallableImplementation implements Callable<Object> {
		private final Object value;

		private CallableImplementation(final Object value) {
			this.value = value;
		}

		@Override
		public Object call() {
			return value;
		}
	}

	static class KeyAndClass {
		public final Class<?> clazz;
		public final String key;

		public KeyAndClass(final Class<?> clazz, final String key) {
			this.clazz = clazz;
			this.key = key;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + clazz.hashCode();
			result = prime * result + key.hashCode();
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final KeyAndClass other = (KeyAndClass) obj;
			if (!clazz.equals(other.clazz)) {
				return false;
			}
			if (!key.equals(other.key)) {
				return false;
			}
			return true;
		}

	}

}
