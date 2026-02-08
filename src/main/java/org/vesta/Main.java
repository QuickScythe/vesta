package org.vesta;

import com.quiptmc2.core.Quipt;
import org.vesta.core.Vesta;

public class Main {

    public static void main(String[] args) {
        Quipt quipt = Quipt.INSTANCE;
        quipt.enable(Vesta.INSTANCE);
        System.out.println("Vesta is now running!");
    }
}
