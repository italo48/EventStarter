package com.br.italoscompany.eventstarterapp.Model.data;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;

import java.util.ArrayList;
import java.util.List;

public class EventDBMemory implements IModel.IEventModel {
    private List<Event> events;

    public EventDBMemory() {
        events = new ArrayList<>();
        events.add(new Event("Pacce o som", null, null, "teste"));
        events.add(new Event("Calourada da UFC", null, null, "teste"));
        events.add(new Event("Calourada de Odonto da Católica", null, null, "teste"));
        events.add(new Event("Calourada de Odonto da Cisnei", null, null, "teste"));
        events.add(new Event("Show do Rappa no Matulão", null, null, "teste"));
        events.add(new Event("Festival da cerveja", null, null, "teste"));
        events.add(new Event("Jogar bosta na casa do Ilário", null, null, "teste"));
    }

    @Override
    public void addEvent(Event e) {

    }

    @Override
    public void deleteEvent(long id) {

    }

    @Override
    public List<Event> getAllEvents() {
        return this.events;
    }
}
