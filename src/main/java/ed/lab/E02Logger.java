/*Diseñe un sistema de registro que reciba una stream de mensajes junto a sus tiempos de publicación. Cada mensaje único debe imprimirse solamente una vez cada 10 segundos. Es decir, un mensaje que se imprimió en el tiempo t no debe ser impreso hasta que se cumpla el tiempo t+10.

Todos los mensajes ingresarán en orden cronológico. Varios mensajes pueden llegar durante el mismo instante de tiempo.

Implemente la clase E02Logger:

Logger() Instancia el objeto de logger (registro).
bool shouldPrintMessage(int timestamp, string message) retorna true si el mensaje message debería imprimirse en el instante de tiempo timestamp dado, de lo contrario retorna false.
Ejemplo 2.1:
E02Logger logger = new E02Logger();
logger.shouldPrintMessage(1, "foo");  // retorna true, el siguiente instante de tiempo en que se puede volver a imprimir "foo" es 1 + 10 = 11
logger.shouldPrintMessage(2, "bar");  // retorna true, el siguiente instante de tiempo para "bar" is 2 + 10 = 12
logger.shouldPrintMessage(3, "foo");  // 3 < 11, retorna false
logger.shouldPrintMessage(8, "bar");  // 8 < 12, retorna false
logger.shouldPrintMessage(10, "foo"); // 10 < 11, retorna false
logger.shouldPrintMessage(11, "foo"); // 11 >= 11, retorna true, el siguiente instante de tiempo para "foo" is 11 + 10 = 21
*/
package ed.lab;
import java.util.HashMap;


public class E02Logger {
    HashMap<String, Integer> map;

    public E02Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp);
            return true;
        }

        if (timestamp - map.get(message) >= 10) {
            map.put(message, timestamp);
            return true;
        }

        return false;
    }

}



































