package org.vesta.test;

import org.junit.jupiter.api.Test;
import org.vesta.Main;
import org.vesta.core.Vesta;
import org.vesta.core.clients.Client;
import org.vesta.core.clients.Clients;
import org.vesta.core.clients.reports.Report;

public class ClientTests {

    @Test
    public void createClient() {
        Main.main(new String[0]);
        Clients clients = Vesta.INSTANCE.clients();
//        Client test = clients.get("TEST");
        Client test = new Client(Vesta.INSTANCE, "test-client", "TEST");
        clients.register(test);
        Report[] reports = test.reports().get(test.reports().date(1771151732227L));
        for (Report report : reports) {
            System.out.println("Report found: " + report.id().toString());
        }
        clients.save();
    }

    @Test
    public void createReport(){
        Main.main(new String[0]);
        Clients clients = Vesta.INSTANCE.clients();
        Client test = clients.get("TEST");
        Report report = test.reports().create(test.reports().date(1771151732227L));
        report.save();
    }

    @Test
    public void readClient() {
        Main.main(new String[0]);
        Clients clients = Vesta.INSTANCE.clients();
        Client test = clients.get("TEST");
        Report[] reports = test.reports().get(test.reports().date(1771151732227L));
        for (Report report : reports) {
            System.out.println("Report found: " + report.id().toString());
        }
    }
}
