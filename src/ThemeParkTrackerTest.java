import static org.junit.jupiter.api.Assertions.*;
class ThemeParkTrackerTest {
    private void assertArrayEquals(Ride result, Ride ride) {
        if(!result.equals(ride)){
            fail("They are not equal");
        }
    }
    @org.junit.jupiter.api.Test
    void addRide() {
        ThemeParkTracker track = new ThemeParkTracker();
        Ride result = new Ride("Zero",30, 10, "open");
        Ride result2 = new Ride("Waow",10, 3, "open");
        Ride result3 = new Ride("Big Terry",53, 25, "open");
        track.addRide(result);
        track.addRide(result2);
        track.addRide(result3);

        assertArrayEquals(result, track.getRide(0));
        assertArrayEquals(result2, track.getRide(1));
        assertArrayEquals(result3, track.getRide(2));
    }

    @org.junit.jupiter.api.Test
    void getRide() {
        ThemeParkTracker track = new ThemeParkTracker();
        Ride result = new Ride("Zero",30, 10, "open");
        Ride result2 = new Ride("Waow",10, 3, "open");
        Ride result3 = new Ride("Big Terry",53, 25, "open");
        track.addRide(result);
        track.addRide(result2);
        track.addRide(result3);

        Ride actual = track.getRide(0);
        Ride actual2 = track.getRide(1);
        Ride actual3 = track.getRide(2);

        assertArrayEquals(result, actual);
        assertArrayEquals(result2, actual2);
        assertArrayEquals(result3, actual3);
    }

    @org.junit.jupiter.api.Test
    void removeClosedRides() {
        ThemeParkTracker track = new ThemeParkTracker();
        Ride result = new Ride("Zero",30, 10, "open");
        Ride result2 = new Ride("Waow",10, 3, "closed");
        Ride result3 = new Ride("Big Terry",53, 25, "open");
        track.addRide(result);
        track.addRide(result2);
        track.addRide(result3);

        track.removeClosedRides();

        assertEquals("open", track.getRide(0).getStatus());
        assertEquals("open", track.getRide(1).getStatus());
    }

    @org.junit.jupiter.api.Test
    void removeRide() {
        ThemeParkTracker track = new ThemeParkTracker();
        Ride result = new Ride("Zero",30, 10, "open");
        Ride result2 = new Ride("Waow",10, 3, "closed");
        Ride result3 = new Ride("Big Terry",53, 25, "open");
        track.addRide(result);
        track.addRide(result2);
        track.addRide(result3);

        track.removeRide(2);

        assertArrayEquals(result, track.getRide(0));
        assertArrayEquals(result2, track.getRide(1));
    }

    @org.junit.jupiter.api.Test
    void sortByWaitTime() {
        ThemeParkTracker track = new ThemeParkTracker();
        Ride result = new Ride("Zero",30, 10, "open");
        Ride result2 = new Ride("Waow",10, 3, "closed");
        Ride result3 = new Ride("Big Terry",53, 25, "open");
        track.addRide(result);
        track.addRide(result2);
        track.addRide(result3);

        track.sortByWaitTime();

        assertArrayEquals(result2, track.getRide(0));
        assertArrayEquals(result, track.getRide(1));
        assertArrayEquals(result3, track.getRide(2));
    }

    @org.junit.jupiter.api.Test
    void findRideStatus() {
        ThemeParkTracker track = new ThemeParkTracker();
        Ride result = new Ride("Zero",30, 10, "open");
        Ride result2 = new Ride("Waow",10, 3, "closed");
        Ride result3 = new Ride("Big Terry",53, 25, "open");
        track.addRide(result);
        track.addRide(result2);
        track.addRide(result3);

        String actual = track.findRideStatus("Zero");
        String actual2 = track.findRideStatus("Waow");
        String actual3 = track.findRideStatus("Big Terry");

        assertEquals("open", actual);
        assertEquals("closed", actual2);
        assertEquals("open", actual3);
    }
}