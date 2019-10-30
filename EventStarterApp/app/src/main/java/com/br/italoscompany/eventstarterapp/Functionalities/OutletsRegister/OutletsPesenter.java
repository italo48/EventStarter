package com.br.italoscompany.eventstarterapp.Functionalities.OutletsRegister;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbEvent;
import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbOutlets;

public class OutletsPesenter implements IOutlets.IPresenter {

    private IModel.IOutletsModel outletsModel;
    private IModel.IEventModel eventModel;
    private IOutlets.IView iView;
    private List<Outlets> outletsList = new ArrayList<>();

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
    public void saveOutlets(Outlets outlets) {
        outletsModel.addOutlets(outlets);
    }

    @Override
    public void deleteOutlets(int idOutlets) {
        outletsModel.deleteOutlets(idOutlets);
    }

    @Override
    public void outletsLinkEvent(int idEvent) {
        Event e = eventModel.findEventById(idEvent);
        e.setPontosDevendas(this.outletsModel.getAllOutlets());
        iView.showToast("Ponto de ventda cadastrado com sucesso");
    }

    @Override
    public void setEmptyOutlets(int id) {
        eventModel.findEventById(id).setPontosDevendas(Collections.<Outlets>emptyList());
    }

    @Override
    public boolean isOutletsEmpty() {
        return this.outletsModel.getAllOutlets().isEmpty();
    }
}
