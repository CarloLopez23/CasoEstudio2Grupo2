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

    private static int leerPosicion(Scanner sc, int tamActual) {
        while (true) {
            System.out.print("Ingrese la posición (1 = primero, max = " + tamActual + "): ");
            String s = sc.nextLine().trim();
            try {
                int pos = Integer.parseInt(s);
                if (pos < 1 || pos > tamActual) {
                    System.out.println("Posición inválida. Debe estar entre 1 y " + tamActual + ".");
                } else {
                    return pos;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor, digite un número entero.");
            }
        }
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

                case 2: // Extraer elemento
                    Object extraido = cola.extraer();
                    if (extraido == null) {
                        System.out.println("La cola esta vacia, no es posible extraer.");
                    } else {
                        System.out.println("Elemento extraido: " + extraido);
                    }
                    pausar(sc);
                    break;

                case 3: // Obtener primero
                    Object primero = cola.obtenerPrimero();
                    if (primero == null) {
                        System.out.println("La cola esta vacia.");
                    } else {
                        System.out.println("Primer elemento (sin extraer): " + primero);
                    }
                    pausar(sc);
                    break;

                case 4: // Obtener último
                    Object ultimo = cola.obtenerUltimo();
                    if (ultimo == null) {
                        System.out.println("La cola esta vacia.");
                    } else {
                        System.out.println("Ultimo elemento (sin extraer): " + ultimo);
                    }
                    pausar(sc);
                    break;

                case 5: // Obtener por posición
                    if (cola.estaVacia()) {
                        System.out.println("La cola esta vacia.");
                        pausar(sc);
                        break;
                    }
                    int pos = leerPosicion(sc, cola.tamanio());
                    Object enPos = cola.obtenerEnPosicion1Base(pos);
                    if (enPos == null) {
                        System.out.println("No existe elemento en esa posicion.");
                    } else {
                        System.out.println("Elemento en la posicion " + pos + " (sin extraer): " + enPos);
                    }
                    pausar(sc);
                    break;

                case 6: // ¿Está vacía?
                    System.out.println(cola.estaVacia() ? "SI" : "NO");
                    pausar(sc);
                    break;

                case 7: // Tamaño
                    System.out.println("Tamaño actual de la cola: " + cola.tamanio());
                    pausar(sc);
                    break;

                case 8: // Mostrar cola
                    if (cola.estaVacia()) {
                        System.out.println("La cola esta vacia.");
                    } else {
                        System.out.println("Cola: " + cola.formatoVisual());
                    }
                    pausar(sc);
                    break;

                case 9: // Vaciar
                    cola.vaciar();
                    System.out.println("La cola ha sido vaciada.");
                    pausar(sc);
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
