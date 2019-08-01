package com.dharbor.set.social.services.application.domain;

/**
 * @author rveizaga
 */
public class Explanation {

    private Long id;

    private String resourceId;

    private Integer indicator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getIndicator() {
        return indicator;
    }

    public void setIndicator(Integer indicator) {
        this.indicator = indicator;
    }
}
