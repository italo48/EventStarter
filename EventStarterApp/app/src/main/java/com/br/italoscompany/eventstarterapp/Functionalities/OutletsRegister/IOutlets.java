package com.br.italoscompany.eventstarterapp.Functionalities.OutletsRegister;

import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public interface IOutlets {

    interface IView {
        void showToast(String msg);
        void showOutlets(List<Outlets> outletsList);
    }

    interface IPresenter {
        void getOutlets();
        void saveOutlets(String nameOutlets, int numTickets, LatLng loc);
        void deleteOutlets(int idOutlets);
        void outletsLinkEvent(int idEvent);
        void setEmptyOutlets(int id);
        boolean isOutletsEmpty();

    }
}
