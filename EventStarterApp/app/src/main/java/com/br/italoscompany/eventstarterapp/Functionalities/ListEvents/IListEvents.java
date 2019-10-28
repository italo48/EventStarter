package com.br.italoscompany.eventstarterapp.Functionalities.ListEvents;

import android.content.Context;
import android.widget.SearchView;

import com.br.italoscompany.eventstarterapp.Model.entities.Event;

import java.util.List;

public interface IListEvents {

    interface IView extends SearchView.OnQueryTextListener {
        void showToast(String msg);
        void showListEventAdapter(List<Event> events);
    }

    interface IPresenter {
        void showDetails(int id);
        void searchEvent(String nameEvent);
        void showEvents();
        void onDestroy();
    }
}
