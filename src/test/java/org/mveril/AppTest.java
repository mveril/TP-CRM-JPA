package org.mveril;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mveril.dao.DAOFactory;
import org.mveril.entity.Customer;
import org.mveril.entity.Order;
import org.mveril.enumeration.ClientState;
import org.mveril.enumeration.OrderSate;

import java.io.Console;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void Create()
    {
        //Customer timCook = new Customer("Apple","Tim","Cook","Tim.cook@apple.com",
        //        "0606060606","Apple Park","?","Etat-Unis","Cupertino", ClientState.ACTIVE);
        var timCook= DAOFactory.getCustomerDAO().findById(5);
        Order switLeader = new Order(timCook,"Formation","Swift Leader",10,500, OrderSate.CONFIRMED);
        DAOFactory.getOrderDAO().create(switLeader);
        assertTrue(true);
    }

    @Test
    public void ListClient(){
        System.out.println(DAOFactory.getCustomerDAO().findAll());
    }

    @Test
    public void ListOder(){
        System.out.println(DAOFactory.getOrderDAO().findAll());
    }
}
