package com.iterator;
import com.trippy.entity.Itinerary;

import java.util.Iterator;
import java.util.List;


public class ItinerarysRepository implements IContainer {

    private List<Itinerary> itineraries;

    public ItinerarysRepository(List<Itinerary> itineraries) {
        this.itineraries = itineraries;
    }

    @Override
    public CollectionofNamesIterate getIterator() {
        return new CollectionofNamesIterate(this);
    }

    public static class CollectionofNamesIterate implements Iterator<Itinerary> {
        private int currentElement = 0;
        private ItinerarysRepository itinerarysRepository;


        public CollectionofNamesIterate(ItinerarysRepository itinerarysRepository) {
            this.itinerarysRepository = itinerarysRepository;
        }

        @Override
        public boolean hasNext() {
            if (currentElement < itinerarysRepository.itineraries.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Itinerary next() {
            if (this.hasNext()) {
                return itinerarysRepository.itineraries.get(currentElement++);
            }
            return null;
        }
    };
}
