package org.hbrs.se.ws20.uebung3.control;

import org.hbrs.se.ws20.uebung3.control.Member;

public class defMember implements Member {

    private Integer id;

    public defMember(Integer id){
        this.id = id;
    }

    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public String toString(){

        return "Member (ID =" + id + ")\n";
    }
}
