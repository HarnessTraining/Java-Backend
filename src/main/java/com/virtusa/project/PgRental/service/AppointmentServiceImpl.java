package com.virtusa.project.PgRental.service;

import com.virtusa.project.PgRental.dao.AppointmentDao;
import com.virtusa.project.PgRental.dto.AppointmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentDao appointmentDAO;

    @Override
    public AppointmentDto createAppointment(AppointmentDto appointmentDto) {
        return appointmentDAO.save(appointmentDto);
    }

//    @Override
//    public AppointmentDto updateAppointment(Long id, AppointmentDto appointmentDTO) {
//        return null;
//    }

    @Override
    public AppointmentDto updateAppointment(Long id, AppointmentDto appointmentDTO) {
        AppointmentDto existingAppointment = appointmentDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

//        appointmentDTO.setId(existingAppointment.getId()); // Ensure ID consistency
        return appointmentDAO.save(appointmentDTO);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentDAO.deleteById(id);
    }

    @Override
    public AppointmentDto getAppointmentById(Long id) {
        return appointmentDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
    }

    @Override
    public List<AppointmentDto> getAllAppointments() {
        return appointmentDAO.findAll();
    }
}
