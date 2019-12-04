package com.br.italoscompany.eventstarterapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.br.italoscompany.eventstarterapp.Functionalities.UserPerfil.IUserPerfil;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.R;

import java.util.List;

public class EventListUserAdapter extends RecyclerView.Adapter<EventListUserAdapter.EventViewHolder> {
    private IUserPerfil.IPresenter presenter;

    private List<Event> eventList;

    public EventListUserAdapter(IUserPerfil.IPresenter presenter) {
        this.presenter = presenter;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_user_event, viewGroup, false);
        EventViewHolder evh = new EventViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(EventViewHolder eventListViewHolder, final int i) {
        eventListViewHolder.nameEvent.setText(eventList.get(i).getNomeDoEvento());
        eventListViewHolder.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.showOptions(i);
                notifyItemChanged(i);
            }
        });
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        CardView crd;
        TextView nameEvent;
        ImageView btnDel;

        EventViewHolder(View itemView) {
            super(itemView);
            crd = (CardView) itemView.findViewById(R.id.crd);
            nameEvent = (TextView) itemView.findViewById(R.id.name_event);
            btnDel = (ImageView) itemView.findViewById(R.id.btnDel);
        }
    }
}
