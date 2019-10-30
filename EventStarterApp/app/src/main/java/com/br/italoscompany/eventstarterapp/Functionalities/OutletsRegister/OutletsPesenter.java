package com.br.italoscompany.eventstarterapp.Functionalities.OutletsRegister;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;

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
    public void saveOutlets(Outlets outlets) {
        outletsModel.addOutlets(outlets);
    }

    @Override
    public void outletsLinkEvent(int idEvent) {
        eventModel.findEventById(idEvent).setPontosDevendas(this.outletsModel.getAllOutlets());
    }


}
