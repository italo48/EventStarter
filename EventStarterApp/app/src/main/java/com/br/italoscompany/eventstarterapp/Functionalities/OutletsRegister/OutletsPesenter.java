package com.br.italoscompany.eventstarterapp.Functionalities.OutletsRegister;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;
import com.google.android.gms.maps.model.LatLng;

import java.util.Collections;

import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbEvent;
import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbOutlets;

public class OutletsPesenter implements IOutlets.IPresenter {

    private IModel.IOutletsModel outletsModel;
    private IModel.IEventModel eventModel;
    private IOutlets.IView iView;

    public OutletsPesenter(IOutlets.IView iView) {
        this.iView = iView;
        this.outletsModel = dbOutlets;
        this.eventModel = dbEvent;
    }

    @Override
    public void getOutlets() {
        iView.showOutlets(this.outletsModel.getAllOutlets());
    }

    @Override
    public void saveOutlets(String nameOutlets, int numTickets, LatLng loc) {
        if (nameOutlets.isEmpty() || numTickets < 0 || loc == null) {
            iView.showToast("Algum campo não foi preenchido");
        } else {
            Outlets o = new Outlets();
            o.setNomeDoEstabelecimento(nameOutlets);
            o.setQtdIngressos(numTickets);
            o.setLocation(loc);

            outletsModel.addOutlets(o);
        }
    }

    @Override
    public void deleteOutlets(String idOutlets) {
        outletsModel.deleteOutlets(idOutlets);
    }

    @Override
    public void outletsLinkEvent(String idEvent) {
        Event e = eventModel.findEventById(idEvent);
        if (!this.outletsModel.getAllOutlets().isEmpty() || this.outletsModel.getAllOutlets() != null) {
            e.setPontosDevendas(this.outletsModel.getAllOutlets());
            iView.showToast("Pontos de ventda cadastrado com sucesso");
        }
    }

    @Override
    public void setEmptyOutlets(String id) {
        eventModel.findEventById(id).setPontosDevendas(Collections.<Outlets>emptyList());
    }

    @Override
    public boolean isOutletsEmpty() {
        return this.outletsModel.getAllOutlets().isEmpty();
    }
}
