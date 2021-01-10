package ui;

import domein.Zoo;
import domein.ZooServer;

public class ApplicatieZooServer {

    public static void main(String[] args) {
        new ZooServer(new Zoo()).run();
    }

}
