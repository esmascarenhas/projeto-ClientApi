package services;

import dto.mapper.ClientMapper;
import dto.request.ClientDTO;
import dto.response.MessageResponseDTO;
import entities.Client;
import exception.ClientNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ClientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClientService {

    private final ClientRepository clientRepository;

    private final ClientMapper clientMapper;

    public MessageResponseDTO create(ClientDTO clientDTO) {
        Client client = clientMapper.toModel(clientDTO);
        Client savedClient = clientRepository.save(client);

        MessageResponseDTO messageResponse = createMessageResponse("Client successfully created with ID ", savedClient.getId());

        return messageResponse;
    }

    public ClientDTO findById(Long id) throws ClientNotFoundException {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        return clientMapper.toDTO(client);
    }

    public List<ClientDTO> listAll() {
        List<Client> people = clientRepository.findAll();
        return people.stream()
                .map(clientMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, ClientDTO clientDTO) throws ClientNotFoundException {
        clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        Client updatedClient = clientMapper.toModel(clientDTO);
        Client savedClient = clientRepository.save(updatedClient);

        MessageResponseDTO messageResponse = createMessageResponse("Client successfully updated with ID ", savedClient.getId());

        return messageResponse;
    }

    public void delete(Long id) throws ClientNotFoundException {
        clientRepository.findById(id)
                .orElseThrow(() -> new ClientNotFoundException(id));

        clientRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }
}
