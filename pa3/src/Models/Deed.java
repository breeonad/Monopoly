package Models;

public class Deed extends Tile{

    //final deed variables
    private final int saleValue;
    private final int propertySet;
    private final int baseRent;
    private final int rentWithColorSet;
    private final int rentWithOneHouse;
    private final int rentWithTwoHouses;
    private final int rentWithThreeHouses;
    private final int rentWithFourHouses;
    private final int rentWithHotel;
    private final int mortgageValue;
    private final int houseCost;
    private final int hotelCost;


    //ownership variables
    private Player owner = null;
    private int houses = 0;
    private boolean mortgaged = false;

    //constructor
    public Deed(int saleValue, int propertySet, int baseRent,
                int rentWithOneHouse, int rentWithTwoHouses, int rentWithThreeHouses, int rentWithFourHouses,
                int rentWithHotel, int mortgageValue,
                int houseCost, int hotelCost,
                String name, int position){

        this.saleValue = saleValue;
        this.propertySet = propertySet;
        this.baseRent = baseRent;
        this.rentWithColorSet = baseRent*2;
        this.rentWithOneHouse = rentWithOneHouse;
        this.rentWithTwoHouses = rentWithTwoHouses;
        this.rentWithThreeHouses = rentWithThreeHouses;
        this.rentWithFourHouses = rentWithFourHouses;
        this.rentWithHotel = rentWithHotel;
        this.mortgageValue = mortgageValue;
        this.houseCost = houseCost;
        this.hotelCost = hotelCost;

        //parent class variables
        super.name = name;
        super.type = "Deed";
        super.position = position;
    }

    //****************GETTERS************************************
    //returns the value of a property's mortgage
    public int getMortgageValue(){
        return mortgageValue;
    }

    /*returns the color set of the property
     *legend:
     * 0: brown
     * 1: light blue
     * 2: pink
     * 3: orange
     * 4: red
     * 5: yellow
     * 6: green
     * 7: dark blue
     * 8: RR
     * 9: Utility
     */
    public int getPropertySet(){
        return propertySet;
    }

    //returns the sale price of a property
    public int getPrice(){
        return saleValue;
    }

    /**
     * returns the upgrade cost of a property, or zero if property cannot be upgraded
     * (how much to add a house or hotel)
     */

    public int getUpgradeCost(){
        if(houses < 5 && houses > 0) {
            return houseCost;
        }
        else if(houses == 5) {
            return hotelCost;
        }
        else{
            return 0;
        }
    }
    
  //returns owner of space if there is an owner, or returns null if there is no owner
    public Player getOwner(){
        if (owner != null){
            return owner;
        }
        else
            return null;
    }

    /**
     *
     * @return gives the value of houses, where
     * 1 = color set achived
     * 2-5 = number of houses
     * 6 = hotel
     */
    public int getHouses(){
        return houses;
    }

    public boolean getMortagaged(){
        return mortgaged;
    }

    //****************SETTERS************************************
    //sets owner of property
    public void setOwner(Player possessor){
        owner = possessor;
    }

    //adds a house or hotel to a property
    //1 indicates full propertySet
    //6 indicates hotel
    public void setHouses(){
        if(houses < 6){
            houses++;
        }
    }

    public void setUnMortagaged(){
        mortgaged = false;
    }

    public void setMortagaged(){
        mortgaged = true;
    }


    //****************METHODS************************************
    //returns the rent amount, depending on the number of houses/hotels present on a property
    public int calcRent(){
        if(mortgaged){
            return 0;
        }
        switch(houses){
            case 1:
                return rentWithColorSet;
            case 2:
                return rentWithOneHouse;
            case 3:
                return rentWithTwoHouses;
            case 4:
                return rentWithThreeHouses;
            case 5:
                return rentWithFourHouses;
            case 6:
                return rentWithHotel;
            default:
                return baseRent;

        }
    }

}
