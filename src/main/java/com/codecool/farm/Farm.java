package com.codecool.farm;

import com.codecool.farm.animal.Animal;
import com.codecool.farm.animal.Pig;

import java.util.ArrayList;
import java.util.List;

class Farm {
    private final List<Animal> animals;

    public Farm(List<Animal> animals) {
        this.animals = animals;
    }

    public void feedAnimals() {
        for (Animal animal : animals) {
            animal.feed();
        }
    }

    public void butcher(Butcher butcher) {
        this.animals.removeIf(butcher::canButcher);
    }

    public boolean isEmpty() {
        return this.animals.isEmpty();
    }

    public List<String> getStatus() {
        List<String> statusList = new ArrayList<>();
        for (Animal animal : this.animals) {
            statusList.add("There is a " + animal.getSize() + " sized " + animalType(animal) + " in the farm.");
        }
        return statusList;
    }

    private String animalType(Animal animal) {
        if (animal instanceof Pig) {
            return "pig";
        } else {
            return "cattle";
        }
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }
}
