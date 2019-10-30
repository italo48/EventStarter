package com.br.italoscompany.eventstarterapp.Model.data;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;

import java.util.ArrayList;
import java.util.List;

public class EventDBMemory implements IModel.IEventModel {
    private List<Event> events;

    public EventDBMemory() {
        events = new ArrayList<>();
        events.add(new Event(1, "Pacce o som", null, null, null));
        events.add(new Event(2, "Calourada da UFC", null, null, null));
        events.add(new Event(3, "Calourada de Odonto da Católica", null, null, null));
        events.add(new Event(4, "Calourada de Odonto da Cisnei", null, null, null));
        events.add(new Event(5, "Show do Rappa no Matulão", null, null, null));
        events.add(new Event(6, "Festival da cerveja", null, null, null));
        events.add(new Event(7, "Festival da carne", null, null, null));
        events.add(new Event(8,"Social do Gordim", null, null, null));
        events.add(new Event(9, "Aniversário do Josman", null, null, null));
        events.add(new Event(10, "Aniversário do Asis", null, null, null));
        events.add(new Event(11,"Protesto contra algo", null, null, null));
        events.add(new Event(12, "Natal", null, null, null));
        events.add(new Event(13,"Jogar bosta na casa do Ilário", null, null, null));
    }

    @Override
    public void addEvent(Event e) {

    }

    @Override
    public void deleteEvent(long id) {

    }

    @Override
    public Event findEventById(int id) {
        for (Event e : this.events)
            if (e.getId() == id)
                return e;
        return null;
    }

    @Override
    public List<Event> getAllEvents() {
        return this.events;
    }
}
