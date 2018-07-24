package br.com.lucashenrique.arduinoreader.arduinoreader.controller;

import br.com.lucashenrique.arduinoreader.arduinoreader.PortControl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class MainController implements PortControl.PortControlListener {


    @RequestMapping("/")
    public String checkServerStatus() {

        return "Servidor funcionando";
    }

    @RequestMapping("/startArduino")
    public String startArduino() {
        PortControl portControl = new PortControl(this);
        portControl.initialize();
        return "Arduino inicializado com sucesso";
    }

    @Override
    public void onDataReaded(String arduinoData) {
        System.out.println(arduinoData);
    }
}
