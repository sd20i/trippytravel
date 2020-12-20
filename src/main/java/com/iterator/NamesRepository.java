package com.iterator;
import com.trippy.entity.Itinerary;

import java.util.Iterator;
import java.util.List;


public class NamesRepository implements IContainer {

    private String names[] = { "Ajay", "Vijay", "Martin", "Racheal", "Kim" };
    private List<Itinerary> itineraries;

    public NamesRepository(List<Itinerary> itineraries) {
        super();
        this.itineraries = itineraries;
    }

    @Override
    public CollectionofNamesIterate getIterator() {
        return new CollectionofNamesIterate(this);
    }

    public List getItineraries() {
        return itineraries;
    }


    public static class CollectionofNamesIterate implements Iterator<Itinerary> {
        private int currentElement = 0;
        private NamesRepository namesRepository;


        public CollectionofNamesIterate(NamesRepository namesRepository) {
            super();
            this.namesRepository = namesRepository;
        }

        @Override
        public boolean hasNext() {
            if (currentElement < namesRepository.itineraries.size()) {
                return true;
            }
            return false;
        }

        @Override
        public Itinerary next() {
            if (this.hasNext()) {
                return namesRepository.itineraries.get(currentElement++);
            }
            return null;
        }
    };
}
