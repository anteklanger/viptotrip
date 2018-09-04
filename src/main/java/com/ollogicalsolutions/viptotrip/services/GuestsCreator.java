package com.ollogicalsolutions.viptotrip.services;

import com.ollogicalsolutions.viptotrip.entities.Event;
import com.ollogicalsolutions.viptotrip.entities.User;
import com.ollogicalsolutions.viptotrip.repositories.EventRepository;
import com.ollogicalsolutions.viptotrip.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class GuestsCreator {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;

    public void createListOfGuestsForEvent(String eventCode, String param) {
        List<String> guestList = Arrays.asList(convertParameterToList(param));
        if (guestList.get(guestList.size() - 1) == null) {
            guestList.remove(guestList.size() - 1);
        }

        Event event = eventRepository.findFirstByCode(eventCode);

        for (String guest : guestList
        ) {
            User user = new User();
            user.setUsername(guest);
            user.setAdminVip(false);
            user.setEditorVip(false);
            user.setGuestVip(true);
            user.setPin(generatePin());
            user.setEvent(event);
            userRepository.save(user);
        }
    }

    private String[] convertParameterToList(String guestList) {
        String toConvert = guestList.trim();
        return toConvert.split(",");
    }

    private String generatePin() {

        StringBuilder sb = new StringBuilder();
        sb
                .append(generateRandomLetter())
                .append(generateRandomNumber())
                .append(generateRandomLetter())
                .append(generateRandomNumber())
                .append(generateRandomLetter());
        return sb.toString();
    }

    private String generateRandomLetter() {
        Random r = new Random();
        char c = (char) (r.nextInt(26) + 'a');
        return String.valueOf(c);
    }

    private String generateRandomNumber() {
        Random r = new Random();
        int n = r.nextInt(10);
        return String.valueOf(n);
    }
}
