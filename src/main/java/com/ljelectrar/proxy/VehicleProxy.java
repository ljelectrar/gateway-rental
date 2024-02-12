package com.ljelectrar.proxy;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ljelectrar.model.Vehicle;

@Component
public class VehicleProxy {

	private final RestTemplate restTemplate;
	private final String url;

	// Using Constructor IoC
	public VehicleProxy(String url, RestTemplate restTemplate) {
		this.url = url;
		this.restTemplate = restTemplate;
	}

	public void create(Vehicle vehicle) {
		restTemplate.postForObject(url + "v1", vehicle, Vehicle.class);
	}

	public void associate(String vehicleId, String userId) {
		restTemplate.postForObject(url + "v1/{vehicle.url}/users/{userId}", null, Void.class,
				Map.of("vehicleId", vehicleId,"userId", userId));
	}

	public void removeAssocitation(String vehicleId, String userId) {
		restTemplate.delete(url + "v1/{vehicleId}/users/{userId}", Map.of("vehicleId", vehicleId, "userId", userId));
	}

	
}
