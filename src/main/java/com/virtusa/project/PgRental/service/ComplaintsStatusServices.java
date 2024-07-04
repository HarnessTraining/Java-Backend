package com.virtusa.project.PgRental.service;

import java.util.List;

import com.virtusa.project.PgRental.dto.ComplaintStatusDTO;

public interface ComplaintsStatusServices {
    List<ComplaintStatusDTO> getAllComplaintStatuses();

    ComplaintStatusDTO getComplaintStatusById(long statusId);

    ComplaintStatusDTO createComplaintStatus(ComplaintStatusDTO complaintStatusDTO);

    ComplaintStatusDTO updateComplaintStatus(long statusId, ComplaintStatusDTO complaintStatusDTO);

}