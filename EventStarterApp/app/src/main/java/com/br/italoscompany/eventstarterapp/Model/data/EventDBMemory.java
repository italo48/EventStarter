package com.br.italoscompany.eventstarterapp.Model.data;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.Location;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

public class EventDBMemory implements IModel.IEventModel {
    private List<Event> events;
    private List<Outlets> outlets;
    private List<Outlets> outlets2;

    public EventDBMemory() {
        //criando lista de ponto de vendas


        outlets = new ArrayList<>();
        outlets.add(new Outlets(50,"banco do nordeste", 100, new LatLng(-4.970629, -39.0153342)));
        outlets.add(new Outlets(51,"banco do bradesco", 100, new LatLng(-4.9690947, -39.0145415)));
        outlets.add(new Outlets(51,"Brisanet", 100, new LatLng(-4.9722656, -39.0164654)));

        outlets2 = new ArrayList<>();
        outlets2.add(new Outlets(50,"Escola Adventista", 100, new LatLng(-4.968656, -39.00854)));
        outlets2.add(new Outlets(50,"AABB", 100, new LatLng( -4.9665735, -39.0070529)));
        outlets2.add(new Outlets(50,"HotLine Academia", 100, new LatLng(-4.969696, -39.0083955)));


        //duas localizaçoes de eventos
        LatLng local1 = new LatLng( -4.9694863,-39.0182273);
        LatLng local2 = new LatLng(-4.9675239,-39.0088084);

        //criando lista de eventos
        events = new ArrayList<>();
        events.add(new Event(1, "Pacce o som", null, local1, outlets));
        events.add(new Event(2, "Calourada da UFC", null, local1, outlets));
        events.add(new Event(3, "Calourada de Odonto da Católica", null, local1, outlets));
        events.add(new Event(4, "Calourada de Odonto da Cisnei", null, local1, outlets));
        events.add(new Event(5, "Show do Rappa no Matulão", null, local1, outlets));
        events.add(new Event(6, "Festival da cerveja", null, local1, outlets));
        events.add(new Event(7, "Festival da carne", null, local2, outlets2));
        events.add(new Event(8,"Social do Gordim", null, local2, outlets2));
        events.add(new Event(9, "Aniversário do Josman", null, local2, outlets2));
        events.add(new Event(10, "Aniversário do Asis", null, local2, outlets2));
        events.add(new Event(11,"Protesto contra algo", null, local2, outlets2));
        events.add(new Event(12, "Natal", null, null, outlets2));
        events.add(new Event(13,"Jogar bosta na casa do Ilário", null, local2, outlets2));
    }

    @Override
    public void addEvent(Event e) {
        events.add(e);
    }

    @Override
    public void deleteEvent(long id) {
        for(Event e : events){
            if(e.getId() == id){
                events.remove(id);
            }
        }
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

    public int size() {
        return events.size();
    }
}
