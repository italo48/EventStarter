package com.br.italoscompany.eventstarterapp.Model;

import com.br.italoscompany.eventstarterapp.Model.entities.Address;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;
import com.br.italoscompany.eventstarterapp.Model.entities.User;

import java.util.List;

public interface IModel {

    interface IUserModel {
        void saveUser(User u);
        User findUserById(long id);
        List<User> getAllUsers();
        boolean existsUserByLoginAndPassword(String login, String password);
    }

    interface IEventModel {
        void addEvent(Event e);
        void deleteEvent(long id);
        List<Event> getAllEvents();
    }

    interface IAddressModel {
        void addAddress(Address a);
        void deleteAddress(long id);
        List<Address> getAllAddresses();
    }

    interface IOutletsModel {
        void addOutlets(Outlets o);
        void deleteOutlets(int id);
        List<Outlets> getAllOutlets();
    }
}
