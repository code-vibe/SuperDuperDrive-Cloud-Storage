package com.udacity.jwdnd.course1.cloudstorage.mapper;

import org.apache.ibatis.annotations.*;

@Mapper
public interface Credentials {
    @Select("SELECT * FROM CREDENTIALS WHERE userid = #{UserId}")
    Credentials[] getCredentials(Integer credentials);

    @Select("SELECT * FROM CREDENTIALS WHERE credentialsid = #{credentialsId}")
    Credentials getCredentialsById(Integer credentialsId);

    @Insert("INSERT INTO CREDENTIALS (url, username, key, password, userid) " +
            "VALUES(#{url}, #{userName}, #{key}, #{password}, #{userid})")
    @Options(useGeneratedKeys = true, keyProperty = "credentialid")
    int insert(Credentials credentials);

    @Delete("DELETE FROM CREDENTIALS WHERE credentialsid = #{credentialsId}")
    void deleteCredentials(Integer credentialsId);

    @Update("UPDATE CREDENTIALS SET url = #{url}, key = #{key}, password = #{password}, username = #{newUserName} WHERE credentialsid = #{credentialsId}")
    void updateCredentials(Integer credentialsId, String newUserName, String url, String key, String password);

}
