package com.virtusa.project.PgRental.service;

import com.virtusa.project.PgRental.dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {
    AppointmentDto createAppointment(AppointmentDto appointmentDTO);
    AppointmentDto updateAppointment(Long id, AppointmentDto appointmentDTO);
    void deleteAppointment(Long id);
    AppointmentDto getAppointmentById(Long id);
    List<AppointmentDto> getAllAppointments();
}

