package com.virtusa.project.PgRental.dao;



import com.virtusa.project.PgRental.dto.AppointmentDto;
import com.virtusa.project.PgRental.model.Appointment;
import com.virtusa.project.PgRental.repository.AppointmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AppointmentDao {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AppointmentDto save(AppointmentDto appointmentDTO) {
        Appointment appointment = modelMapper.map(appointmentDTO, Appointment.class);
        appointment = appointmentRepository.save(appointment);
        return modelMapper.map(appointment, AppointmentDto.class);
    }

    public Optional<AppointmentDto> findById(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        return appointment.map(value -> modelMapper.map(value, AppointmentDto.class));
    }

    public void deleteById(Long id) {
        appointmentRepository.deleteById(id);
    }

    public List<AppointmentDto> findAll() {
        return appointmentRepository.findAll().stream()
                .map(appointment -> modelMapper.map(appointment, AppointmentDto.class))
                .collect(Collectors.toList());
    }
}
