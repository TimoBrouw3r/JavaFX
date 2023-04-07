package nl.saxion.re.types;

import java.time.LocalDate;

/**
 * 
 */
public class Task {
    private LocalDate date;
    private String clientName; 
    private String clientAddress;
    private Team team = null; 
    private boolean materialsOrdered = false;
    private int amountOfSolarPanels; 
    private boolean meterChangeNeeded;
    private TransformerType transformerType;

    public Task(LocalDate date, String clientName, String clientAddress, int priceInCents, int amountOfSolarPanels, boolean meterChangeNeeded, TransformerType transformerType) {
        this.date = date;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.amountOfSolarPanels = amountOfSolarPanels;
        this.meterChangeNeeded = meterChangeNeeded;
        this.transformerType = transformerType;
    }

    public Task(LocalDate date, String clientName, String clientAddress) {
        this.date = date;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.transformerType = TransformerType.SB6000;
        
    }


    public Task(Quotation quotation) {
        this.date = quotation.getDate();
        this.clientName = quotation.getClientName();
        this.clientAddress = quotation.getClientAddress();
        this.amountOfSolarPanels = quotation.getAmountOfSolarPanels();
        this.meterChangeNeeded = quotation.isMeterChangeNeeded();
        this.transformerType = quotation.getTransformerType();
    }

    public LocalDate getDate() {
        return date;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientAddress( ) {
        return clientAddress;
    }


    public Team getTeam() {
        return team;
    }

    public boolean isMaterialsOrdered() {
        return materialsOrdered;
    }

    public void setMaterialsOrdered(boolean materialsOrdered) {
        this.materialsOrdered = materialsOrdered;
    }

    public static Task fromQuotation(Quotation quotation) {
        return new Task(
                quotation.getDate(), 
                quotation.getClientName(), 
                quotation.getClientAddress(), 
                quotation.getPriceInCents(),
                quotation.getAmountOfSolarPanels(),
                quotation.isMeterChangeNeeded(),
                quotation.getTransformerType()
                );
    }

    

    public void setTeam(Team team) {
    

        this.team = team;
        team.addTask(this);
    }

    public int getAmountOfSolarPanels() {
        return amountOfSolarPanels;
    }

    public String getTransformerType() {
        return transformerType.toString();
    }

    public boolean meterChangeNeeded() {
        return meterChangeNeeded;
    }
} 
