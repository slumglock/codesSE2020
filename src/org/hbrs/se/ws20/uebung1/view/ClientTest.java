package org.hbrs.se.ws20.uebung1.view;

public class ClientTest {
    private static Client client = null;

    public ClientTest() {
        client = new Client();
    }

    public static void test() {
        // Positivtests
        client.display( 1 );

        // Negativtests
        client.display ( 11 );
        client.display ( -1 );
        client.display ( 0 );
    }

    public static void main(String[] args) {
        ClientTest cs = new ClientTest();
        ClientTest.test();
    }
}
