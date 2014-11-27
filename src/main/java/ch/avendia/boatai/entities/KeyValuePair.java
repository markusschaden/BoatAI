package ch.avendia.boatai.entities;

public class KeyValuePair<S, T> {

	private S key;
	private T value;

	public S getKey() {
		return key;
	}

	public void setKey(S key) {
		this.key = key;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}
