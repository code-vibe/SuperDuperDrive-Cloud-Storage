package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Credential;

public class CredentialService {
    public final CredentialMapper credentialMapper;
    public final UserMapper userMapper;

    public CredentialService (CredentialMapper credentialMapper, UserMapper userMapper){
        this.credentialMapper = credentialMapper;
        this.userMapper = userMapper;
    }

    public void createCredential(String url, String userName, String credentialuserName, String key, String password ) {
        Integer userId = userMapper.getUser(userName).getUserId();
        Credential credential = new Credential(0, url, credentialuserName, key, password, userId);
        credentialMapper.insert(credential);
    }

    public Credential[] getCredential(Integer userId){
        return credentialMapper.getCredential(userId);
    }

    public Credential getCredentialById(Integer credentialId) {
        return credentialMapper.getCredentialById(credentialId);
    }
     public void deleteCredential(Integer credentialsId) {
        credentialMapper.deleteCredential(credentialsId);
     }
     public void updateCredential(Integer credentialId, String url, String key, String password, String userName) {
        credentialMapper.updateCredential(credentialId, url,key,password, userName);
     }
}
