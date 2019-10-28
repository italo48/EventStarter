package com.br.italoscompany.eventstarterapp.Model.data;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.Address;

import java.util.List;

public class AddressDBMemory implements IModel.IAddressModel {
    @Override
    public void addAddress(Address a) {

    }

    @Override
    public void deleteAddress(long id) {

    }

    @Override
    public List<Address> getAllAddresses() {
        return null;
    }
}
