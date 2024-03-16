package ru.netology.statistic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    Ticket item1 = new Ticket("Челябинск", "Курск", 3900, 10, 15);
    Ticket item2 = new Ticket("Челябинск", "Москва", 2000, 11, 13);
    Ticket item3 = new Ticket("Челябинск", "Владивосток", 7900, 9, 21);
    Ticket item4 = new Ticket("Москва", "Курск", 1900, 17, 18);
    Ticket item5 = new Ticket("Москва", "Челябинск", 2000, 19, 23);
    Ticket item6 = new Ticket("Москва", "Владивосток", 9900, 8, 23);
    Ticket item7 = new Ticket("Москва", "Челябинск", 2200, 17, 20);
    Ticket item8 = new Ticket("Москва", "Челябинск", 1400, 3, 5);
    AviaSouls aviaSouls = new AviaSouls();

    @Test
    public void shouldReturnMorePrice() {

        int expected = 1;
        int actual = item1.compareTo(item2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnEqualPrice() {

        int expected = 0;
        int actual = item2.compareTo(item5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnLessPrice() {

        int expected = -1;
        int actual = item3.compareTo(item6);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSeveralItems() {

        aviaSouls.add(item1);
        aviaSouls.add(item2);
        aviaSouls.add(item3);
        aviaSouls.add(item4);
        aviaSouls.add(item5);
        aviaSouls.add(item6);
        aviaSouls.add(item7);
        aviaSouls.add(item8);

        Ticket[] actualArray = new Ticket[0];
        actualArray = aviaSouls.search("Москва", "Челябинск");

        AviaSouls expectedaviaSouls = new AviaSouls();
        expectedaviaSouls.add(item8);
        expectedaviaSouls.add(item5);
        expectedaviaSouls.add(item7);

        Ticket[] expectedArray = new Ticket[0];
        expectedArray = expectedaviaSouls.findAll();

        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void shouldReturnOneItem() {

        aviaSouls.add(item1);
        aviaSouls.add(item2);
        aviaSouls.add(item3);
        aviaSouls.add(item4);
        aviaSouls.add(item5);
        aviaSouls.add(item6);
        aviaSouls.add(item7);
        aviaSouls.add(item8);

        Ticket[] actualArray = new Ticket[0];
        actualArray = aviaSouls.search("Москва", "Курск");

        AviaSouls expectedaviaSouls = new AviaSouls();
        expectedaviaSouls.add(item4);

        Ticket[] expectedArray = new Ticket[0];
        expectedArray = expectedaviaSouls.findAll();

        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void shouldReturnZeroItem() {

        aviaSouls.add(item1);
        aviaSouls.add(item2);
        aviaSouls.add(item3);
        aviaSouls.add(item4);
        aviaSouls.add(item5);
        aviaSouls.add(item6);
        aviaSouls.add(item7);
        aviaSouls.add(item8);

        Ticket[] actualArray = new Ticket[0];
        actualArray = aviaSouls.search("Курск", "Владивосток");

        AviaSouls expectedaviaSouls = new AviaSouls();

        Ticket[] expectedArray = new Ticket[0];
        expectedArray = expectedaviaSouls.findAll();

        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void shouldReturnMoreByComparator() {

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        int actual = ticketTimeComparator.compare(item1, item4);
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnEqualByComparator() {

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        int actual = ticketTimeComparator.compare(item2, item8);
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnLessByComparator() {

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        int actual = ticketTimeComparator.compare(item8, item6);
        int expected = -1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSeveralItemsByComporator() {

        aviaSouls.add(item1);
        aviaSouls.add(item2);
        aviaSouls.add(item3);
        aviaSouls.add(item4);
        aviaSouls.add(item5);
        aviaSouls.add(item6);
        aviaSouls.add(item7);
        aviaSouls.add(item8);

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket[] actualArray = new Ticket[0];
        actualArray = aviaSouls.searchAndSortBy("Москва", "Челябинск", ticketTimeComparator);

        AviaSouls expectedaviaSouls = new AviaSouls();
        expectedaviaSouls.add(item8);
        expectedaviaSouls.add(item7);
        expectedaviaSouls.add(item5);

        Ticket[] expectedArray = new Ticket[0];
        expectedArray = expectedaviaSouls.findAll();

        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void shouldReturnOneItemByComporator() {

        aviaSouls.add(item1);
        aviaSouls.add(item2);
        aviaSouls.add(item3);
        aviaSouls.add(item4);
        aviaSouls.add(item5);
        aviaSouls.add(item6);
        aviaSouls.add(item7);
        aviaSouls.add(item8);

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket[] actualArray = new Ticket[0];
        actualArray = aviaSouls.searchAndSortBy("Челябинск", "Владивосток", ticketTimeComparator);

        AviaSouls expectedaviaSouls = new AviaSouls();
        expectedaviaSouls.add(item3);

        Ticket[] expectedArray = new Ticket[0];
        expectedArray = expectedaviaSouls.findAll();

        Assertions.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void shouldReturnZeroItemsByComporator() {

        aviaSouls.add(item1);
        aviaSouls.add(item2);
        aviaSouls.add(item3);
        aviaSouls.add(item4);
        aviaSouls.add(item5);
        aviaSouls.add(item6);
        aviaSouls.add(item7);
        aviaSouls.add(item8);

        TicketTimeComparator ticketTimeComparator = new TicketTimeComparator();

        Ticket[] actualArray = new Ticket[0];
        actualArray = aviaSouls.searchAndSortBy("Уральск", "Владивосток", ticketTimeComparator);

        AviaSouls expectedaviaSouls = new AviaSouls();

        Ticket[] expectedArray = new Ticket[0];
        expectedArray = expectedaviaSouls.findAll();

        Assertions.assertArrayEquals(expectedArray, actualArray);
    }
}
