package com.virtusa.project.PgRental.dao;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.virtusa.project.PgRental.dto.ComplaintUpdatesDTO;
import com.virtusa.project.PgRental.model.ComplaintUpdates;
import com.virtusa.project.PgRental.model.User;
import com.virtusa.project.PgRental.repository.ComplaintsUpdatesRepo;
import com.virtusa.project.PgRental.repository.UserRepository;

@Repository
public class ComplaintsUpdatesDao {

    @Autowired
    private ComplaintsUpdatesRepo complaintsUpdatesRepo;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    public List<ComplaintUpdatesDTO> getAllComplaintUpdate() {
        List<ComplaintUpdates> updates = complaintsUpdatesRepo.findAll();
        return updates.stream()
                      .map(update -> modelMapper.map(update, ComplaintUpdatesDTO.class))
                      .collect(Collectors.toList());
    }

    public ComplaintUpdatesDTO saveComplaintUpdate(ComplaintUpdatesDTO complaintUpdateDTO) {
        ComplaintUpdates update = modelMapper.map(complaintUpdateDTO, ComplaintUpdates.class);
        // System.out.println(update);
        User user = userRepository.findById(complaintUpdateDTO.getUpdatedBy()).get();
        update.setUpdatedBy(user);

        ComplaintUpdates savedUpdate = complaintsUpdatesRepo.save(update);
        ComplaintUpdatesDTO response = new ComplaintUpdatesDTO();
        response.setComplaintId(savedUpdate.getComplaint().getComplaintId());
        response.setUpdateDescription(savedUpdate.getUpdateDescription());
        response.setUpdateId(savedUpdate.getUpdateId());
        response.setUpdateTimestamp(savedUpdate.getUpdateTime());
        response.setUpdatedBy(savedUpdate.getUpdatedBy().getUserId());
        return response;
        // return modelMapper.map(savedUpdate, ComplaintUpdatesDTO.class);
    }
}
