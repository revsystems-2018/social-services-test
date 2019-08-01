package com.dharbor.set.social.services.application.wrapper;

import com.dharbor.set.social.services.application.domain.Explanation;

/**
 * @author rveizaga
 */
public class ExplanationWrapper {

    private Object metadata;

    private Explanation content;

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public Explanation getContent() {
        return content;
    }

    public void setContent(Explanation content) {
        this.content = content;
    }
}
