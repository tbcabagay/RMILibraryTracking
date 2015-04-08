/*
 * University Library, UP Los Banos
 * Computer Usage Tracking System
 */
package client.utilities;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tbcabagay
 */
public class Messages {

    public Messages() {
        this.message = new HashMap<>();
        initValues();
    }

    private void initValues() {
        message.put("studentfield_error", "Student ID is required.");
        message.put("passwordfield_error", "Password is required.");
        message.put("studentpasswordfield_error", "Student ID and Password are required.");
    }

    public String getMessage(String key) {
        String value;

        if ((key.length() > 0) && (message.containsKey(key))) {
            value = message.get(key);
        } else {
            value = "No message assigned.";
        }

        return value;
    }

    private final Map<String, String> message;
}
