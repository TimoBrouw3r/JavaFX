package nl.saxion.re.types;

import java.time.LocalDate;

/**
 * Quotation
 */
public class Quotation {

	private int amountOfSolarPanels;
	private LocalDate date;
	private String clientName;
	private String clientAddress;
	private boolean meterChangeNeeded;
    private TransformerType transformerType;

	public Quotation(
			int amountOfSolarPanels,
            LocalDate date, 
            String customer_name, 
            String customer_address,
			boolean meterChangeNeeded
        ) {
		
        this.amountOfSolarPanels = amountOfSolarPanels;
		this.date = date;
		this.clientName = customer_name;
		this.clientAddress = customer_address;
		this.meterChangeNeeded = meterChangeNeeded;
	}


    public int getPriceInCents() {
        int price = 1000;
        price += amountOfSolarPanels * 200;
        price += meterChangeNeeded ? 800 : 0;
        price += transformerType.price;
        return price;
    }


    public int getAmountOfSolarPanels() {
        return amountOfSolarPanels;
    }


    public LocalDate getDate() {
        return date;
    }


    public boolean isMeterChangeNeeded() {
        return meterChangeNeeded;
    }


    public TransformerType getTransformerType() {
        return transformerType;
    }


    public String getClientName() {
        return clientName;
    }


    public String getClientAddress() {
        return clientAddress;
    }

}
