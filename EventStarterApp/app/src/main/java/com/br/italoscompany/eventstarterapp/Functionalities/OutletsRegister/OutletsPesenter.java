package com.br.italoscompany.eventstarterapp.Functionalities.OutletsRegister;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.data.OutletsDBMemory;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.MyLatLong;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;
import com.br.italoscompany.eventstarterapp.Model.network.AppDBFirebaseRealtime;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbEvent;
import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbOutlets;

public class OutletsPesenter implements IOutlets.IPresenter {

    private IModel.IOutletsModel outletsModel;
    private IModel.IEventModel eventModel;
    private IOutlets.IView iView;
    private List<Outlets> outlets;

    public OutletsPesenter(IOutlets.IView iView) {
        this.iView = iView;
        this.outletsModel = dbOutlets;
        this.eventModel = dbEvent;
        this.outlets = new ArrayList<>();
    }

    @Override
    public void getOutlets(String idEvent) {
        iView.showOutlets(this.outletsModel.getAllOutlets(idEvent));
    }

    @Override
    public void saveOutlets(String idEvent, String nameOutlets, int numTickets, MyLatLong loc) {
        if (nameOutlets.isEmpty() || numTickets < 0 || loc == null) {
            iView.showToast("Algum campo não foi preenchido");
        } else {
            Outlets o = new Outlets();
            o.setNomeDoEstabelecimento(nameOutlets);
            o.setQtdIngressos(numTickets);
            o.setLocation(loc);

            String idOutlets = AppDBFirebaseRealtime.getRef().child("Events").child(idEvent).child("Outlets").push().getKey();

            o.setId(idOutlets);

            outletsModel.addOutlets(idEvent, o);
            outlets.add(o);
        }
    }

    @Override
    public void deleteOutlets(String idEvent, String idOutlets) {
        outletsModel.deleteOutlets(idEvent, idOutlets);
    }

    @Override
    public void outletsLinkEvent(String idEvent) {
////        Event e = eventModel.findEventById(idEvent);
////        if (!this.outletsModel.getAllOutlets(idEvent).isEmpty() || this.outletsModel.getAllOutlets(idEvent) != null) {
////            e.setPontosDevendas(this.outletsModel.getAllOutlets(idEvent));
//        for (Outlets o : outlets) {
//            AppDBFirebaseRealtime.getRef().child("Events").child(idEvent).child("Outlets").push().setValue(o);
//        }
//            iView.showToast("Pontos de ventda cadastrado com sucesso");
////        }
    }

    @Override
    public void setEmptyOutlets(String id) {
        eventModel.findEventById(id).setPontosDevendas(Collections.<Outlets>emptyList());
    }

    @Override
    public boolean isOutletsEmpty(String idEvent) {
        return this.outletsModel.getAllOutlets(idEvent).isEmpty();
    }
}
