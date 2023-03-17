/*
 * Project: Recipe App
 * Assignment: COMP3095 Assignment2
 * Author(s): Arghawan Ghulam Siddiq,  Joyce Ashley Borla
 * Student Number: 101334946, 101190436,
 */
package gbc.comp3095.assignment2.services;

import gbc.comp3095.assignment2.models.Event;
import gbc.comp3095.assignment2.models.User;
import gbc.comp3095.assignment2.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    public void save(Event event, User user) {
        event.setUser(user);
        eventRepository.save(event);
    }

    public Set<Event> listAll(String keyword) {
        if (keyword != null) {
            return eventRepository.search(keyword);
        }
        Set<Event> e = new HashSet<>(eventRepository.findAll());
        return e;
    }

    @Override
    public Event findByName(String name) {
        return eventRepository.findByName(name);
    }
}
