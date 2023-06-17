package com.codeurmas.orderapi.service.mapper;

import com.codeurmas.orderapi.model.*;
import com.codeurmas.orderapi.service.dto.*;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",
unmappedTargetPolicy = ReportingPolicy.WARN)
public interface CustomerMapper extends EntityMapper<Customer, CustomerDto> {

}
