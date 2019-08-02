package com.dharbor.set.social.services.application.request;

import java.util.List;

/**
 * @author rveizaga
 */
public class ChatChannelRequest {

    private String label;

    private String description;

    private List<String> userIds;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }
}
