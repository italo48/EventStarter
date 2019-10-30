package com.br.italoscompany.eventstarterapp.Model.data;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;

import java.util.ArrayList;
import java.util.List;

public class OutletsDBMemory implements IModel.IOutletsModel {
    private List<Outlets> outlets = new ArrayList<>();
    @Override
    public void addOutlets(Outlets o) {
        this.outlets.add(o);
    }

    @Override
    public void deleteOutlets(int id) {
        this.outlets.remove(id);
    }

    @Override
    public List<Outlets> getAllOutlets() {
        return outlets;
    }
}
