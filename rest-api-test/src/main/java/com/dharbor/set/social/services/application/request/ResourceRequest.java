package com.dharbor.set.social.services.application.request;

import com.dharbor.set.social.services.application.wrapper.ResourceExplanationRegistryWrapper;

import java.util.List;

/**
 * @author rveizaga
 */
public class ResourceRequest {

    private List<ResourceExplanationRegistryWrapper> resources;

    public List<ResourceExplanationRegistryWrapper> getResources() {
        return resources;
    }

    public void setResources(List<ResourceExplanationRegistryWrapper> resources) {
        this.resources = resources;
    }
}
