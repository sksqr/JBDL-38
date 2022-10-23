package io.bootify.l12_minor_project_01.service;

import io.bootify.l12_minor_project_01.domain.Address;
import io.bootify.l12_minor_project_01.domain.Flat;
import io.bootify.l12_minor_project_01.domain.User;
import io.bootify.l12_minor_project_01.model.UserDTO;
import io.bootify.l12_minor_project_01.model.UserStatus;
import io.bootify.l12_minor_project_01.repos.AddressRepository;
import io.bootify.l12_minor_project_01.repos.FlatRepository;
import io.bootify.l12_minor_project_01.repos.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final FlatRepository flatRepository;
    private final AddressRepository addressRepository;

    public UserService(final UserRepository userRepository, final FlatRepository flatRepository,
            final AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.flatRepository = flatRepository;
        this.addressRepository = addressRepository;
    }

    public List<UserDTO> findAll() {
        return userRepository.findAll(Sort.by("id"))
                .stream()
                .map(user -> mapToDTO(user, new UserDTO()))
                .collect(Collectors.toList());
    }

    public UserDTO get(final Long id) {
        return userRepository.findById(id)
                .map(user -> mapToDTO(user, new UserDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final UserDTO userDTO) {
        final User user = new User();
        mapToEntity(userDTO, user);
        return userRepository.save(user).getId();
    }

    public void update(final Long id, final UserDTO userDTO) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(userDTO, user);
        userRepository.save(user);
    }

    public void updateStatus(final Long id, final UserStatus status){
        User user = userRepository.findById(id).get();
        user.setStatus(status);
        userRepository.save(user);
    }

    public void delete(final Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO mapToDTO(final User user, final UserDTO userDTO) {
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        userDTO.setRole(user.getRole());
        userDTO.setStatus(user.getStatus());
        userDTO.setFlat(user.getFlat() == null ? null : user.getFlat().getId());
        userDTO.setAddress(user.getAddress() == null ? null : user.getAddress().getId());
        return userDTO;
    }

    private User mapToEntity(final UserDTO userDTO, final User user) {
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setRole(userDTO.getRole());
        user.setStatus(userDTO.getStatus());
        final Flat flat = userDTO.getFlat() == null ? null : flatRepository.findById(userDTO.getFlat())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "flat not found"));
        user.setFlat(flat);
        final Address address = userDTO.getAddress() == null ? null : addressRepository.findById(userDTO.getAddress())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "address not found"));
        user.setAddress(address);
        return user;
    }

}
