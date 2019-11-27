package com.br.italoscompany.eventstarterapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.br.italoscompany.eventstarterapp.Functionalities.UserDashboard.IUserDashboard;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.R;

import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventViewHolder> {
    private IUserDashboard.IPresenter presenter;

    private List<Event> eventList;

    public EventListAdapter(IUserDashboard.IPresenter presenter) {
        this.presenter = presenter;
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {
        CardView crd;
        TextView nameEvent;
        Button btnDetails;
        EventViewHolder(View itemView) {
            super(itemView);
            crd = (CardView) itemView.findViewById(R.id.crd);
            nameEvent = (TextView) itemView.findViewById(R.id.name_event);
            btnDetails = (Button) itemView.findViewById(R.id.btnDetails);
        }
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
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_event_card_view, viewGroup, false);
        EventViewHolder evh = new EventViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(EventViewHolder eventListViewHolder, final int i) {
        eventListViewHolder.nameEvent.setText(eventList.get(i).getNomeDoEvento());
        eventListViewHolder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.showDetails(i);
                notifyItemChanged(i);
            }
        });
    }


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
