package com.virtusa.project.PgRental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.project.PgRental.dao.ComplaintsUpdatesDao;
import com.virtusa.project.PgRental.dto.ComplaintUpdatesDTO;
import com.virtusa.project.PgRental.service.ComplaintsUpdatesService;

@Service
public class ComplaintsUpdatesServiceImpl implements ComplaintsUpdatesService {

    @Autowired
    private ComplaintsUpdatesDao complaintsUpdatesDao;

    @Override
    public ComplaintUpdatesDTO saveComplaintUpdate(ComplaintUpdatesDTO complaintUpdateDTO) {

        return complaintsUpdatesDao.saveComplaintUpdate(complaintUpdateDTO);
        // return complaintUpdateDTO;

    }

    @Override
    public List<ComplaintUpdatesDTO> getAllComplaintUpdates() {
        return complaintsUpdatesDao.getAllComplaintUpdate();
    }

}
