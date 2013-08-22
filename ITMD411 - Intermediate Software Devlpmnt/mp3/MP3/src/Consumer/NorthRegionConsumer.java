package Consumer;

import Producer.ProducerChild;

/**
 * This class represents the north region.It implements the getRegion() Method
 * declared as abstract in its parent ProductConsumer Class.
 * 
 * @author Tejal
 */
public class NorthRegionConsumer extends ProductConsumer{
    
    public NorthRegionConsumer()
    {}
    public NorthRegionConsumer(ProducerChild prodChild) {
		super(prodChild);
	} 
    @Override
	public synchronized char getRegion() {
		return 'N';
	} 
}
