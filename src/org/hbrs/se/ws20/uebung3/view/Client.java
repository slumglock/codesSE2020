package org.hbrs.se.ws20.uebung3.view;

import org.hbrs.se.ws20.uebung3.control.ContainerException;
import org.hbrs.se.ws20.uebung3.control.Member;
import org.hbrs.se.ws20.uebung3.control.defMember;
import org.hbrs.se.ws20.uebung3.control.Container;

public class Client {
    public static void Main(String[] args) {

        Member x = new defMember(1);
        Member y = new defMember(2);
        Member z = new defMember(3);

        Container con = Container.getInstance();


        try {
            con.addMember(x);
            con.addMember(y);
            con.addMember(z);
        } catch (ContainerException e) {
            e.printStackTrace();
        }


    }
    public static void display(Container con) {
        MemberView.dump(con.getCurrentList());

    }



}
