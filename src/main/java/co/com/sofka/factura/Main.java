package co.com.sofka.factura;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Factura f = new Factura(1,"ordenador", 1000, 3, new Date(122,05,16));
        Factura f2 = new Factura(2,"movil", 300, 6, new Date(121,03,16));
        Factura f3 = new Factura(3,"impresora", 200, 1, new Date(122,06,16));
        Factura f4 = new Factura(4,"imac", 15000, 5, new Date(121,03,16));

        List<Factura> lista = new ArrayList<Factura>();

        lista.add(f);
        lista.add(f2);
        lista.add(f3);
        lista.add(f4);

        Predicate<Factura> predicado = new Predicate<Factura>() {
            @Override
            public boolean test(Factura t) {
                System.out.println("iteracion ");
                return t.getPrecio() > 300;
            }
        };

        Factura facturaFiltro =
                lista.stream()
                    .filter(predicado)
                    .findFirst().get();
        System.out.println("FACTURA UNICA " + facturaFiltro.getPrecio() +"|"+ facturaFiltro.getDescripcion());

        Predicate<Factura> predicadoMayorFecha = new Predicate<Factura>() {
            @Override
            public boolean test(Factura factura) {
                return factura.getFecha().after(new Date(122,03,16));
            }
        };

        List<Factura> facturaFiltroFechaMayor =
                lista.stream()
                        .filter(predicadoMayorFecha)
                        .collect(Collectors.toList());
        System.out.println("FACTURA FECHA MAYOR " + facturaFiltroFechaMayor.toString());

        Predicate<Factura> predicadoMenorFecha = new Predicate<Factura>() {
            @Override
            public boolean test(Factura factura) {
                return factura.getFecha().before(new Date(122,03,16));
            }
        };

        List<Factura> facturaFiltroFechaMenor =
                lista.stream()
                        .filter(predicadoMenorFecha)
                        .collect(Collectors.toList());
        System.out.println("FACTURA FECHA MENOR" + facturaFiltroFechaMenor.toString());


        Predicate<Factura> predicadoCantidadMayor = new Predicate<Factura>() {
            @Override
            public boolean test(Factura factura) {
                return factura.getCantidadProducto() > 5;
            }
        };

        List<Factura> facturaCantidadMayor =
                lista.stream()
                        .filter(predicadoCantidadMayor)
                        .collect(Collectors.toList());
        System.out.println("FACTURA CANTIDAD MAYOR" + facturaCantidadMayor.toString());


        Predicate<Factura> predicadoCantidadMenor = new Predicate<Factura>() {
            @Override
            public boolean test(Factura factura) {
                return factura.getCantidadProducto() < 5;
            }
        };

        List<Factura> facturaCantidadMenor =
                lista.stream()
                        .filter(predicadoCantidadMenor)
                        .collect(Collectors.toList());
        System.out.println("FACTURA CANTIDAD MENOR" + facturaCantidadMenor.toString());

        Predicate<Factura> predicadoCantidadIgual = new Predicate<Factura>() {
            @Override
            public boolean test(Factura factura) {
                return factura.getCantidadProducto() == 5;
            }
        };

        List<Factura> facturaCantidadIgual =
                lista.stream()
                        .filter(predicadoCantidadIgual)
                        .collect(Collectors.toList());
        System.out.println("FACTURA CANTIDAD IGUAL" + facturaCantidadIgual.toString());



    }
}
