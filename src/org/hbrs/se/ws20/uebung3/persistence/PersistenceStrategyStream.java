package org.hbrs.se.ws20.uebung3.persistence;


import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<Member> implements PersistenceStrategy<Member> {

    FileOutputStream fos = null;
    ObjectOutputStream oos = null;
    FileInputStream fis = null;
    ObjectInputStream ois = null;

    String file = "file.txt";






    @Override
    public void openConnection() throws PersistenceException {
        try {
            fos = new FileOutputStream("file.txt", false);
            oos = new ObjectOutputStream(fos);

        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() throws PersistenceException {
        try {
            fos.close();
            oos.close();
            fis.close();
            ois.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    /**
     * Method for saving a list of Member-objects to a disk (HDD)
     */
    public void save(List<Member> member) throws PersistenceException  {
        openConnection();
        try {
            oos.writeObject(member);
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            closeConnection();

        }

    }

    @Override
    /**
     * Method for loading a list of Member-objects from a disk (HDD)
     * Some coding examples come for free :-)
     */
    public List<Member> load() throws PersistenceException  {
        // Some Coding hints ;-)
        // ObjectInputStream ois = null;
        // FileInputStream fis = null;
        // List<...> newListe =  null;
        //
        openConnection();

        List<Member> newListe = null;


        try {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                newListe = (List) obj;
            }
            return newListe;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }



        closeConnection();
        return null;
    }
}