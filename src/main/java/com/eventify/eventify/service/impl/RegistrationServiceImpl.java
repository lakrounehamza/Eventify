package com.eventify.eventify.service.impl;

import com.eventify.eventify.dto.request.RegistrationCreateRequest;
import com.eventify.eventify.dto.request.RegistrationUpdateRequest;
import com.eventify.eventify.dto.response.RegistrationResponse;
import com.eventify.eventify.entity.Registration;
import com.eventify.eventify.exception.NotFoundException;
import com.eventify.eventify.mapper.RegistrationMapper;
import com.eventify.eventify.repository.RegistrationRepository;
import com.eventify.eventify.service.RegistrationService;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Data
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationMapper registrationMapper;
    private final RegistrationRepository registrationRepository;
    private final RegistrationService registrationService;

    @Override
    public RegistrationResponse save(RegistrationCreateRequest registrationRequest) {
        Registration registration = registrationMapper.toEntity(registrationRequest);
        Registration registrationSaved = registrationRepository.save(registration);
        return registrationMapper.toResponse(registrationSaved);
    }

    @Override
    public RegistrationResponse getRegistrationById(UUID id) {
       Optional<Registration> registration  =  registrationRepository.findById(id);
            if(registration.isPresent())
                return  registrationMapper.toResponse(registration.get());
            throw new NotFoundException("nout  found  user  a  id : "+id);
    }

    @Override
    public RegistrationResponse update(UUID id, RegistrationUpdateRequest registrationRequest) {
        Optional<Registration> registration  =  registrationRepository.findById(id);
        if(registration.isPresent()){
            Registration oldRegistration   =  registration.get();
            if(!registrationRequest.getStatus().isEmpty())
                oldRegistration.setStatus(registrationRequest.getStatus());
            if(registrationRequest.getEventId() != null)
                oldRegistration.setEventId(registrationRequest.getEventId());
            if(registrationRequest.getUserId() != null)
                oldRegistration.setUserId(registrationRequest.getUserId());
            if(registrationRequest.getRegisteredAt() !=null)
                oldRegistration.setRegisteredAt(registrationRequest.getRegisteredAt());
            registrationRepository.save(oldRegistration);
        }
        throw new NotFoundException("nout  found  user pour  modificatoin a  id : "+id);
    }

    @Override
    public String delete(UUID id) {
        Optional<Registration> registration  =  registrationRepository.findById(id);
        if(registration.isPresent()) {
            registrationRepository.deleteById(id);
            return  "supression  avec  secss";
        }

        throw new NotFoundException("nout  found  user pour  seprission a  id : "+id);

    }

    @Override
    public Page<RegistrationResponse> getAll(Pageable pageable) {
        Page<Registration> list = registrationRepository.findAll(pageable);
        if(list.getTotalElements()<1)
            throw new NotFoundException("trouvé aucan reistaration");
        return list.map(registrationMapper::toResponse);
    }
}
