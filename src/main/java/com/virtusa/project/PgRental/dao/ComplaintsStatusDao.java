package com.virtusa.project.PgRental.dao;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.virtusa.project.PgRental.dto.ComplaintStatusDTO;
import com.virtusa.project.PgRental.model.ComplaintStatuses;
import com.virtusa.project.PgRental.repository.ComplaintStatusRepository;

@Repository
public class ComplaintsStatusDao {

    @Autowired
    private ComplaintStatusRepository complaintStatusRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ComplaintStatusDTO> getAllComplaintStatus() {
        List<ComplaintStatuses> statuses = complaintStatusRepository.findAll();
        return statuses.stream()
                       .map(status -> modelMapper.map(status, ComplaintStatusDTO.class))
                       .collect(Collectors.toList());
    }

    public ComplaintStatusDTO getComplaintStatusById(long statusId) {
        ComplaintStatuses status = complaintStatusRepository.findById(statusId)
                .orElseThrow(() -> new RuntimeException("Status not found"));
        return modelMapper.map(status, ComplaintStatusDTO.class);
    }

    public ComplaintStatusDTO createComplaintStatus(ComplaintStatusDTO complaintStatusDTO) {
        // Check DTO values before mapping
        System.out.println("DTO received in DAO: " + complaintStatusDTO);
    
        ComplaintStatuses status = modelMapper.map(complaintStatusDTO, ComplaintStatuses.class);
        ComplaintStatuses savedStatus = complaintStatusRepository.save(status);
        return modelMapper.map(savedStatus, ComplaintStatusDTO.class);
    }
    
    public ComplaintStatusDTO updateComplaintStatus(long statusId, ComplaintStatusDTO complaintStatusDTO) {
        ComplaintStatuses status = complaintStatusRepository.findById(statusId)
                .orElseThrow(() -> new RuntimeException("Status not found"));
        status.setStatusName(complaintStatusDTO.getStatusName());
        ComplaintStatuses updatedStatus = complaintStatusRepository.save(status);
        return modelMapper.map(updatedStatus, ComplaintStatusDTO.class);
    }

    public void deleteComplaintStatus(long statusId) {
        ComplaintStatuses status = complaintStatusRepository.findById(statusId)
                .orElseThrow(() -> new RuntimeException("Status not found"));
        complaintStatusRepository.delete(status);
    }
}
