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
    public CollectionOfIitnaries getIterator() {
        return new CollectionOfIitnaries(this);
    }

    public static class CollectionOfIitnaries implements Iterator<Itinerary> {
        private int currentElement = 0;
        private ItinerarysRepository itinerarysRepository;


        public CollectionOfIitnaries(ItinerarysRepository itinerarysRepository) {
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
