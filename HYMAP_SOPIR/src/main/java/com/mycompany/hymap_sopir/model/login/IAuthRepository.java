package com.mycompany.hymap_sopir.model.login;

public interface IAuthRepository {
    Sopir findByUsername(String username);
}