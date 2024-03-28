package com.julian.taller.punto1.app;

import com.julian.taller.punto1.dominio.agenda;
import com.julian.taller.punto1.dominio.contacto;

import java.util.List;

public class appAgenda {
    public static void main(String[] args) {
        agenda agenda = new agenda();

        agenda.crearContacto("Pablo", "perez", 30000);
        agenda.crearContacto("Angie", "Pardo", 31000);
        agenda.crearContacto("Pablo", "Alboran", 32000);
        agenda.crearContacto("Javier", "Ibarra", 33000);
        agenda.crearContacto("CaRiTo", "PeReZ", 34000);

        agenda.cambiarCelular(33000, 33333);
        contacto buscado = agenda.buscar(33333);
        System.out.println("Por celular: " + buscado.getNombre());

        List<contacto> buscados = agenda.buscarPorApellido("Pardo");

        buscados.forEach(c -> System.out.println(c.getNombre() + " " + c.getApellido()));

        System.out.println(agenda.getNumeroDeContactos());
    }
}