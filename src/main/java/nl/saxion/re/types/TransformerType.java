

package nl.saxion.re.types;

/**
 * TransformerType
 */
public enum TransformerType {
    None(0), 
    SB2000(400), 
    SB5000(600),
    SB6000(800),
    SB8000(1000),
    SB12000(1500); 

    public final int price;

    private TransformerType(int price) {
        this.price = price;
    }
	
}
