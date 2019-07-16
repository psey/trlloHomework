package com.trello.api.models;

import java.util.List;

public class Members {
    public String id;
    public String avatarHash;
    public String avatarUrl;
    public String bio;
    public Object bioData;
    public Boolean confirmed;
    public String email;
    public String fullName;
    public String gravatarHash;
    public List<String> idBoards;
    public List<String> idOrganizations;
    public List<String> idEnterprisesAdmin;
    public List<String> idPremOrgsAdmin;
    public String initials;
    public List<String> loginTypes;
    public Object prefs;
    public String username;

    public Members() {
    }

    @Override
    public String toString() {
        return "Members{" +
                "id='" + id + '\'' +
                ", avatarHash='" + avatarHash + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", bio='" + bio + '\'' +
                ", bioData=" + bioData +
                ", confirmed=" + confirmed +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", gravatarHash='" + gravatarHash + '\'' +
                ", idBoards=" + idBoards +
                ", idOrganizations=" + idOrganizations +
                ", idEnterprisesAdmin=" + idEnterprisesAdmin +
                ", idPremOrgsAdmin=" + idPremOrgsAdmin +
                ", initials='" + initials + '\'' +
                ", loginTypes=" + loginTypes +
                ", prefs=" + prefs +
                ", username='" + username + '\'' +
                '}';
    }
}
