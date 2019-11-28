package com.br.italoscompany.eventstarterapp.Functionalities.OutletsRegister;

import com.br.italoscompany.eventstarterapp.Model.entities.MyLatLong;
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
        void saveOutlets(String idEvent, String nameOutlets, int numTickets, MyLatLong loc);
        void deleteOutlets(String idOutlets);
        void outletsLinkEvent(String idEvent);
        void setEmptyOutlets(String id);
        boolean isOutletsEmpty();

    }
}
