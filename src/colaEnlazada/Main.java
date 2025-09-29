package colaEnlazada;

import java.util.Scanner;

public class Main {

    private static int leerOpcion(Scanner sc) {
        while (true) {
            System.out.print("Seleccione una opción: ");
            String s = sc.nextLine().trim();
            try {
                int op = Integer.parseInt(s);
                if (op < 1 || op > 10) {
                    System.out.println("Opcion invalida. Por favor, digite un numero entre 1 y 10.");
                } else {
                    return op;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, digite un número entero.");
            }
        }
    }

    private static Object parsearDato(String texto) {
        String t = texto.trim();
        if (t.equalsIgnoreCase("true") || t.equalsIgnoreCase("false")) {
            return Boolean.parseBoolean(t);
        }
        if (t.matches("[-+]?\\d+")) {
            try { return Integer.parseInt(t); } catch (NumberFormatException ignored) {}
        }
        return texto;
    }

    private static void pausar(Scanner sc) {
        System.out.print("\nPresione Enter para continuar...");
        sc.nextLine();
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cola<Object> cola = new Cola<>();

        int opc;
        do {
            System.out.println("MENU");
            System.out.println("1. Insertar elemento.");
            System.out.println("2. Extraer elemento. Se elimina de la cola.");
            System.out.println("3. Obtener el primer elemento de la cola (sin extraer).");
            System.out.println("4. Obtener el último elemento de la cola (sin extraer).");
            System.out.println("5. Obtener el elemento de la cola en la posición indicada (1 = primero).");
            System.out.println("6. ¿La cola está vacia? (SI/NO).");
            System.out.println("7. Tamaño actual de la cola.");
            System.out.println("8. Mostrar todos los elementos de la cola (formato visual).");
            System.out.println("9. Vaciar cola.");
            System.out.println("10. Terminar.");
            opc = leerOpcion(sc);

            switch (opc) {
                case 1: // Insertar elemento
                    System.out.print("Ingrese el elemento a insertar: ");
                    Object valor = parsearDato(sc.nextLine());
                    cola.insertar(valor);
                    System.out.println("Elemento insertado correctamente.");
                    pausar(sc);
                    break;

                case 2: // Extraer elemento. Se elimina de la cola.
                    Object extraido = cola.extraer();
                    if (extraido == null) {
                        System.out.println("La cola esta vacia, no es posible extraer.");
                    } else {
                        System.out.println("Elemento extraido: " + extraido);
                    }
                    pausar(sc);
                    break;

                case 3: // Obtener el primer elemento de la cola. Se muestra su valor, sin extraerlo.
                            Object primero = cola.obtenerPrimero();
                    if (primero == null) {
                        System.out.println("La cola esta vacia.");
                    } else {
                        System.out.println("Primer elemento (sin extraer): " + primero);
                    }
                    pausar(sc);
                    break;

                    //demas funciones AQUI
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    break;

                case 10:
                    System.out.println("Gracias por utilizar el sistema, vuelva pronto");
                    break;

                default:
                    System.out.println("Opcion no reconocida.");
                    pausar(sc);
            }

        } while (opc != 10);

        sc.close();
    }
}
