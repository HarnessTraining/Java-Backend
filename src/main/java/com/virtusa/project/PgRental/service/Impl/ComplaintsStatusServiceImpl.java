package com.virtusa.project.PgRental.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.virtusa.project.PgRental.dao.ComplaintsStatusDao;
import com.virtusa.project.PgRental.dto.ComplaintStatusDTO;
import com.virtusa.project.PgRental.service.ComplaintsStatusServices;

@Service
@Transactional
public class ComplaintsStatusServiceImpl implements ComplaintsStatusServices {

    @Autowired
    private ComplaintsStatusDao complaintsStatusDao;

    @Override
    public List<ComplaintStatusDTO> getAllComplaintStatuses() {
        return complaintsStatusDao.getAllComplaintStatus();
    }

    @Override
    public ComplaintStatusDTO getComplaintStatusById(long statusId) {
        return complaintsStatusDao.getComplaintStatusById(statusId);
    }

    @Override
    public ComplaintStatusDTO createComplaintStatus(ComplaintStatusDTO complaintStatusDTO) {
        return complaintsStatusDao.createComplaintStatus(complaintStatusDTO);
    }

    @Override
    public ComplaintStatusDTO updateComplaintStatus(long statusId, ComplaintStatusDTO complaintStatusDTO) {
        return complaintsStatusDao.updateComplaintStatus(statusId, complaintStatusDTO);
    }

}
