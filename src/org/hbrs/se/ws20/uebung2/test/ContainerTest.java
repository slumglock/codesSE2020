package org.hbrs.se.ws20.uebung2.test;


import static org.junit.jupiter.api.Assertions.*;

import org.hbrs.se.ws20.uebung2.Member;
import org.hbrs.se.ws20.uebung2.control.Container;
import org.hbrs.se.ws20.uebung2.control.ContainerException;
import org.hbrs.se.ws20.uebung2.control.defMember;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ContainerTest {
    private Member x = null;
    private Member y = null;
    private Member z = null;
    private Member m = null;
    private Container con = null;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setup() {

        x = new defMember(1);
        y = new defMember(2);
        z = new defMember(3);
        m = new defMember(3);
        con = new Container();

        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void teardown() {

        x = null;
        y = null;
        z = null;
        m = null;
        con = null;

        System.setOut(originalOut);

    }

    @Test
    void testContainer() throws ContainerException {

        // Test von size() und addMember()
        assertEquals(con.size(), 0, "Fehler neuer Container sollte leer (0) sein");

        con.addMember(x);
        con.addMember(y);
        con.addMember(z);
        assertEquals(con.size(), 3, "Size sollte nach Hinzufügen 3 sein");

        //Test deletemember() und size()
        con.deleteMember(2);
        con.deleteMember(3);
        assertEquals(con.size(), 1, "Size sollte nach löschen von 2 Membern 1 sein.");


        assertEquals(con.deleteMember(4), "Kein Member mit der ID ( 4 ) ist in der Liste enthalten.", "Sollte nicht möglich sein");

    }
    @Test
    // Test von Duplikat
    void testDuplikat() throws ContainerException {
        con.addMember(z);
        assertThrows(ContainerException.class, () -> con.addMember(m), "Member mit ID 3 bereits vorhanden.");

    }

    @Test
    // Test von dump
    void testDump() throws ContainerException {

        con.addMember(x);
        con.addMember(y);
        con.addMember(z);

        con.dump();
        assertEquals("Alle IDs der aktuell gespeicherten Obejkte im Container:\nMember (ID =1)\nMember (ID =2)\nMember (ID =3)\n", outContent.toString(), "Ausgabe dump Methode ist falsch");

    }

}
