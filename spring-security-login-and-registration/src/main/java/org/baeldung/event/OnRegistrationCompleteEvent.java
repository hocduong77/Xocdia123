package org.baeldung.event;

import java.util.Locale;

import org.baeldung.persistence.model.User;

public class OnRegistrationCompleteEvent {

    private final String appUrl;
    private final Locale locale;
    private final User user;

    public OnRegistrationCompleteEvent(User user, Locale locale, String appUrl) {
        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public Locale getLocale() {
        return locale;
    }

    public User getUser() {
        return user;
    }
}
