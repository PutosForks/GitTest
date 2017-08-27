package com.app.control;


import com.app.dao.AddressDAO;
import com.app.dao.ClientDAO;
import com.app.dao.SkillDAO;
import com.app.daoUtils.DAOFactory;
import com.app.dao.ClientDetailDAO;
import com.app.model.Client;
import com.app.model.Skill;
import com.app.model.Address;
import com.app.model.ClientDetail;
import java.util.HashSet;
import java.util.Set;
import static com.app.daoUtils.DAOFactory.getFactory;

public class TestDAO1 {

    public static void main(String[] args) {
        DAOFactory factory = getFactory();
        ClientDAO clientDAO = factory.getClientDAO();
        factory.getClientDAO().beginTransaction();

        ClientDetailDAO clientDetailDAO = factory.getClientDetailDAO();
        AddressDAO addressDAO = factory.getAddressDAO();
        SkillDAO skillDAO = factory.getSkillDAO();

        Client client = new Client();
        client.setUserName("MrazkovaM");
        client.setVerified(Boolean.TRUE);
        client.setPassword("hmhmhm");

        ClientDetail clientDetail = new ClientDetail();
        clientDetail.setEmailAddress("monika@gmail.com");
        clientDetail.setFirstName("Monika");
        clientDetail.setLastName("Mrazkova");
        clientDetail.setClient(client);

        Address address1 = new Address();
        address1.setAddressLine1("Hermelinska 4");
        address1.setCity("Prague");
        address1.setCode("160 00");
        address1.setClient(client);

        Address address2 = new Address();
        address2.setAddressLine1("Na Belidle 6");
        address2.setCity("Prague");
        address2.setCode("150 00");
        address2.setClient(client);

        Skill skill1 = new Skill();
        skill1.setName("knitting");

        Skill skill2 = new Skill();
        skill2.setName("sewing");

        Set<Client> clients = new HashSet<>();
        clients.add(client);

        skill1.setClients(clients);
        skill2.setClients(clients);

        client.setClientDetail(clientDetail);
        client.getAddress().add(address1);
        client.getAddress().add(address2);
        client.getSkills().add(skill1);
        client.getSkills().add(skill2);

        clientDAO.save(client);
        clientDetailDAO.save(clientDetail);
        addressDAO.save(address1);
        addressDAO.save(address2);
        skillDAO.save(skill1);
        skillDAO.save(skill2);

        factory.getClientDAO().commitTransaction();

    }

}
