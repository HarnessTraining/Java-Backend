package com.virtusa.project.PgRental.service;

import java.util.List;
import com.virtusa.project.PgRental.dto.ComplaintUpdatesDTO;

public interface ComplaintsUpdatesService {
    ComplaintUpdatesDTO saveComplaintUpdate(ComplaintUpdatesDTO complaintUpdateDTO);
    List<ComplaintUpdatesDTO> getAllComplaintUpdates();
}
