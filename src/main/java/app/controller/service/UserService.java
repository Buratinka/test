package app.controller.service;

import app.model.User;

public interface UserService extends ModelService<Integer, User> {
    User findByMail(String mail);
    User findByMailAndPass(String mail, String pass);
}
