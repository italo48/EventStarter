package com.br.italoscompany.eventstarterapp.Functionalities.EventRegister;

import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public interface IEventRegister {

    interface IView {
        void showToast(String msg);
        void goOutletsActivity(int idEvent);
    }

    interface IPresenter {
        void saveEvent(String name, String date, LatLng loc, List<Outlets> outletsList);
        void addIdGoOutletsActivit();
    }
}
