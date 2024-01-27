package com.tarini.api;

import com.tarini.repository.CredentialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class MainRestController
{
    private final CredentialRepository credentialRepository;

    @GetMapping("get/users/all")
    public ResponseEntity<List<String>> getAllUsers()
    {
         List<String> userList =  credentialRepository.findAll().
                 stream().map(credential -> credential.getUsername()).collect(Collectors.toList());

         return ResponseEntity.ok(userList);
    }
}
