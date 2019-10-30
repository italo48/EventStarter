package com.br.italoscompany.eventstarterapp.Functionalities.OutletsRegister;

import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;

import java.util.List;

public interface IOutlets {

    interface IView {
        void showToast(String msg);
        void showOutlets(List<Outlets> outletsList);
    }

    interface IPresenter {
        void getOutlets();
        void saveOutlets(Outlets outlets);
        void outletsLinkEvent(int idEvent);
        void setEmptyOutlets(int id);
        boolean isOutletsEmpty();
    }
}
