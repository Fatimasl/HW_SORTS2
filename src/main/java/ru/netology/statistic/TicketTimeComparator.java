package ru.netology.statistic;
import java.util.Comparator;
public class TicketTimeComparator implements Comparator<Ticket>{
    @Override
    public int compare(Ticket t1, Ticket t2) {
        int periodOfFlight1 = t1.getTimeTo() - t1.getTimeFrom();
        int periodOfFlight2 = t2.getTimeTo() - t2.getTimeFrom();

        if (periodOfFlight1 < periodOfFlight2) {
            return -1;
        } else if (periodOfFlight1 > periodOfFlight2) {
            return 1;
        } else {
            return 0;
        }
    }
}
