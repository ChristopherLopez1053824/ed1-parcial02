/*
Dada una lista de intervalos meetingIntervals, retorne la cantidad mínima de salas de conferencias necesarias.

Ejemplo 1.1:
Entrada: meetingIntervals = [ [0-30], [5-10], [15-20] ]
Salida: 2
Ejemplo 1.2:
Entrada: meetingIntervals = [ [7-10], [2-4] ]
Salida: 1
 */
package ed.lab;
import java.util.List;
import java.util.PriorityQueue;

public class E01MeetingRooms {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->{
        if(a==b) return 0;
        if(a>b) return 1;
        return -1;
    });

    public int minMeetingRooms(List<MeetingInterval> meetingIntervals) {
        if (meetingIntervals == null || meetingIntervals.isEmpty()) return 0;
        meetingIntervals.sort((a, b) -> Integer.compare(a.startTime(), b.startTime()));

        for (MeetingInterval interval : meetingIntervals) {
            if (!minHeap.isEmpty() && interval.startTime() >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(interval.endTime());
        }

        return minHeap.size();
    }
}











































