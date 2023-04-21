package kr.flab.ottsharing.notification.domain;


public interface UserReader {
    ReadUserModel getUserByEmail(String email);
}
