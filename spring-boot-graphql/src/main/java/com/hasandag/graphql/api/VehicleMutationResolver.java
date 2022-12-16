package com.hasandag.graphql.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hasandag.graphql.dto.VehicleDTO;
import com.hasandag.graphql.entity.Vehicle;
import com.hasandag.graphql.repo.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class VehicleMutationResolver implements GraphQLMutationResolver {

    private final VehicleRepository vehicleRepository;

    public Vehicle createVehicle(VehicleDTO vehicleDTO) {
        return vehicleRepository.save(dtoToEntitiy(vehicleDTO));
    }

    private Vehicle dtoToEntitiy(VehicleDTO vehicleDTO){
        Vehicle vehicle = new Vehicle();
        vehicle.setBrandName(vehicleDTO.getBrandName());
        vehicle.setLunchDate(new Date());
        vehicle.setModelCode(vehicleDTO.getModelCode());
        vehicle.setType(vehicleDTO.getType());
        return vehicle;
    }
}
