package city;

import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public void addBuilding(Building building) {
        if (fullArea > getBuildingAreaSum() + building.getArea()) {
            buildings.add(building);
        } else {
            throw new IllegalArgumentException("City can't be larger than "+fullArea);
        }
    }

    public Building findHighestBuildingInCity() {
        int max = 0;
        for (Building b :
                buildings) {
            if (b.getLevels() > max) {
                max = b.getLevels();
            }
        }
        for (Building b :
                buildings) {
            if (b.getLevels() == max) {
                return b;
            }
        }
        return buildings.get(0);
    }

    public List<Building> findBuildingsByStreet(String street) {
        List<Building> result = new ArrayList<>();
        for (Building b :
                buildings) {
            if (b.getAddress().getStreet().equals(street)) {
                result.add(b);
            }
        }
        return result;
    }

    public boolean isThereBuildingWithMorePeopleThan(int numberOfPeople){
        for (Building b :
                buildings) {
            if (numberOfPeople < b.calculateNumberOfPeopleCanFit()) {
                return true;
            }
            }
        return false;
    }

    private int getBuildingAreaSum(){
        int sum = 0;
        for (Building b :
                buildings) {
            sum+=b.getArea();
        }
        return sum;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }
}
