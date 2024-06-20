package com.virtusa.project.PgRental.dao;

import com.virtusa.project.PgRental.dto.BookingDto;
import com.virtusa.project.PgRental.model.Booking;
import com.virtusa.project.PgRental.repository.BookingRepository;
import com.virtusa.project.PgRental.repository.UserRepository;
import com.virtusa.project.PgRental.repository.PropertyRepository;
import com.virtusa.project.PgRental.repository.RoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class BookingDao {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void createBooking(BookingDto bookingDto) {
        Booking booking = modelMapper.map(bookingDto, Booking.class);
        booking.setUser(userRepository.findById(bookingDto.getUserId()).orElse(null));
        booking.setProperty(propertyRepository.findById(bookingDto.getPropertyId()).orElse(null));
        booking.setRoom(roomRepository.findById(bookingDto.getRoomId()).orElse(null));
        bookingRepository.save(booking);
    }

    public void updateBooking(BookingDto bookingDto) {
        Booking booking = bookingRepository.findById(bookingDto.getBookingId()).orElse(null);
        if (booking != null) {
            booking = modelMapper.map(bookingDto, Booking.class);
            booking.setUser(userRepository.findById(bookingDto.getUserId()).orElse(null));
            booking.setProperty(propertyRepository.findById(bookingDto.getPropertyId()).orElse(null));
            booking.setRoom(roomRepository.findById(bookingDto.getRoomId()).orElse(null));
            bookingRepository.save(booking);
        }
    }

    public BookingDto getBookingDetails(long bookingId) {
        Optional<Booking> booking = bookingRepository.findById(bookingId);
        return booking.map(b -> modelMapper.map(b, BookingDto.class)).orElse(null);
    }

    public void deleteBooking(long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public List<BookingDto> getAllBookings() {
        List<Booking> bookingList = bookingRepository.findAll();
        List<BookingDto> bookingDtoList = new ArrayList<>();
        for (Booking booking : bookingList) {
            BookingDto bookingDto = modelMapper.map(booking, BookingDto.class);
            bookingDtoList.add(bookingDto);
        }
        return bookingDtoList;
    }

    public List<BookingDto> getBookingsByUserId(Long userId) {
        List<Booking> bookingList = bookingRepository.findByUser_userId(userId);
        List<BookingDto> bookingDtoList = new ArrayList<>();
        for (Booking booking : bookingList) {
            BookingDto bookingDto = modelMapper.map(booking, BookingDto.class);
            bookingDtoList.add(bookingDto);
        }
        return bookingDtoList;
    }
}
