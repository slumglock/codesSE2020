package org.hbrs.se.ws20.uebung2.control;


import org.hbrs.se.ws20.uebung2.Member;
import java.util.ArrayList;
import java.util.List;

public class Container {

    public List<Member> aList = new ArrayList<>();

    public void addMember(Member member) throws ContainerException{


        if (contains(member)){
            ContainerException exception = new ContainerException();
            exception.setExceptionID(member.getID());
            throw exception;

        }
        aList.add(member);

    }

    public boolean contains(Member member){
        Integer id = member.getID();
        for(Member x : aList) {
            if(member.getID().equals(x.getID())){
                return true;
            }
        }
        return false;

    }


    public String deleteMember(Integer id) {
        Member x = getMember(id);
        if (x == null) {
            return "Kein Member mit der ID (" + id + ") ist in der Liste enthalten.";

        } else {
            aList.remove(x);
            return "Der Member mit der ID (" + id + ") wurde erfolgreich gelöscht.";
        }
    }





    private Member getMember(Integer id) {
        for(Member x:aList){
            if(id.equals(x.getID())){
                return x;
            }
        }
        return null;


    }

    public void dump(){
        System.out.print("Alle IDs der aktuell gespeicherten Obejkte im Container:\n");
        for(Member x:aList){
            System.out.print(x.toString());
        }
    }

    public int size(){

        return aList.size();

    }

}