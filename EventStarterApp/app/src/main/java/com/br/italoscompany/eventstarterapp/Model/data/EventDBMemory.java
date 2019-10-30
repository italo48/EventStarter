package com.br.italoscompany.eventstarterapp.Model.data;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;

import java.util.ArrayList;
import java.util.List;

public class EventDBMemory implements IModel.IEventModel {
    private List<Event> events;

    public EventDBMemory() {
        events = new ArrayList<>();
        events.add(new Event("Pacce o som", null, null, null));
        events.add(new Event("Calourada da UFC", null, null, null));
        events.add(new Event("Calourada de Odonto da Católica", null, null, null));
        events.add(new Event("Calourada de Odonto da Cisnei", null, null, null));
        events.add(new Event("Show do Rappa no Matulão", null, null, null));
        events.add(new Event("Festival da cerveja", null, null, null));
        events.add(new Event("Festival da carne", null, null, null));
        events.add(new Event("Social do Gordim", null, null, null));
        events.add(new Event("Aniversário do Josman", null, null, null));
        events.add(new Event("Aniversário do Asis", null, null, null));
        events.add(new Event("Protesto contra algo", null, null, null));
        events.add(new Event("Natal", null, null, null));
        events.add(new Event("Jogar bosta na casa do Ilário", null, null, null));
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
