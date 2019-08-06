package com.mmust.token;

abstract class BaseToken implements Token {

	private String value;

	BaseToken(String value) {
		this.value = value;
	}

	@Override
	public String getRawValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		BaseToken baseToken = (BaseToken) o;

		return value.equals(baseToken.value);
	}

	@Override
	public int hashCode() {
		return value.hashCode();
	}
}
