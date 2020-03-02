package com.example.firstrelese;

public class UserApiResponse {
	private charge1 data;

	public charge1 getData() {
		return data;
	}

	public void setData(charge1 data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "UserApiResponse [data=" + data + "]";
	}
}
