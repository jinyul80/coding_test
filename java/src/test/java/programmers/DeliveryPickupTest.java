package programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeliveryPickupTest {

    DeliveryPickup deliveryPickup = new DeliveryPickup();

    @Test
    void test1() {
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};

        long result = deliveryPickup.solution(cap, n, deliveries, pickups);

        assertEquals(result, 16);
    }

    @Test
    void test2() {
        int cap = 2;
        int n = 7;
        int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
        int[] pickups = {0, 2, 0, 1, 0, 2, 0};

        long result = deliveryPickup.solution(cap, n, deliveries, pickups);

        assertEquals(result, 30);
    }
}