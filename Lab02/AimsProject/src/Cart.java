
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	public DigitalVideoDisc itemsOrdered[] = 
			new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }
	
//	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
//	    for (DigitalVideoDisc disc : dvdList) {
//	        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
//	            itemsOrdered[qtyOrdered] = disc;
//	            qtyOrdered++;
//	        } else {
//	            System.out.println("The cart is full. Cannot add more discs.");
//	            break;
//	        }
//	    }
//	    System.out.println("The DVDs have been added.");
//	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
	    for (DigitalVideoDisc disc : dvdList) {
	        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
	            itemsOrdered[qtyOrdered] = disc;
	            qtyOrdered++;
	        } else {
	            System.out.println("The cart is full. Cannot add more discs.");
	            break;
	        }
	    }
	    System.out.println("The DVDs have been added.");
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
	    if (qtyOrdered < MAX_NUMBERS_ORDERED) {
	        itemsOrdered[qtyOrdered] = dvd1;
	        qtyOrdered++;
	    } else {
	        System.out.println("The cart is full. Cannot add more discs.");
	        return;
	    }

	    if (qtyOrdered < MAX_NUMBERS_ORDERED) {
	        itemsOrdered[qtyOrdered] = dvd2;
	        qtyOrdered++;
	    } else {
	        System.out.println("The cart is full. Cannot add more discs.");
	    }

	    System.out.println("The DVDs have been added.");
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].getTitle().equals(disc.getTitle())) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("The disc has been removed.");
        } else {
            System.out.println("The disc is not found in the cart.");
        }
    }
	
	public float totalCost() {
        float total = 0.00f;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost(); 
        }
        return total;
    }
	
	public void displayCartItems() {
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println((i + 1) + ". " + itemsOrdered[i].getTitle() +
            		" " + itemsOrdered[i].getCost());
        }
    }
}
