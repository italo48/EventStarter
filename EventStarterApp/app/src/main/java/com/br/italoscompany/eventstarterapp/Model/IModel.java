package com.br.italoscompany.eventstarterapp.Model;

import com.br.italoscompany.eventstarterapp.Model.entities.Address;
import com.br.italoscompany.eventstarterapp.Model.entities.Event;
import com.br.italoscompany.eventstarterapp.Model.entities.Outlets;
import com.br.italoscompany.eventstarterapp.Model.entities.User;

import java.util.List;

public interface IModel {

    interface IUserModel {
        void saveUser(String name, String email, String picPath, String uuid);
        User findUserById(String id);
        List<User> getAllUsers();
        boolean existsUserByLoginAndPassword(String login, String password);
    }

    interface IEventModel {
        void addEvent(Event e);
        void deleteEvent(String id);
        Event findEventById(String id);
        List<Event> getAllEvents();
    }

    interface IAddressModel {
        void addAddress(Address a);
        void deleteAddress(String id);
        List<Address> getAllAddresses();
    }

    interface IOutletsModel {
        void addOutlets(Outlets o);
        void deleteOutlets(String id);
        List<Outlets> getAllOutlets();
    }
}
