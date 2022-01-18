package com.javatpoint.customendpoint;

import org.springframework.boot.actuate.endpoint.EndpointFilter;
import org.springframework.boot.actuate.endpoint.ExposableEndpoint;
import org.springframework.stereotype.Component;

@Component
public class CustomEndPoint implements EndpointFilter {

	@Override
	public boolean match(ExposableEndpoint endpoint) {
		// TODO Auto-generated method stub
		return false;
	}

}
