package com.br.italoscompany.eventstarterapp.Functionalities.EventRegister;

import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.MyLatLong;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;

import java.util.List;

public interface IEventRegister {

    interface IView {
        void showToast(String msg);

        void goOutletsActivity(String idEvent);

        void editEvent(String name, String dt);
    }

    interface IPresenter {
        void saveEvent(String name, String date, MyLatLong loc, List<Outlets> outletsList, String idCreator);

        void addIdGoOutletsActivit();

        void editEvent(String eventName);
    }
}
