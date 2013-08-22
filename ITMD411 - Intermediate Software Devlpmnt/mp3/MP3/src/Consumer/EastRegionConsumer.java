package Consumer;

import Producer.ProducerChild;

/**
 * This class represents the east region.It implements the getRegion() Method
 * declared as abstract in its parent ProductConsumer Class.
 * 
 * @author Tejal
 */
public class EastRegionConsumer extends ProductConsumer{
     public EastRegionConsumer()
    {}
    public EastRegionConsumer(ProducerChild prodChild) {
		super(prodChild);
	} 
    @Override
	public synchronized char getRegion() {
		return 'E';
	} 
}
