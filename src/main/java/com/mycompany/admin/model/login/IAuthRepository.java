/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.admin.model.login;

/**
 *
 * @author Aditya
 */
public interface IAuthRepository {
    boolean login(String username, String rawPassword);
}
